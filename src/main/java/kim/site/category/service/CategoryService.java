package kim.site.category.service;

import kim.site.category.domain.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> getCategories();
    public Category getCategory(String url);
}
