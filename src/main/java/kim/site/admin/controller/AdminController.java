package kim.site.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping
    public String admin(HttpSession session) {
        /*
        if (session.getAttribute("authority") == null || !session.getAttribute("authority").equals("admin")) {
            // ip 검사 -> true:signin / false:home
            return "/admin/signin";
        }
         */

        final String VIEW_PATH = "/admin/admin";
        return VIEW_PATH;
    }
}
