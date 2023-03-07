package kim.site.category.service.impl;

import kim.site.category.domain.Category;
import kim.site.category.repository.CategoryRepository;
import kim.site.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        return categoryRepository.selectCategories();
    }
}
