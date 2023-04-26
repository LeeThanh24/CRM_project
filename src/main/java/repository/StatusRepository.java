package repository;

import config.MysqlConfig;
import model.StatusModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatusRepository {
    public List<StatusModel> countAllStatusWithName()
    {
        int count = 0;
        //Mở kết nối tới database
        Connection connection = MysqlConfig.getConnection();
//        String query = "select count(*) from users u \n" +
//                "where u.email = '" + email + "' and password = '" + password + "';";
//    Ký tự ? : đại diện cho tham số jdbc sẽ truyền vào khi thực thi câu query
        List<StatusModel> list = new ArrayList<>();
        String query = "select * from status";
        try {
            //Chuẩn bị câu query và truyền tham số vào câu query
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                String fullname = resultSet.getString("name");
                int id = resultSet.getInt("id");
                list.add(new StatusModel(id,fullname));
            }
        } catch (SQLException e) {
            System.out.println("Error in counting all status with name");
        }

        return list;
    }



}
