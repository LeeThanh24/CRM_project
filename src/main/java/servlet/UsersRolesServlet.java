package servlet;

import model.RoleModel;
import model.UserModel;
import model.UserRoleModel;
import service.RoleService;
import service.UsersRolesService;
import service.UsersService;

import javax.management.relation.Role;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name= "Users Servlet" ,urlPatterns = {"/usersRoles","/user-add","/user/detail"})
public class UsersRolesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String url = req.getServletPath();
        System.out.println(url);
        String requestDispacther = "";
        switch (url)
        {
            case "/user/detail" :
            {
                UsersService usersRolesService = new UsersService();
                List <UserModel> userModels= usersRolesService.countAllUsersByWithFullname();
                req.setAttribute("users",userModels);

                req.getRequestDispatcher("user-details.jsp").forward(req,resp);

                break;
            }
            case "/usersRoles" :
            {
                UsersRolesService usersRolesService = new UsersRolesService();
                req.setAttribute("usersRoles",usersRolesService.countAllUsersRoles());
                requestDispacther="user-table.jsp";
                req.getRequestDispatcher("user-table.jsp").forward(req,resp);

                break;
            }

            case "/user-add":
            {
                RoleService roleService = new RoleService();
                List<RoleModel>roles = roleService.getAllRoles();
                req.setAttribute("roles",roles);
                requestDispacther="user-add.jsp";
                req.getRequestDispatcher("user-add.jsp").forward(req,resp);
                break;
            }

        }


    }
}
