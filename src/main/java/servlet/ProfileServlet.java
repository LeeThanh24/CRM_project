package servlet;

import repository.UsersRepository;
import service.TaskService;
import service.TasksStatusJobsUsersService;
import service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Profile Servlet" ,urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet {
    UsersService usersService = new UsersService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaskService taskService = new TaskService();
        int notStarted = taskService.countAllStatusGroupByStatusId(1);
        int inProcessed = taskService.countAllStatusGroupByStatusId(2);
        int finished = taskService.countAllStatusGroupByStatusId(3);
        req.setAttribute("notStarted",notStarted);
        req.setAttribute("inProcessed",inProcessed);
        req.setAttribute("finished",finished);
        TasksStatusJobsUsersService tasksStatusJobsUsersService = new TasksStatusJobsUsersService();

        Cookie[]cookies = req.getCookies();
        String email = usersService.findNameUserByEmail(cookies).get(0);
        String fullname = usersService.findNameUserByEmail(cookies).get(1);

        String firstName = usersService.getFirstName(fullname);
        req.setAttribute("firstName",firstName);

        req.setAttribute("fullname",fullname);
        req.setAttribute("email",email);

        req.setAttribute("tasksStatusJobsUsers", tasksStatusJobsUsersService.countAllTasksStatusJobsUsers());
        req.getRequestDispatcher("/profile.jsp").forward(req,resp);
    }
}
