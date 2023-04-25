package servlet;

import config.MysqlConfig;
import service.LoginService;

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
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    //excuteQuery : Select
    //excuteUpdate : Create, Update, Delete...

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        LoginService loginService = new LoginService();
        boolean isSuccess = loginService.checkLogin(email,password);

        if(isSuccess){
            //Tiến hành lưu cookie
            Cookie cookie = new Cookie("username",email);
            cookie.setMaxAge(8 * 60 * 60);
            resp.addCookie(cookie);

            resp.sendRedirect(req.getContextPath() + "/roles");
        }else{
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }

    //Khi đăng nhập thành công và chuyển qua page role
    //thì phải lấy được danh sách role từ database và hiển thị lên giao diện
    //Bước 1: Lấy danh sách role từ repository
    //Bước 2: Service trả danh sách role cho Servlet
    //Bước 3: Trả danh sách Role cho jsp
    //Bước 4: Sử dụng JSTL load danh sách role ra giao diện

}
