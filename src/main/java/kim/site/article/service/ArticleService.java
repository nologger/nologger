package kim.site.article.service;

import kim.site.article.domain.Article;

import java.util.List;

public interface ArticleService {
    List<Article> getArticleForCategory(String category);
    List<Article> getArticles(int number);
    Article getArticleForId(String id);
}
