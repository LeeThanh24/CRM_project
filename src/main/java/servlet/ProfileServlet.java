package servlet;

import model.ProjectDetailModel;
import repository.UsersRepository;
import service.ProjectsService;
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
import java.util.List;

@WebServlet(name = "Profile Servlet" ,urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet {
    UsersService usersService = new UsersService();
    TaskService taskService = new TaskService();
    ProjectsService projectsService= new ProjectsService();
    TasksStatusJobsUsersService tasksStatusJobsUsersService = new TasksStatusJobsUsersService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[]cookies = req.getCookies();
        String email = usersService.findNameUserByEmail(cookies).get(0);
        String fullname = usersService.findNameUserByEmail(cookies).get(1);
        int notStarted = taskService.percentProfile(email).get(0);
        int inProcessed = taskService.percentProfile(email).get(1);
        int finished = taskService.percentProfile(email).get(2);
        req.setAttribute("notStarted",notStarted);
        req.setAttribute("inProcessed",inProcessed);
        req.setAttribute("finished",finished);

        List<ProjectDetailModel> listName = projectsService.countDoers();

        req.setAttribute("email", email);
        String ava = projectsService.getAva(listName,email);
        req.setAttribute("ava",ava);

        req.setAttribute("listName", listName);


        String firstName = usersService.getFirstName(fullname);
        req.setAttribute("firstName",firstName);

        req.setAttribute("fullname",fullname);
        req.setAttribute("email",email);

        req.setAttribute("tasksStatusJobsUsersByEmail", tasksStatusJobsUsersService.countAllTasksStatusJobsUsersByEmail(email));
        req.getRequestDispatcher("/profile.jsp").forward(req,resp);
    }
}
