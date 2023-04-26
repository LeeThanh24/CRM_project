package servlet;

import model.RoleModel;
import service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TasksStatusJobsUsers Servlet", urlPatterns = {"/tasksStatusJobsUsers","/task-add"})
public class TasksStatusJobsUsersServlet extends HttpServlet {
    UsersService usersService= new UsersService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getServletPath();
        Cookie[]cookies = req.getCookies();
        String fullname = usersService.findNameUserByEmail(cookies).get(1);
        String firstName = usersService.getFirstName(fullname);
        req.setAttribute("firstName",firstName);
        switch (url)
        {
            case "/tasksStatusJobsUsers":
            {
                TasksStatusJobsUsersService tasksStatusJobsUsersService = new TasksStatusJobsUsersService();


                req.setAttribute("tasksStatusJobsUsers", tasksStatusJobsUsersService.countAllTasksStatusJobsUsers());

                req.getRequestDispatcher("task.jsp").forward(req, resp);
                break;
            }

            case "/task-add":
            {
                UsersService usersService = new UsersService();
                ProjectsService projectsService= new ProjectsService();
                StatusService statusService= new StatusService() ;
                req.setAttribute("users", usersService.countAllUsersByWithFullname());
                req.setAttribute("status", statusService.countAllStatusWithName());
                req.setAttribute("jobs", projectsService.countAllJobs());
                System.out.println( projectsService.countAllJobs().size());
                req.getRequestDispatcher("task-add.jsp").forward(req, resp);
                break ;
            }
        }



    }
}
