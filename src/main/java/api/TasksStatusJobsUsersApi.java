package api;

import com.google.gson.Gson;
import model.JobsModel;
import model.TasksStatusJobsUsersModel;
import payload.BasicResponse;
import service.ProjectsService;
import service.TasksStatusJobsUsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "TasksStatusJobsUsers Api",urlPatterns = {"/api/tasksStatusJobsUsers/add","/api/tasksStatusJobsUsers/delete","/api/tasksStatusJobsUsers/update"})
public class TasksStatusJobsUsersApi extends HttpServlet {
    TasksStatusJobsUsersService tasksStatusJobsUsersService= new TasksStatusJobsUsersService();
    ProjectsService projectsService = new ProjectsService() ;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getServletPath();
        BasicResponse basicResponse= new BasicResponse();

        switch (url)
        {
            case "/api/tasksStatusJobsUsers/add":
            {
                String taskName = req.getParameter("taskName");
                String start = req.getParameter("start");
                String end = req.getParameter("end");
                int user_id = Integer.parseInt(req.getParameter("user_id"));
                int job_id = Integer.parseInt(req.getParameter("job_id"));
                int status_id = Integer.parseInt(req.getParameter("status_id"));
                basicResponse= addNewTasksStatusJobsUsers(taskName,start,end,user_id,job_id,status_id);
                break ;
            }

            case "/api/tasksStatusJobsUsers/update":
            {
                List<JobsModel> projects = projectsService.countAllJobs();


                String taskName = req.getParameter("taskName");
                String start = req.getParameter("start");
                String end = req.getParameter("end");
                int user_id = Integer.parseInt(req.getParameter("user_id"));
                int job_id = Integer.parseInt(req.getParameter("job_id"));
                int status_id = Integer.parseInt(req.getParameter("status_id"));
                String projectName = "" ;
                for (JobsModel project :projects
                     ) {
                    if (project.getId()== job_id)
                    {
                        projectName=project.getName();
                        break;
                    }
                }
                List<TasksStatusJobsUsersModel> tasks= tasksStatusJobsUsersService.countAllTasksStatusJobsUsers();
                for (TasksStatusJobsUsersModel item :tasks
                     ) {
                    if (item.getTaskName().equals(taskName) && item.getProjName().equals(projectName))
                    {
                        if (start.equals(""))
                        {
                            start = item.getStart();

                        }
                        if (end.equals(""))
                        {
                            end = item.getEnd();

                        }
                    }
                }

                basicResponse= update(taskName,start,end,user_id,job_id,status_id);
                break ;
            }
            case "/api/tasksStatusJobsUsers/delete":
            {
                int id = Integer.parseInt(req.getParameter("id"));
                basicResponse= deleteTaskById(id);
                break ;
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

    private BasicResponse addNewTasksStatusJobsUsers(String taskName ,String start ,String end , int user_id,int job_id,int status_id)
    {
        BasicResponse basicResponse= new BasicResponse();
        basicResponse.setStatusCode(200);
        basicResponse.setData(tasksStatusJobsUsersService.addNewTasksStatusJobsUsers(taskName,start,end,user_id,job_id,status_id));
        return basicResponse;
    }

    private BasicResponse deleteTaskById(int id )
    {
        BasicResponse basicResponse= new BasicResponse();
        basicResponse.setStatusCode(200);

        basicResponse.setData(tasksStatusJobsUsersService.deleteTaskById(id));
        tasksStatusJobsUsersService.updateAllById();
        return basicResponse;
    }

    private BasicResponse update(String taskName ,String start ,String end , int userId ,int jobId,int statusId  )
    {
        BasicResponse basicResponse= new BasicResponse();
        basicResponse.setStatusCode(200);
        basicResponse.setData(tasksStatusJobsUsersService.updateTasks(taskName,start,end,userId,jobId,statusId));

        return basicResponse;
    }
}
