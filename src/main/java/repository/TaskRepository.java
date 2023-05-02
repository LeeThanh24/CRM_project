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


    public boolean updateTaskById(int oldId ,int newId  )
    {
        Connection connection = MysqlConfig.getConnection();
        String query = "update  tasks\n" +
                "    set id = ?\n" +
                "    where id = ?";
        boolean isSuccess = false ;
        try
        {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,newId);
            statement.setInt(2,oldId);
            int result = statement.executeUpdate();
            isSuccess  = (result!=0);

        }catch (Exception e)
        {
            System.out.println("Error in TaskRepository - countAllStatusGroupByStatusId() "+e.getMessage());

        }
        return isSuccess;
    }
}
