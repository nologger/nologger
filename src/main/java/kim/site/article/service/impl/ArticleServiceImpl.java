package kim.site.article.service.impl;

import kim.site.article.domain.Article;
import kim.site.article.repository.ArticleRepository;
import kim.site.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleRepository articleRepository;

    @Override
    public List<Article> getArticleForCategory(String category) {
        return articleRepository.selectArticleForCategory(category);
    }

    @Override
    public List<Article> getArticles(int number) {
        return articleRepository.selectNumberArticles(number);
    }

    @Override
    public List<String> getCategories() {
        return articleRepository.selectCategories();
    }

    @Override
    public Article getArticleForId(String id) {
        return articleRepository.selectArticleForId(id);
    }

    @Override
    public void registerArticle(Article article) {
        articleRepository.insertArticle(article);
    }
}
