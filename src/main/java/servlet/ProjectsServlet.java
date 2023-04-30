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
import java.util.ArrayList;
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
                req.setAttribute("jobs",jobs);
                System.out.println(req.getAttribute("ava"));
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
                List<JobsModel> jobs=projectsService.countAllJobs();
                String email ="";
                for (Cookie cookie :cookies
                     ) {
                    if (cookie.getName().equals("username"))
                    {
                        email = cookie.getValue();
                    }
                }
                System.out.println("Email is :"+email );
                int notStarted = taskService.countAllStatusGroupByStatusId(1);
                int inProcessed = taskService.countAllStatusGroupByStatusId(2);
                int finished = taskService.countAllStatusGroupByStatusId(3);
                req.setAttribute("notStarted", notStarted);
                req.setAttribute("inProcessed", inProcessed);
                req.setAttribute("finished", finished);
                req.setAttribute("email", email);
                req.setAttribute("projects", jobs);

                List<List<ProjectDetailModel>> listProjectDetail = projectsService.countAllStatusOfProject();
//                System.out.println("list not started : "+listProjectDetail.get(0).size());
//                System.out.println("list in started : "+listProjectDetail.get(1).size());
//                System.out.println("list finiish  : "+listProjectDetail.get(2).size());

                List<ProjectDetailModel > listName = projectsService.countDoers();
                System.out.println("list name is " +listName.size());
                req.setAttribute("listName", listName);
                req.setAttribute("listProjectDetail", listProjectDetail);
                List<String >listAva = new ArrayList<>();
                listAva.add("ava1.jpg");
                listAva.add("ava2.jpg");
                listAva.add("ava3.jpg");
                listAva.add("ava4.jpg");
                listAva.add("ava5.jpg");
                String ava = projectsService.getAva(email);
                req.setAttribute("ava", ava);
                req.setAttribute("listAva",listAva);
                req.getRequestDispatcher("/groupwork-details.jsp").forward(req,resp);
                break;
            }
        }

    }
}
