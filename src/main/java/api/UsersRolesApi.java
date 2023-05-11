package api;

import com.google.gson.Gson;
import payload.BasicResponse;
import service.UsersRolesService;
import service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name ="Users Roles Api" ,urlPatterns ={"/api/usersRoles","/api/usersRolesAdd","/api/usersRoles/delete","/api/usersRoles/update"} )
public class UsersRolesApi extends HttpServlet {
    UsersService usersService = new UsersService();
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
            case "/api/usersRoles/update":
            {
                System.out.println("da vao day : ");
                String fullname = req.getParameter("fullname");
                int roleId  = Integer.parseInt(req.getParameter("roleId"));
                String password = req.getParameter("password");
                String avatar = req.getParameter("avatar");

                System.out.println("fullname : "+fullname);
                System.out.println("roleId : "+roleId);
                System.out.println("password : "+password);
                System.out.println("avatar : "+avatar);
                Cookie[] cookies = req.getCookies() ;
                System.out.println("Cookie size " +cookies.length);
                String email = "" ;
                for (Cookie cookie :cookies
                     ) {
                    if (cookie.getName().equals("tempEmailForUserUpdate"))
                    {
                        email =cookie.getValue();
                        break;
                    }
//                    System.out.println(cookie.getName());
                }

                basicResponse= update(email,password,fullname,avatar,roleId);
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

    private BasicResponse update(String email , String password ,String fullname ,String avatar , int roleId)
    {
        BasicResponse basicResponse = new BasicResponse();

        basicResponse.setStatusCode(200);
        basicResponse.setData(usersService.updateUser(email,password,fullname,avatar,roleId));
        return basicResponse;
    }
}
