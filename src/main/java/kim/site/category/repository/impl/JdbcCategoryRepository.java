package kim.site.category.repository.impl;

import kim.site.category.domain.Category;
import kim.site.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JdbcCategoryRepository implements CategoryRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Category> selectCategory() {
        final String QUERY = "SELECT * FROM CATEGORY ORDER BY ORDER_NUMBER";
        return jdbcTemplate.query(
            QUERY,
            (rs, rowNum) -> {
                return new Category(
                        rs.getString("ID"),
                        rs.getString("PARENT_ID"),
                        rs.getShort("ORDER_NUMBER"),
                        rs.getBoolean("IS_ROOT"),
                        rs.getString("URL"),
                        rs.getString("TITLE"),
                        rs.getTimestamp("CREATED_AT").toLocalDateTime().toLocalDate(),
                        rs.getTimestamp("MODIFIED_AT").toLocalDateTime().toLocalDate()
                        );
            }
        );
    }

    @Override
    public Category selectCategoryByUrl(String url) {
        final String QUERY = "SELECT * FROM CATEGORY WHERE URL=?";

        return jdbcTemplate.queryForObject(
                QUERY,
                (rs, rowNum) -> {
                    return new Category(
                            rs.getString("ID"),
                            rs.getString("PARENT_ID"),
                            rs.getShort("ORDER_NUMBER"),
                            rs.getBoolean("IS_ROOT"),
                            rs.getString("URL"),
                            rs.getString("TITLE"),
                            rs.getTimestamp("CREATED_AT").toLocalDateTime().toLocalDate(),
                            rs.getTimestamp("MODIFIED_AT").toLocalDateTime().toLocalDate()
                    );
                },
                url
        );
    }
}
