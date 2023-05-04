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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name= "Users Servlet" ,urlPatterns = {"/usersRoles" ,"/user-add","/user/detail"})
public class UsersRolesServlet extends HttpServlet {
    UsersService usersService= new UsersService();

    UsersRolesService usersRolesService = new UsersRolesService();

    RoleService roleService = new RoleService() ;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String url = req.getServletPath();
        System.out.println(url);
        String requestDispacther = "";
        Cookie[]cookies = req.getCookies();
        String fullname = usersService.findNameUserByEmail(cookies).get(1);
        String firstName = usersService.getFirstName(fullname);
        req.setAttribute("firstName",firstName);
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

                String usersSearch = (req.getParameter("subSearch"));
                System.out.println("sub search : " + usersSearch);
                List<UserRoleModel> users = new ArrayList<>();
                if (usersSearch == null|| usersSearch.isEmpty()||roleService.validString(usersSearch,1).equals("")) {
                    users = usersRolesService.countAllUsersRoles();
                } else if (roleService.validNumber(usersSearch) !=0) {
                    int id = roleService.validNumber(usersSearch);
                    users = usersRolesService.filterUsers(id,usersSearch,usersSearch,usersSearch,usersSearch);

                }else
                {
                    users = usersRolesService.filterUsers(0,usersSearch,usersSearch,usersSearch,usersSearch);

                }
                req.setAttribute("usersRoles",users);
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
