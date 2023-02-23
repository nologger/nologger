package kim.site.board.repository.impl;

import kim.site.board.domain.Page;
import kim.site.board.repository.BoardRepository;
import kim.site.category.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcBoardRepository implements BoardRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Page> selectPagesByCategory(Category category) {
        final String QUERY = "SELECT * FROM PAGE WHERE CATEGORY_ID=? ORDER BY CREATED_AT DESC";

        return jdbcTemplate.query(
                QUERY,
                (rs, rowNum) -> {
                    return new Page(
                      rs.getString("ID"),
                      rs.getString("CATEGORY_ID"),
                      rs.getString("TITLE"),
                      rs.getString("CONTENT"),
                      rs.getTimestamp("CREATED_AT").toLocalDateTime().toLocalDate(),
                      rs.getTimestamp("MODIFIED_AT").toLocalDateTime().toLocalDate()
                    );
                },
                category.getId()
        );
    }

    @Override
    public Page selectPageById(String id) {
        final String QUERY = "SELECT * FROM PAGE WHERE ID=?";
        return jdbcTemplate.queryForObject(
                QUERY,
                (rs, rowNum) -> {
                    return new Page(
                            rs.getString("ID"),
                            rs.getString("CATEGORY_ID"),
                            rs.getString("TITLE"),
                            rs.getString("CONTENT"),
                            rs.getTimestamp("CREATED_AT").toLocalDateTime().toLocalDate(),
                            rs.getTimestamp("MODIFIED_AT").toLocalDateTime().toLocalDate()
                    );
                },
                id
        );
    }
}
