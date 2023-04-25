package servlet;

import model.JobsModel;
import service.ProjectsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="Projects Servlet" ,urlPatterns = "/jobs")
public class ProjectsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProjectsService projectsService= new ProjectsService();
        List<JobsModel> jobs=projectsService.countAllJobs();
        for (JobsModel job: jobs
             ) {
            System.out.println(job.getStart_date());
        }
        req.setAttribute("jobs",jobs);
        req.getRequestDispatcher("groupwork.jsp").forward(req,resp);
    }
}
