package filter;

import service.ProjectsService;
import service.UsersService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//urlPatters : Những link khi người dùng gọi sẽ kích hoạt filter
@WebFilter(urlPatterns = {"/roles", "/roleAdd","/roleUpdate", "/index.jsp","/index", "/usersRoles" ,"/user-add","/user/detail","/userChooseEmail","/userUpdate", "/jobs","/jobAdd","/jobDetail","/jobUpdate", "/tasksStatusJobsUsers","/taskUpdate", "/blank", "/404.jsp","/tasksStatusJobsUsers","/task-add","/profile"})
public class CustomFilter implements Filter {

//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
//    }

    ProjectsService projectsService = new ProjectsService() ;

    UsersService usersService = new UsersService() ;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        System.out.println("Đây là filter " + request.getServletPath());
        Cookie[] cookies = request.getCookies();
        System.out.println("Cookie size :"+cookies.length);
        String email = "";

            if (cookies != null && cookies.length > 0) {
                boolean isLogin = false;

                for (Cookie cookie : cookies) {
                    if ("username".equals(cookie.getName())) {
                        isLogin = true;
                        email = cookie.getValue();

                        break;
                    } else {
                        isLogin = false;
                    }
                }

                if (isLogin) {

                    String ava = projectsService.getAva(email);
                    System.out.println(" co ava ko " +ava);
                    if (ava.isEmpty() || ava.equals(""))
                    {
                        response.sendRedirect(request.getContextPath() + "/login");
                        return ;
                    }
                    String fullname = usersService.findNameUserByEmail(cookies).get(1);
                    String firstName = usersService.getFirstName(fullname);

                    request.setAttribute("ava", ava);
                    request.setAttribute("firstName", firstName);

                    if (request.getServletPath().equals("/index.jsp"))
                    {
                        response.sendRedirect(request.getContextPath() + "/index");
                        return ;
                    }else
                    {
                        System.out.println("Go to filter chain with ava "+ava);
                        filterChain.doFilter(request, response);
                        return ;
                    }

                } else {
                    System.out.println("ko co islogin");
                    response.sendRedirect(request.getContextPath() + "/login");
                }
            } else {
                System.out.println("ko co islogin");

                response.sendRedirect(request.getContextPath() + "/login");
            }
//        }


        //Cho phép truy cập vào servlet được chỉ định ở urlPattern
//        filterChain.doFilter(request,response);
    }

}
