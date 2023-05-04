package servlet;

import model.RoleModel;
import model.UserModel;
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

@WebServlet(name = "roleServlet", urlPatterns = {"/roles", "/roleAdd"})
public class RoleServlet extends HttpServlet {

    UsersService usersService = new UsersService();
    RoleService roleService = new RoleService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = req.getServletPath();

        Cookie[] cookies = req.getCookies();
        String fullname = usersService.findNameUserByEmail(cookies).get(1);
        String firstName = usersService.getFirstName(fullname);
        req.setAttribute("firstName", firstName);


        switch (url) {
            case "/roles": {
                String roleSearch = (req.getParameter("subSearch"));
                System.out.println("sub search : " + roleSearch);
                List<RoleModel> roles = new ArrayList<>();
                if (roleSearch == null|| roleSearch.isEmpty()||roleService.validString(roleSearch,1).equals("")) {
                    roles = roleService.getAllRoles();
                } else if (roleService.validNumber(roleSearch) !=0) {
                    int id = roleService.validNumber(roleSearch);
                    roles = roleService.filterRoles(id,roleSearch,roleSearch);

                }else
                {
                    roles = roleService.filterRoles(0,roleSearch,roleSearch);
                }
                req.setAttribute("roles", roles);
                req.getRequestDispatcher("role-table.jsp").forward(req, resp);

                break;
            }
            case "/roleAdd": {

                req.getRequestDispatcher("role-add.jsp").forward(req, resp);

                break;
            }


        }
    }
}
