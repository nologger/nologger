package kim.site.board.controller;

import kim.site.board.domain.Page;
import kim.site.board.service.BoardService;
import kim.site.category.domain.Category;
import kim.site.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    BoardService boardService;

    @GetMapping("/{title}")
    public String board(@PathVariable("title") String title, Model model) {
        final String URL = String.format("/board/%s", title);

        Category category = categoryService.getCategory(URL);
        List<Page> pages = boardService.getPages(category);

        model.addAttribute("category", category);
        model.addAttribute("pages", pages);

        return "/board";
    }

    @GetMapping("/{title}/view")
    public String view(@PathVariable("title") String title, String id, Model model) {
        final String URL = String.format("/board/%s", title);

        Category category = categoryService.getCategory(URL);
        Page page = boardService.getPage(id);

        model.addAttribute("category", category);
        model.addAttribute("page", page);

        return "/page";
    }
}
