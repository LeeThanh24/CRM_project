package repository;

import config.MysqlConfig;
import model.TasksStatusJobsUsersModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TasksStatusJobsUsersRepository {
    TaskRepository taskRepository = new TaskRepository() ;
    public List<TasksStatusJobsUsersModel> countAllTasksStatusJobsUsers()
    {
        Connection connection= MysqlConfig.getConnection();
        String query = "select t.id as id,t.name as task ,j.name as project, u.fullname as doer , t.start_date as start_date , t.end_date as end_date,s.name as status from tasks t inner join status s on t.status_id = s.id inner join jobs j on j.id = t.job_id inner join users u on u.id = t.user_id";
        List<TasksStatusJobsUsersModel> myList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next())
            {
                int id = resultSet.getInt("id");
                String task = resultSet.getString("task");
                String project = resultSet.getString("project");
                String doer = resultSet.getString("doer");;
                String start_date = resultSet.getString("start_date");
                String end_date = resultSet.getString("end_date");
                String status = resultSet.getString("status");

                myList.add(new TasksStatusJobsUsersModel(id,task,project,doer,start_date,end_date,status));

            }
        } catch (SQLException e) {
            System.out.println("Error in querying in TasksStatusJobsUsers repository : "+e.getMessage());
        }

        return myList;
    }

    public List<TasksStatusJobsUsersModel> filterTasks(int id ,String taskName ,String projectName ,String doer , String start ,String end ,  String status )
    {
        Connection connection= MysqlConfig.getConnection();
        String query = "select t.id as id,\tt.name as task ,j.name as project, u.fullname as doer , t.start_date as start_date , t.end_date as end_date,s.name as status from tasks t inner join status s on t.status_id = s.id inner join jobs j on j.id = t.job_id inner join users u on u.id = t.user_id\n" +
                "    where t.start_date LIKE ? OR t.end_date LIKE ? OR t.name LIKE ? OR j.name LIKE ? OR  u.fullname  LIKE ? or s.name LIKE ? OR t.id = ?";
        List<TasksStatusJobsUsersModel> myList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString (1,"%" + start + "%" );
            statement.setString (2,"%" + end + "%" );
            statement.setString (3,"%" + taskName + "%" );
            statement.setString (4,"%" + projectName + "%" );
            statement.setString (5,"%" + doer + "%" );
            statement.setString (6,"%" + status + "%" );
            statement.setInt(7,id);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next())
            {
                int id1 = resultSet.getInt("id");
                String task1 = resultSet.getString("task");
                String project1 = resultSet.getString("project");
                String doer1 = resultSet.getString("doer");;
                String start_date1 = resultSet.getString("start_date");
                String end_date1 = resultSet.getString("end_date");
                String status1 = resultSet.getString("status");

                myList.add(new TasksStatusJobsUsersModel(id1,task1,project1,doer1,start_date1,end_date1,status1));
            }
            return myList;
        } catch (SQLException e) {
            System.out.println("Error in querying in TasksStatusJobsUsers filter repository : "+e.getMessage());
            return new ArrayList<>( );
        }


    }
    public List<TasksStatusJobsUsersModel> countAllTasksStatusJobsUsersByEmail(String email )
    {
        Connection connection= MysqlConfig.getConnection();
        String query = "select t.id as id,t.name as task ,j.name as project, u.fullname as doer , t.start_date as start_date , t.end_date as end_date,s.name as status from tasks t inner join status s on t.status_id = s.id inner join jobs j on j.id = t.job_id inner join users u on u.id = t.user_id where u.email =?";
        List<TasksStatusJobsUsersModel> myList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,email);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next())
            {
                int id = resultSet.getInt("id");
                String task = resultSet.getString("task");
                String project = resultSet.getString("project");
                String doer = resultSet.getString("doer");;
                String start_date = resultSet.getString("start_date");
                String end_date = resultSet.getString("end_date");
                String status = resultSet.getString("status");

                myList.add(new TasksStatusJobsUsersModel(id,task,project,doer,start_date,end_date,status));

            }
        } catch (SQLException e) {
            System.out.println("Error in querying in TasksStatusJobsUsers repository : "+e.getMessage());
        }

        return myList;
    }
    public int addNewTasksStatusJobsUsers(String taskName ,String start ,String end ,int user_id ,int job_id ,int status_id )
    {
        Connection connection= MysqlConfig.getConnection();
        String query ="insert into tasks(id ,name,start_date,end_date,user_id ,job_id,status_id) values (?,?,?,?,?,?,?)\n";
        int currentId = countAllTasksStatusJobsUsers().size();
        int isSuccess =0 ;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,currentId+1);
            statement.setString(2,taskName);
            statement.setString(3,start);
            statement.setString(4,end);
            statement.setInt(5,user_id);
            statement.setInt(6,job_id);
            statement.setInt(7,status_id);
            isSuccess = statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error in adding new TasksStatusJobsUsers : "+e.getMessage());
        }
        return isSuccess;
    }

    public int deleteTaskById (int id )
    {
        Connection connection= MysqlConfig.getConnection();
        String query ="delete from tasks where id =?";
        int isSuccess =0 ;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            isSuccess = statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error in deleting a task : "+e.getMessage());
        }
        return isSuccess;
    }

    public boolean updateAllIdOfTasks ()
    {
        List<TasksStatusJobsUsersModel> allTasks = countAllTasksStatusJobsUsers();
        for (int i = 1; i <=allTasks.size() ; i++) {
            taskRepository.updateTaskById(allTasks.get(i-1).getId(),i);
        }
        return true ;
    }
}
