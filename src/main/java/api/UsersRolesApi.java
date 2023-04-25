package api;

import com.google.gson.Gson;
import payload.BasicResponse;
import service.UsersRolesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name ="Users Roles Api" ,urlPatterns ={"/api/usersRoles","/api/usersRolesAdd","/api/usersRoles/delete"} )
public class UsersRolesApi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getServletPath();
        BasicResponse basicResponse= new BasicResponse();

        switch (url)
        {
            case "/api/usersRoles":
            {
                basicResponse= countAllUsersRoles();
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getServletPath();
        BasicResponse basicResponse= new BasicResponse();

        switch (url)
        {
            case "/api/usersRolesAdd":
            {
                String fullname = req.getParameter("fullname");
                String email = req.getParameter("email");
                String password = req.getParameter("password");
                int role_id = Integer.parseInt(req.getParameter("role_id"));
                basicResponse= addNewUserRole(fullname,email,password,role_id);
                break ;
            }
            case "/api/usersRoles/delete":
            {
                int id = Integer.parseInt(req.getParameter("id"));
                basicResponse= deleteUserRoleById(id);
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

    private BasicResponse countAllUsersRoles()
    {
        BasicResponse basicResponse = new BasicResponse();
        UsersRolesService usersRolesService = new UsersRolesService();
        basicResponse.setStatusCode(200);
        basicResponse.setData(usersRolesService.countAllUsersRoles());
        return basicResponse;
    }

    private BasicResponse addNewUserRole(String fullname ,String email ,String password ,int roleId )
    {
        BasicResponse basicResponse = new BasicResponse();
        UsersRolesService usersRolesService = new UsersRolesService();
        basicResponse.setStatusCode(200);
        basicResponse.setData(usersRolesService.addNewUserRole(fullname, email, password, roleId));
        return basicResponse;
    }


    private BasicResponse deleteUserRoleById(int id  )
    {
        BasicResponse basicResponse = new BasicResponse();
        UsersRolesService usersRolesService = new UsersRolesService();
        basicResponse.setStatusCode(200);
        basicResponse.setData(usersRolesService.deleteUserRoleById(id));
        return basicResponse;
    }
}
