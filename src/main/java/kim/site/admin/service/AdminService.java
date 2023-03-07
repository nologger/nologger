package kim.site.admin.service;

import kim.site.admin.domain.Admin;

import javax.servlet.http.HttpServletRequest;

public interface AdminService {
    String getClientIpAddress(HttpServletRequest request);
    boolean isAccessibleIpAddress(String ipAddress);
    Admin signIn(Admin admin);
    void signOut();
}
