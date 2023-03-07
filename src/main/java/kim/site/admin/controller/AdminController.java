package kim.site.admin.controller;

import kim.site.admin.domain.Admin;
import kim.site.admin.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @GetMapping
    public String admin(HttpServletRequest request, HttpSession session) {
        final String ADMIN_PATH = "/admin/admin";
        final String SIGN_IN_PATH = "/admin/signin";
        final String REDIRECT_HOME = "redirect:/";

        Admin admin = (Admin) session.getAttribute("member");
        if (admin != null) {
            return ADMIN_PATH;
        }

        String ipAddress = adminService.getClientIpAddress(request);
        if (adminService.isAccessibleIpAddress(ipAddress)) {
            log.info("unauthorized ip address: {}", ipAddress);
            return SIGN_IN_PATH;
        }

        return REDIRECT_HOME;
    }

    @PostMapping("/signin")
    public String signIn(HttpServletRequest request, HttpSession session, Admin admin) {
        final String ADMIN_PATH = "/admin/admin";
        final String REDIRECT_HOME = "redirect:/";

        String ipAddress = adminService.getClientIpAddress(request);
        if (adminService.isAccessibleIpAddress(ipAddress)) {
            try {
                admin.setAccessIpAddress(adminService.getClientIpAddress(request));
                admin = adminService.signIn(admin);
                session.setAttribute("member", admin);
                return ADMIN_PATH;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return REDIRECT_HOME;
    }
}
