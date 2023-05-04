package repository;

import config.MysqlConfig;
import model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersRepository {

    public int countUsersByEmailAndPassword(String email, String password) {
        int count = 0;
        //Mở kết nối tới database
        Connection connection = MysqlConfig.getConnection();
//        String query = "select count(*) from users u \n" +
//                "where u.email = '" + email + "' and password = '" + password + "';";
//    Ký tự ? : đại diện cho tham số jdbc sẽ truyền vào khi thực thi câu query
        String query = "select count(*) as count from users u where u.email = ? and password = ?";
        try {
            //Chuẩn bị câu query và truyền tham số vào câu query
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                count = resultSet.getInt("count");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return count;
    }

    public List<UserModel> countAllUsersByWithFullname() {
        int count = 0;
        //Mở kết nối tới database
        Connection connection = MysqlConfig.getConnection();
//        String query = "select count(*) from users u \n" +
//                "where u.email = '" + email + "' and password = '" + password + "';";
//    Ký tự ? : đại diện cho tham số jdbc sẽ truyền vào khi thực thi câu query
        List<UserModel> list = new ArrayList<>();
        String query = "select id,fullname ,email from users";
        try {
            //Chuẩn bị câu query và truyền tham số vào câu query
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String fullname = resultSet.getString("fullname");
                int id = resultSet.getInt("id");
                String email = resultSet.getString("email");
                list.add(new UserModel(id, fullname, email));
            }
        } catch (SQLException e) {
            System.out.println("Error in counting all users with fullname");
        }

        return list;
    }

    public List<String> findUserByEmail(String email) {
        int count = 0;

        Connection connection = MysqlConfig.getConnection();
        List<String> user = new ArrayList<>();

        String query = "select  u.email, u.fullname  from users u where u.email = ?";
        try {

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String anotherEmail = resultSet.getString("email");
                String fullname = resultSet.getString("fullname");
                user.add(anotherEmail);
                user.add(fullname);
            }

        } catch (SQLException e) {
            System.out.println("Error in UserRepository find name by email : " + e.getMessage());
            return null;
        }

        return user;
    }


    public boolean updateUserById(int oldId, int newId) {
        Connection connection = MysqlConfig.getConnection();
        String query = "update users\n" +
                "    set id = ?\n" +
                "    where id =?";
        try {

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, newId);
            statement.setInt(2, oldId);

            boolean isSuccess = statement.executeUpdate() > 0;

            return isSuccess;

        } catch (SQLException e) {
            System.out.println("Error in UserRepository update by id : " + e.getMessage());
            return false;
        }

    }
}
