package servlet;

import config.MysqlConfig;
import service.LoginService;
import service.UsersRolesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Anotation [Tên định danh]
 * Ký hiệu : @
 */
//Tên của servlet       //Đường dẫn của servlet
@WebServlet(name = "LoginServlet", urlPatterns = {"/login", "/register", "/forgotPassword", "/changePassword","/changePasswordSuccess"})
public class LoginServlet extends HttpServlet {

    //excuteQuery : Select
    //excuteUpdate : Create, Update, Delete...
    LoginService loginService = new LoginService();
    UsersRolesService usersRolesService = new UsersRolesService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getServletPath();
        switch (url) {
            case "/login": {
                req.getRequestDispatcher("login.jsp").forward(req, resp);
                break;
            }
            case "/register": {
                req.getRequestDispatcher("register.jsp").forward(req, resp);
                break;
            }

            case "/forgotPassword": {
                req.getRequestDispatcher("forgotPassword.jsp").forward(req, resp);
                break;
            }
            case "/changePassword": {

                req.getRequestDispatcher("changePassword.jsp").forward(req, resp);
                break;
            }
            case "/changePasswordSuccess":
            {
                req.getRequestDispatcher("changePasswordSuccess.jsp").forward(req, resp);

                break;
            }
        }
        //Khởi tạo cookie           //Tên của cookie    //Giá trị của cookie
//        Cookie cookie = new Cookie("username", URLEncoder.encode("Nguyen Van B","UTF-8"));
//        cookie.setMaxAge(8 * 60 * 60); //Set thời gian hết hạn của cookie
//        resp.addCookie(cookie); //yêu cầu trình duyệt phía client tạo cookie

        //Lấy toàn bộ cookie ở browser người dùng
//        Cookie[] cookies = req.getCookies();
//        for ( Cookie cookie: cookies) {
//            String name = cookie.getName();
//            if(name.equals("username")){
//                System.out.println("Giá trị " + URLDecoder.decode(cookie.getValue(),"UTF-8"));
//            }
//        }

        //Lấy session từ trên server
//        HttpSession session = req.getSession();
//        session.setAttribute("username","Trần Văn A");
//        //Set thời gian hết hạn của session đơn vị second
//        session.setMaxInactiveInterval(8 * 60 * 60);
//
//        String data = (String) session.getAttribute("username");
//
//        System.out.println("Giá trị session : " + data );

//        Connection connection = MysqlConfig.getConnection();
//        String query = "select * from users";
//        try {
//            //Chuẩn bị câu truy vấn cho prepare statement
//            PreparedStatement statement = connection.prepareStatement(query);
//            //Kết quả câu truy vấn sẽ lưu vào ResultSet
//            ResultSet resultSet = statement.executeQuery();
//            //Duyệt giá trị trong resultset và lấy ra thông tin cột mong muốn
//            while (resultSet.next()){
//                String email = resultSet.getString("email");
//                int roleId = resultSet.getInt("role_id");
//
//                System.out.println("Email là " + email);
//            }
//
//        } catch (SQLException e) {
//            System.out.println("Lỗi thực thi câu truy vấn login " + e.getMessage());
//        }finally {
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = req.getServletPath();
        switch (url) {
            case "/login": {
                String email = req.getParameter("email");
                String password = req.getParameter("password");
                boolean isSuccess = loginService.checkLogin(email, password);

                if (isSuccess) {
                    //Tiến hành lưu cookie
                    Cookie cookie = new Cookie("username", email);
                    System.out.println("Cookie value : " + cookie.getValue());
                    cookie.setMaxAge(1 * 60 * 60);
                    resp.addCookie(cookie);

                    resp.sendRedirect(req.getContextPath() + "/index");
                } else {
                    req.getRequestDispatcher("login.jsp").forward(req, resp);
                }

                break;
            }

            case "/register": {
                String email = req.getParameter("email");
                String fullname = req.getParameter("fullname");
                String password = req.getParameter("password");
                String confirmPassword = req.getParameter("confirmPassword");
                boolean isSuccess = password.equals(confirmPassword);
                usersRolesService.addNewRegisterUser(fullname, email, password, "avaMale.png", 3);
                if (isSuccess) {
                    //Tiến hành lưu cookie
                    Cookie cookie = new Cookie("username", email);
                    System.out.println("Cookie value : " + cookie.getValue());
                    cookie.setMaxAge(1 * 60 * 60);
                    resp.addCookie(cookie);

                    resp.sendRedirect(req.getContextPath() + "/index");
                } else {
                    req.getRequestDispatcher("register.jsp").forward(req, resp);
                }

                break;
            }
            case "/forgotPassword": {
                String email = req.getParameter("email");
                String password = usersRolesService.findPasswordByEmail(email);

                if (!password.equals("")) {
                    System.out.println("password recovery : " + password);
                    //Tiến hành lưu cookie
                    Cookie cookie = new Cookie("username", email);
                    System.out.println("Cookie value : " + cookie.getValue());
                    cookie.setMaxAge(1 * 60 * 60);
                    resp.addCookie(cookie);
                    resp.sendRedirect(req.getContextPath() + "/changePassword");

                } else {
                    req.getRequestDispatcher("forgotPassword.jsp").forward(req, resp);
                }

                break;
            }
            case "/changePassword" :
            {
                System.out.println("da vao dc day ");
                String password= req.getParameter("newPassword");
                String confirmPassword= req.getParameter("confirmPassword");
                Cookie[] cookies = req.getCookies();
                String email = "";
                for (Cookie cookie : cookies) {
                    if ("username".equals(cookie.getName())) {
                        email = cookie.getValue();
                        break;
                    }
                }
                if (password.equals(confirmPassword))
                {
//                    System.out.println("da vao dc day ");
                    usersRolesService.updatePasswordByEmail(password,email);
                    resp.sendRedirect(req.getContextPath() + "/changePasswordSuccess");

                }else
                {
                    req.getRequestDispatcher("changePassword.jsp").forward(req, resp);

                }
                break;
            }

        }


        //Khi đăng nhập thành công và chuyển qua page role
        //thì phải lấy được danh sách role từ database và hiển thị lên giao diện
        //Bước 1: Lấy danh sách role từ repository
        //Bước 2: Service trả danh sách role cho Servlet
        //Bước 3: Trả danh sách Role cho jsp
        //Bước 4: Sử dụng JSTL load danh sách role ra giao diện


    }
}
