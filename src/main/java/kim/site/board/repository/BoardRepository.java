package kim.site.board.repository;

import kim.site.board.domain.Page;
import kim.site.category.domain.Category;

import java.util.List;

public interface BoardRepository {
    public List<Page> selectPagesByCategory(Category category);
    public Page selectPageById(String id);
}
