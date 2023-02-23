package kim.site.board.service;

import kim.site.board.domain.Page;
import kim.site.category.domain.Category;

import java.util.List;

public interface BoardService {
    public List<Page> getPages(Category category);
    public Page getPage(String id);
}
