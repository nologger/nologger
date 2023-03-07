package kim.site.article.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class Article {
    private String id;
    private String writer;
    private String title;
    private String category;
    private String content;
    private LocalDate createdAt;
    private LocalDate modifiedAt;
}
