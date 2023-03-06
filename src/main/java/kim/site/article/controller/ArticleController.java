package kim.site.article.controller;

import kim.site.article.domain.Article;
import kim.site.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;


    @GetMapping
    public String articleView(@RequestParam String id, Model model) {
        final String VIEW_PATH = "/article/detail";

        Article article = articleService.getArticleForId(id);
        model.addAttribute("article", article);

        return VIEW_PATH;
    }

    @GetMapping("/category/{category}")
    public String categoryView(@PathVariable String category, Model model) {
        final String VIEW_PATH = "/article/category";

        model.addAttribute("category", category);
        model.addAttribute("articles", articleService.getArticleForCategory(category));

        return VIEW_PATH;
    }

    @GetMapping("/recent")
    public String recentView(Model model) {
        final String VIEW_PATH = "/article/recent";

        model.addAttribute("articles", articleService.getArticles(30));

        return VIEW_PATH;
    }
}
