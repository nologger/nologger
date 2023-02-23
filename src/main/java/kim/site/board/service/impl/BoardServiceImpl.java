package kim.site.board.service.impl;

import kim.site.board.domain.Page;
import kim.site.board.repository.BoardRepository;
import kim.site.board.service.BoardService;
import kim.site.category.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    BoardRepository boardRepository;

    @Override
    public List<Page> getPages(Category category) {
        return boardRepository.selectPagesByCategory(category);
    }

    @Override
    public Page getPage(String id) {
        return boardRepository.selectPageById(id);
    }
}
