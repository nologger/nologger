package kim.site.category.service.impl;

import kim.site.category.domain.Category;
import kim.site.category.repository.CategoryRepository;
import kim.site.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        List<Category> categories = categoryRepository.selectCategory();
        List<Category> reformatCategories = new ArrayList<>();
        for (Category category : categories) {
            for (Category subCategory : categories) {
                if (category.isChild(subCategory)) {
                    category.addChild(subCategory);
                }
            }

            if (category.isRoot()) {
                reformatCategories.add(category);
            }
        }
        return reformatCategories;
    }

    @Override
    public Category getCategory(String url) {
        return categoryRepository.selectCategoryByUrl(url);
    }
}
