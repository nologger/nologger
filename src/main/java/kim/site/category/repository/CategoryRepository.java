package kim.site.category.repository;

import kim.site.category.domain.Category;

import java.util.List;

public interface CategoryRepository {
    public List<Category> selectCategory();
    public Category selectCategoryByUrl(String url);
}
