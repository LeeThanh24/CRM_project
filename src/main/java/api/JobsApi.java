package api;

import com.google.gson.Gson;
import payload.BasicResponse;
import service.ProjectsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "Jobs api", urlPatterns = {"/api/jobs", "/api/jobs/delete", "/api/jobs/add"})
public class JobsApi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getServletPath();
        BasicResponse basicResponse = new BasicResponse();

        switch (url) {
            case "/api/jobs": {

                basicResponse = countAllJobs();
                break;
            }
        }
        Gson gson = new Gson();
        String dataJson = gson.toJson(basicResponse); //Convert đối tượng hoặc mảng về data json tương ứng

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter printWriter = resp.getWriter();
        printWriter.print(dataJson);
        printWriter.flush();
        printWriter.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getServletPath();
        BasicResponse basicResponse = new BasicResponse();

        switch (url) {
            case "/api/jobs/delete": {
                int id = Integer.parseInt(req.getParameter("id"));
                basicResponse = deleteJob(id);
                break;
            }

            case "/api/jobs/add": {
                String name = req.getParameter("name");
                String start = null, end = null;
                start = req.getParameter("start");
                end = req.getParameter("end");

                basicResponse = addNewJob(name, start, end);
                break;
            }
        }
        Gson gson = new Gson();
        String dataJson = gson.toJson(basicResponse); //Convert đối tượng hoặc mảng về data json tương ứng

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter printWriter = resp.getWriter();
        printWriter.print(dataJson);
        printWriter.flush();
        printWriter.close();
    }

    private BasicResponse countAllJobs() {
        BasicResponse basicResponse = new BasicResponse();
        basicResponse.setStatusCode(200);

        ProjectsService projectsService = new ProjectsService();
        basicResponse.setData(projectsService.countAllJobs());
        return basicResponse;
    }

    private BasicResponse deleteJob(int id) {
        BasicResponse basicResponse = new BasicResponse();
        basicResponse.setStatusCode(200);

        ProjectsService projectsService = new ProjectsService();
        basicResponse.setData(projectsService.deleteJob(id));
        return basicResponse;
    }

    private BasicResponse addNewJob(String name, String start, String end) {
        BasicResponse basicResponse = new BasicResponse();
        basicResponse.setStatusCode(200);

        ProjectsService projectsService = new ProjectsService();
        basicResponse.setData(projectsService.addNewJob(name, start, end));
        return basicResponse;
    }
}
