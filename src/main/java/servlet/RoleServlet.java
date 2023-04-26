package servlet;

import model.RoleModel;
import model.UserModel;
import service.RoleService;
import service.UsersRolesService;
import service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "roleServlet", urlPatterns = {"/roles", "/roleAdd"})
public class RoleServlet extends HttpServlet {

    UsersService usersService = new UsersService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = req.getServletPath();

        Cookie[] cookies = req.getCookies();
        String fullname = usersService.findNameUserByEmail(cookies).get(1);
        String firstName = usersService.getFirstName(fullname);
        req.setAttribute("firstName", firstName);


        switch (url) {
            case "/roles": {
                RoleService roleService = new RoleService();
                req.setAttribute("roles", roleService.getAllRoles());
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
