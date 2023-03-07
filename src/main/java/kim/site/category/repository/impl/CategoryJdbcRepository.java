package kim.site.category.repository.impl;

import kim.site.category.domain.Category;
import kim.site.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryJdbcRepository implements CategoryRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public List<Category> selectCategories() {
        final String QUERY = "SELECT * FROM CATEGORY";
        return jdbcTemplate.query(
                QUERY,
                (rs, rowNum) -> {
                    return new Category(
                        rs.getString("id"),
                        rs.getTimestamp("created_at").toLocalDateTime().toLocalDate(),
                        rs.getTimestamp("modified_at").toLocalDateTime().toLocalDate()
                    );
                }
        );
    }
}
