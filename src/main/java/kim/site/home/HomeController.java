package kim.site.home;

import kim.site.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    ArticleService articleService;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("articles", articleService.getArticles(30));
        return "/index";
    }

    @RequestMapping("/about")
    public String about() {
        return "/about";
    }
}
