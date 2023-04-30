package servlet;

import filter.SeachFilter;
import service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="Blank servlet",urlPatterns = "/blank")
public class BlankServlet extends HttpServlet {
    UsersService usersService= new UsersService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[]cookies = req.getCookies();
        String fullname = usersService.findNameUserByEmail(cookies).get(1);
        String search = req.getParameter("search");
        SeachFilter seachFilter = new SeachFilter( search );
        String firstName = usersService.getFirstName(fullname);
        req.setAttribute("firstName",firstName);
        System.out.println("VALUE OF SEARCH in blank page : " +search);
        if (search !=null ) {
            resp.sendRedirect(req.getContextPath() + seachFilter.resultAfterSearch());
        } else {
            req.getRequestDispatcher("blank.jsp").forward(req, resp);
        }



    }
}
