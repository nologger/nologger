package kim.site.article.controller;

import kim.site.article.domain.Article;
import kim.site.article.service.ArticleService;
import kim.site.category.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;
    @Autowired
    CategoryService categoryService;


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

    @GetMapping("/uncategory")
    public String uncategoryView(Model model) {
        final String VIEW_PATH = "/article/category";

        model.addAttribute("category", "uncategory");
        model.addAttribute("articles", articleService.getArticleForUncategory());

        return VIEW_PATH;
    }


    /**
     * 관리자 글쓰기 페이지 이동
     * @return
     */
    @GetMapping("/write")
    public String writeView(Model model) {
        final String VIEW_PATH = "/article/write";

        model.addAttribute("categories", categoryService.getCategories().stream().map(n -> n.getId()).toArray());

        return VIEW_PATH;
    }

    /**
     * 관리자 글 등록
     * @return
     */
    @PostMapping("/write")
    public String write(Article article, HttpSession session) {
        final String VIEW_PATH = "redirect:/";

        if (session.getAttribute("member") == null) {
            return VIEW_PATH;
        }

        // mdService.validationMarkdownSyntax(article);
        log.info("article content: {}", article.getContent());
        articleService.registerArticle(article);

        return VIEW_PATH;
    }
}
