package kim.site.article.controller;

import kim.site.article.domain.Article;
import kim.site.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 관리자 글쓰기 페이지 이동
     * @return
     */
    @GetMapping("/write")
    public String writeView(Model model) {
        // session 검증 필요 - 관리자권한

        final String VIEW_PATH = "/article/write";

        model.addAttribute("categories", articleService.getCategories());

        return VIEW_PATH;
    }

    /**
     * 관리자 글 등록
     * @return
     */
    @PostMapping("/write")
    public String write(Article article) {
        // session 검증 필요 - 관리자권한

        final String VIEW_PATH = "redirect:/article/recent";

        // mdService.validationMarkdownSyntax(article);
        articleService.registerArticle(article);

        return VIEW_PATH;
    }
}
