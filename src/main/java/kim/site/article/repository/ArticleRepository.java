package kim.site.article.repository;

import kim.site.article.domain.Article;

import java.util.List;

public interface ArticleRepository {
    List<Article> selectArticleForCategory(String category);
    List<Article> selectNumberArticles(int number);
    List<String> selectCategories();
    Article selectArticleForId(String id);
    void insertArticle(Article article);
}
