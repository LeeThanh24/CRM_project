package repository;

import config.MysqlConfig;
import model.JobsModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JobsRepository {
    public List<JobsModel> countAllJobs() {
        List<JobsModel> list = new ArrayList<>();
        Connection connection = MysqlConfig.getConnection();
        String query = "select * from jobs";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                int id = resultSet.getInt("id");
                String finalName = resultSet.getString("name");
                String start_date = resultSet.getString("start_date");
                String end_date = resultSet.getString("end_date");

                list.add(new JobsModel(id, finalName, start_date, end_date));
            }

        } catch (SQLException e) {
            System.out.println("Error in querying jobs : " + e.getMessage());
        }

        return list;
    }

    public int deleteJob(int id  )
    {
        int isDeleteSuccess = 0;
        Connection connection = MysqlConfig.getConnection();
        String query = "delete from jobs where id = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,id);

            isDeleteSuccess = statement.executeUpdate();
        }catch (Exception e){
            System.out.println("Error delete job by id " + e.getMessage());
        }finally {
            try{
                connection.close();
            }catch (Exception e){

            }
        }
        return isDeleteSuccess;
    }

    public int addNewJob(String name ,String  start ,String  end )
    {
        Connection connection = MysqlConfig.getConnection();
        String query = "insert into jobs (name,start_date,end_date) values (?,?,?)";
        int isSuccess = 0 ;
        try {
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1,name);
            System.out.println("Entered to job repo and "+start+" "+end);
            statement.setString(2,  start);
            statement.setString(3,  end);
            isSuccess=statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error in adding new job : "+e.getMessage());
        }
        return isSuccess;
    }

}
