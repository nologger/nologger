package kim.site.session;

import kim.site.category.domain.Category;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class HttpSessionService {
    private final String CATEGORIES = "categories";

    public boolean hasCategories(HttpSession session) {
        if (session.getAttribute(CATEGORIES) != null) {
            return true;
        }
        return false;
    }

    public void setCategories(HttpSession session, List<Category> categoryList) {
        session.setAttribute(CATEGORIES, categoryList);
    }
}
