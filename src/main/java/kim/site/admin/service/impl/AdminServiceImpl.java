package kim.site.admin.service.impl;

import kim.site.admin.domain.Admin;
import kim.site.admin.repository.AdminRepository;
import kim.site.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository;

    @Override
    public String getClientIpAddress(HttpServletRequest request) {
        String clientIp = null;
        boolean isIpInHeader = false;

        List<String> headerList = new ArrayList<>();
        headerList.add("X-Forwarded-For");
        headerList.add("HTTP_CLIENT_IP");
        headerList.add("HTTP_X_FORWARDED_FOR");
        headerList.add("HTTP_X_FORWARDED");
        headerList.add("HTTP_FORWARDED_FOR");
        headerList.add("HTTP_FORWARDED");
        headerList.add("Proxy-Client-IP");
        headerList.add("WL-Proxy-Client-IP");
        headerList.add("HTTP_VIA");
        headerList.add("IPV6_ADR");

        for (String header : headerList) {
            clientIp = request.getHeader(header);
            if (StringUtils.hasText(clientIp) && !clientIp.equals("unknown")) {
                isIpInHeader = true;
                break;
            }
        }

        if (!isIpInHeader) {
            clientIp = request.getRemoteAddr();
        }

        return clientIp;
    }

    @Override
    public boolean isAccessibleIpAddress(String ipAddress) {
        if (ipAddress == null || ipAddress.isEmpty() || ipAddress.isBlank()) {
            return false;
        }
        return adminRepository.isAccessibleIpAddress(ipAddress);
    }

    @Override
    public Admin signIn(Admin admin) {
        return adminRepository.selectAdmin(admin);
    }

    @Override
    public void signOut() {

    }
}
