package kim.site.admin.repository.impl;

import kim.site.admin.domain.Admin;
import kim.site.admin.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminJdbcRepository implements AdminRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Admin selectAdmin(Admin admin) {
        final String QUERY = "SELECT * FROM ADMIN_MEMBER WHERE ACCOUNT=? AND PASSWORD=? AND PIN_NUMBER=?" +
                "AND (IP_ADDRESS1=? OR IP_ADDRESS2=? OR IP_ADDRESS3=?)";

        return jdbcTemplate.queryForObject(
                QUERY,
                (rs, rowNum) -> {
                    admin.setId(rs.getString("id"));
                    return admin;
                },
                admin.getAccount(),
                admin.getPassword(),
                admin.getPinNumber(),
                admin.getAccessIpAddress(),
                admin.getAccessIpAddress(),
                admin.getAccessIpAddress()
        );
    }

    @Override
    public boolean isAccessibleIpAddress(String ipAddress) {
        final String QUERY = "SELECT COUNT(*) > 0 FROM ADMIN_MEMBER WHERE IP_ADDRESS1=? OR IP_ADDRESS2=? OR IP_ADDRESS3=?";
        return jdbcTemplate.queryForObject(
                QUERY,
                boolean.class,
                ipAddress,
                ipAddress,
                ipAddress
        );
    }
}
