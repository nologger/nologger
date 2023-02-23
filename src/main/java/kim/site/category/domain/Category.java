package kim.site.category.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class Category {
    final private String id;
    final private String parentId;
    final private short orderNumber;
    final private boolean isRoot;
    final private String url;
    final private String title;
    final private LocalDate createdAt;
    final private LocalDate modifiedAt;

    List<Category> childList = new ArrayList<>();

    public boolean isChild(Category category) {
        if (this.id.equals(category.getParentId())) {
            return true;
        }
        return false;
    }

    public void addChild(Category category) {
        if (this.isChild(category)) {
            this.childList.add(category);
        }
    }
}
