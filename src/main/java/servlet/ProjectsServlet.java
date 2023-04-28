package servlet;

import model.JobsModel;
import model.ProjectDetailModel;
import service.ProjectsService;
import service.TaskService;
import service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="Projects Servlet" ,urlPatterns = {"/jobs","/jobAdd","/jobDetail"})
public class ProjectsServlet extends HttpServlet {
    UsersService usersService= new UsersService();
    TaskService taskService = new TaskService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProjectsService projectsService= new ProjectsService();
        String url = req.getServletPath();
        Cookie[]cookies = req.getCookies();
        String fullname = usersService.findNameUserByEmail(cookies).get(1);
        String firstName = usersService.getFirstName(fullname);
        req.setAttribute("firstName",firstName);
        switch (url)
        {
            case "/jobs" :
            {
                List<JobsModel> jobs=projectsService.countAllJobs();

                for (JobsModel job: jobs
                ) {
                    System.out.println(job.getStart_date());
                }
                req.setAttribute("jobs",jobs);
                req.getRequestDispatcher("/groupwork.jsp").forward(req,resp);
                break;
            }
            case "/jobAdd" :
            {

                req.getRequestDispatcher("/groupwork-add.jsp").forward(req,resp);
                break;
            }
            case "/jobDetail":
            {
                int notStarted = taskService.countAllStatusGroupByStatusId(1);
                int inProcessed = taskService.countAllStatusGroupByStatusId(2);
                int finished = taskService.countAllStatusGroupByStatusId(3);
                req.setAttribute("notStarted", notStarted);
                req.setAttribute("inProcessed", inProcessed);
                req.setAttribute("finished", finished);

                List<List<ProjectDetailModel>> listProjectDetail = projectsService.countAllStatusOfProject();
                List<String > listName = projectsService.countDoers();
                System.out.println("list name is " +listName.size());
                req.setAttribute("listName", listName);
                req.setAttribute("listProjectDetail", listProjectDetail);
                req.getRequestDispatcher("/groupwork-details.jsp").forward(req,resp);
                break;
            }
        }

    }
}
