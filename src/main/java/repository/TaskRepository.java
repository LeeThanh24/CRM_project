package repository;

import config.MysqlConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TaskRepository {
    public int countAllStatusGroupByStatusId(int id )
    {
        Connection connection = MysqlConfig.getConnection();
        String query = "select * from tasks where status_id =? ";
        int total = 0 ;
        try
        {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            ResultSet resultSet  = statement.executeQuery();
            while   (resultSet.next())
            {
                total+=1;
            }
        }catch (Exception e)
        {
            System.out.println("Error in TaskRepository - countAllStatusGroupByStatusId() "+e.getMessage());
            return -1 ;
        }
        return total;
    }
}
