package kim.site.interceptor;

import kim.site.category.service.CategoryService;
import kim.site.session.HttpSessionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
@Slf4j
public class CategoryInterceptor implements HandlerInterceptor {
    @Autowired
    HttpSessionService httpSessionService;
    @Autowired
    CategoryService categoryService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if (httpSessionService.hasCategories(session)) {
            return true;
        }
        httpSessionService.setCategories(session, categoryService.getCategories());
        log.info("----------------------set categories::: ", categoryService.getCategories().size());
        return true;
    }
}
