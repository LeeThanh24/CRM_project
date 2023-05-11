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

    public boolean updateTask(String taskName ,String start ,String end , int userId ,int jobId,int statusId  )
    {
        System.out.println("task name "+taskName);
        System.out.println("start "+start);
        System.out.println("end"+end);
        System.out.println("user_id "+userId);
        System.out.println("job_id "+jobId);
        System.out.println("status_id "+statusId);
        Connection connection = MysqlConfig.getConnection();
        String query = "update  tasks\n" +
                "    set start_date = ? , end_date =?, user_id = ?,status_id = ?\n" +
                "    where name = ? and job_id = ?";

        try
        {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,start);
            statement.setString(2,end);
            statement.setInt(3,userId);
            statement.setInt(4,statusId);
            statement.setString(5,taskName);
            statement.setInt(6,jobId);

            int result = statement.executeUpdate();
            return (result!=0);
        }catch (Exception e)
        {
            System.out.println("Error in TaskRepository - update() "+e.getMessage());
            return false ;

        }

    }
}
