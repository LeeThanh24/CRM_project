package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//urlPatters : Những link khi người dùng gọi sẽ kích hoạt filter
@WebFilter(urlPatterns = {"/roles", "/index.jsp", "/usersRoles", "/jobs", "/tasksStatusJobsUsers", "/blank", "/404.jsp"})
public class CustomFilter implements Filter {

//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
//    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        System.out.println("Đây là filter " + request.getServletPath());
        Cookie[] cookies = request.getCookies();
        if (request.getServletPath().equals("/index.jsp")) {
            if (cookies != null && cookies.length > 0) {
                response.sendRedirect(request.getContextPath() + "/index");
                return;
            } else {
                response.sendRedirect(request.getContextPath() + "/login");
                return;
            }


        } else {

            if (cookies != null && cookies.length > 0) {
                boolean isLogin = false;
                for (Cookie cookie : cookies) {
                    if ("username".equals(cookie.getName())) {
                        isLogin = true;
                        break;
                    } else {
                        isLogin = false;
                    }
                }

                if (isLogin) {
                    filterChain.doFilter(request, response);
                } else {
                    response.sendRedirect(request.getContextPath() + "/login");
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/login");
            }
        }


        //Cho phép truy cập vào servlet được chỉ định ở urlPattern
//        filterChain.doFilter(request,response);
    }

}
