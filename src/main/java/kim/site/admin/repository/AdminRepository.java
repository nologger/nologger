package kim.site.admin.repository;

import kim.site.admin.domain.Admin;

import java.util.List;

public interface AdminRepository {
    Admin selectAdmin(Admin admin);
    boolean isAccessibleIpAddress(String ipAddress);
}
