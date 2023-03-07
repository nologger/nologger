package kim.site.category.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class Category {
    private String id;
    private LocalDate createdAt;
    private LocalDate modifiedAt;
}
