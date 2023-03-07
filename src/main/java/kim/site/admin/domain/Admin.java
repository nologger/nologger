package kim.site.admin.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Admin {
    private String id;
    private String account;
    private String password;
    private String pinNumber;
    private String ipAddress1;
    private String ipAddress2;
    private String ipAddress3;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    private String accessIpAddress;
}
