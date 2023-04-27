package servlet;

import service.TaskService;
import service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Index Servlet", urlPatterns = {"/index"})
public class IndexServlet extends HttpServlet {
    UsersService usersService = new UsersService();
    TaskService taskService = new TaskService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("go to index servlet");
        Cookie[] cookies = req.getCookies();

        String fullname = usersService.findNameUserByEmail(cookies).get(1);
        String firstName = usersService.getFirstName(fullname);
        req.setAttribute("firstName", firstName);

        int notStarted = taskService.countAllStatusGroupByStatusId(1);
        int inProcessed = taskService.countAllStatusGroupByStatusId(2);
        int finished = taskService.countAllStatusGroupByStatusId(3);
        req.setAttribute("notStarted", notStarted);
        req.setAttribute("inProcessed", inProcessed);
        req.setAttribute("finished", finished);

        req.getRequestDispatcher("/index.jsp").forward(req, resp);


    }
}
