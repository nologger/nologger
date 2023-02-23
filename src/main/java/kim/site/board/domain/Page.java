package kim.site.board.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
public class Page {
    final private String id;
    final private String categoryId;
    final private String title;
    final private String content;
    final private LocalDate createdAt;
    final private LocalDate modifiedAt;
}
