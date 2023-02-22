package kim.site.category.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class Category {
    final String id;
    final String parentId;
    final boolean isPageCategory;
    final short orderNumber;
    final String title;
    final String url;
    final boolean visible;
    final LocalDate createdAt;
    final LocalDate modifiedAt;

    List<Category> childList;
}
