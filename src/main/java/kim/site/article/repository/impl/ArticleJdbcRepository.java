package kim.site.article.repository.impl;

import kim.site.article.domain.Article;
import kim.site.article.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleJdbcRepository implements ArticleRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Article> selectArticleForCategory(String category) {
        final String QUERY = "SELECT * FROM ARTICLE WHERE CATEGORY=?";
        return jdbcTemplate.query(
                QUERY,
                (rs, rowNum) -> {
                    return new Article(
                            rs.getString("id"),
                            rs.getString("writer"),
                            rs.getString("title"),
                            rs.getString("category"),
                            rs.getString("content"),
                            rs.getTimestamp("created_at").toLocalDateTime().toLocalDate(),
                            rs.getTimestamp("modified_at").toLocalDateTime().toLocalDate()
                    );
                },
                category
        );
    }

    @Override
    public List<Article> selectNumberArticles(int number) {
        final String QUERY = "SELECT * FROM ARTICLE ORDER BY CREATED_AT DESC, ID DESC LIMIT ?";
        return jdbcTemplate.query(
                QUERY,
                (rs, rowNum) -> {
                    return new Article(
                            rs.getString("id"),
                            rs.getString("writer"),
                            rs.getString("title"),
                            rs.getString("category"),
                            rs.getString("content"),
                            rs.getTimestamp("created_at").toLocalDateTime().toLocalDate(),
                            rs.getTimestamp("modified_at").toLocalDateTime().toLocalDate()
                    );
                },
                number
        );
    }

    @Override
    public List<String> selectCategories() {
        final String QUERY = "SELECT DISTINCT CATEGORY FROM ARTICLE ORDER BY CATEGORY";
        return jdbcTemplate.query(
                QUERY,
                (rs, rowNum) -> {
                    return rs.getString("category");
                }
        );
    }

    @Override
    public Article selectArticleForId(String id) {
        final String QUERY = "SELECT * FROM ARTICLE WHERE ID=?";
        return jdbcTemplate.queryForObject(
                QUERY,
                (rs, rowNum) -> {
                    return new Article(
                            rs.getString("id"),
                            rs.getString("writer"),
                            rs.getString("title"),
                            rs.getString("category"),
                            rs.getString("content"),
                            rs.getTimestamp("created_at").toLocalDateTime().toLocalDate(),
                            rs.getTimestamp("modified_at").toLocalDateTime().toLocalDate()
                    );
                },
                id
        );
    }

    @Override
    public void insertArticle(Article article) {
        // to do : session에서 계정가져오기
        final String QUERY = "INSERT INTO ARTICLE VALUES(NEXT VALUE FOR ARTICLE_SEQUENCE, 'admin', ?, ?, ?, now(), now())";

        jdbcTemplate.update(QUERY, article.getTitle(), article.getCategory(), article.getContent());
    }
}
