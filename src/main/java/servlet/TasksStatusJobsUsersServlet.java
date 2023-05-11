package servlet;

import model.RoleModel;
import model.TasksStatusJobsUsersModel;
import service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TasksStatusJobsUsers Servlet", urlPatterns = {"/tasksStatusJobsUsers","/task-add", "/taskUpdate"})
public class TasksStatusJobsUsersServlet extends HttpServlet {
    UsersService usersService= new UsersService();
    RoleService roleService = new RoleService();
    ProjectsService projectsService= new ProjectsService();
    StatusService statusService= new StatusService() ;
    TasksStatusJobsUsersService tasksStatusJobsUsersService = new TasksStatusJobsUsersService();

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
                String taskSearch = (req.getParameter("subSearch"));
                List<TasksStatusJobsUsersModel> tasks = new ArrayList<>( );
                if (taskSearch == null || taskSearch.isEmpty()||roleService.validString(taskSearch,1).equals("")) {
                    tasks = tasksStatusJobsUsersService.countAllTasksStatusJobsUsers();
                } else if (roleService.validNumber(taskSearch) !=0) {

                    int id =roleService.validNumber(taskSearch);
                    tasks = tasksStatusJobsUsersService.filterTasks(id,taskSearch,taskSearch,taskSearch,taskSearch,taskSearch,taskSearch);

                }else
                {
                    tasks = tasksStatusJobsUsersService.filterTasks(0,taskSearch,taskSearch,taskSearch,taskSearch,taskSearch,taskSearch);
                }

                req.setAttribute("tasksStatusJobsUsers", tasks);

                req.getRequestDispatcher("task.jsp").forward(req, resp);
                break;
            }

            case "/task-add":
            {
                UsersService usersService = new UsersService();


                req.setAttribute("users", usersService.countAllUsersByWithFullname());
                req.setAttribute("status", statusService.countAllStatusWithName());
                req.setAttribute("jobs", projectsService.countAllJobs());
                System.out.println( projectsService.countAllJobs().size());
                req.getRequestDispatcher("task-add.jsp").forward(req, resp);
                break ;
            }

            case "/taskUpdate":
            {
                UsersService usersService = new UsersService();
                List<TasksStatusJobsUsersModel> tasks = tasksStatusJobsUsersService.countAllTasksStatusJobsUsers();
                req.setAttribute("users", usersService.countAllUsersByWithFullname());
                req.setAttribute("status", statusService.countAllStatusWithName());
                req.setAttribute("jobs", projectsService.countAllJobs());
                req.setAttribute("tasks",tasks);
                System.out.println( projectsService.countAllJobs().size());
                req.getRequestDispatcher("taskUpdate.jsp").forward(req, resp);
                break ;
            }
        }



    }
}
