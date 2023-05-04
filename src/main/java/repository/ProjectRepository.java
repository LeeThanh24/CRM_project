package repository;

import config.MysqlConfig;
import model.JobsModel;
import model.ProjectDetailModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepository {


    public List<List<ProjectDetailModel>> countAllStatusOfProject() {
        List<List<ProjectDetailModel>> list = new ArrayList<>();
        Connection connection = MysqlConfig.getConnection();
        String queryNotStarted = "select\n" +
                "    u.fullname as fullname , s.name as status ,j.name as project,t.name as task, t.start_date as startDate ,t.end_date as endDate,u.avatar as ava,u.email as email\n" +
                "            from\n" +
                "    tasks t\n" +
                "    inner join users u\n" +
                "    on u.id = t.user_id\n" +
                "    inner join status s\n" +
                "    on s.id = t.status_id\n" +
                "    inner join jobs j\n" +
                "    on j.id = t.job_id\n" +
                "            where\n" +
                "    s.name  = 'Chưa thực hiện'";
        String queryInProcess = "select\n" +
                "    u.fullname as fullname , s.name as status ,j.name as project,t.name as task, t.start_date as startDate ,t.end_date as endDate,u.avatar as ava,u.email as email\n" +
                "            from\n" +
                "    tasks t\n" +
                "    inner join users u\n" +
                "    on u.id = t.user_id\n" +
                "    inner join status s\n" +
                "    on s.id = t.status_id\n" +
                "    inner join jobs j\n" +
                "    on j.id = t.job_id\n" +
                "            where\n" +
                "    s.name  = 'Đang thực hiện'";
        String queryFinished = "select\n" +
                "    u.fullname as fullname , s.name as status ,j.name as project,t.name as task, t.start_date as startDate ,t.end_date as endDate,u.avatar as ava,u.email as email\n" +
                "            from\n" +
                "    tasks t\n" +
                "    inner join users u\n" +
                "    on u.id = t.user_id\n" +
                "    inner join status s\n" +
                "    on s.id = t.status_id\n" +
                "    inner join jobs j\n" +
                "    on j.id = t.job_id\n" +
                "            where\n" +
                "    s.name  = 'Đã thực hiện'";

        try {
            List<ProjectDetailModel> listNotStarted = new ArrayList<>();
            List<ProjectDetailModel> listInProcess = new ArrayList<>();
            List<ProjectDetailModel> listFinished = new ArrayList<>();

            PreparedStatement statement = connection.prepareStatement(queryNotStarted);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                String fullname = resultSet.getString("fullname");
                String status = resultSet.getString("status");
                String project = resultSet.getString("project");
                String task = resultSet.getString("task");
                String startDate = resultSet.getString("startDate");
                String endDate = resultSet.getString("endDate");
                String ava = resultSet.getString("ava");
                String email = resultSet.getString("email");
                ProjectDetailModel projectDetailModel =new ProjectDetailModel(fullname, status, project, task, startDate, endDate,ava);
                projectDetailModel.setEmail(email);

                listNotStarted.add(projectDetailModel);


            }

            statement = connection.prepareStatement(queryInProcess);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {

                String fullname = resultSet.getString("fullname");
                String status = resultSet.getString("status");
                String project = resultSet.getString("project");
                String task = resultSet.getString("task");
                String startDate = resultSet.getString("startDate");
                String endDate = resultSet.getString("endDate");
                String ava = resultSet.getString("ava");
                String email = resultSet.getString("email");
                ProjectDetailModel projectDetailModel =new ProjectDetailModel(fullname, status, project, task, startDate, endDate,ava);
                projectDetailModel.setEmail(email);

                listInProcess.add(projectDetailModel);


            }

            statement = connection.prepareStatement(queryFinished);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {

                String fullname = resultSet.getString("fullname");
                String status = resultSet.getString("status");
                String project = resultSet.getString("project");
                String task = resultSet.getString("task");
                String startDate = resultSet.getString("startDate");
                String endDate = resultSet.getString("endDate");
                String ava = resultSet.getString("ava");
                String email = resultSet.getString("email");
                ProjectDetailModel projectDetailModel =new ProjectDetailModel(fullname, status, project, task, startDate, endDate,ava);
                projectDetailModel.setEmail(email);

                listFinished.add(projectDetailModel);


            }
            list.add(listNotStarted);
            list.add(listInProcess);
            list.add(listFinished);

        } catch (SQLException e) {
            System.out.println("Error in ProjectRepository : " + e.getMessage());
        }


        return list;
    }


    public boolean updateJobById(int oldId,int newId) {
        Connection connection = MysqlConfig.getConnection();
        String queryNotStarted = "update jobs\n" +
                "set id = ?\n" +
                "where id =?";

        try {
            PreparedStatement statement = connection.prepareStatement(queryNotStarted);
            statement.setInt(1,newId );
            statement.setInt(2,oldId );
            boolean isSuccess  = statement.executeUpdate() >0;

            return isSuccess ;

        } catch (SQLException e) {
            System.out.println("Error in ProjectRepository : " + e.getMessage());
            return false ;
        }

    }



    public  List<JobsModel> filterJobs(int id , String projectName , String start ,String end ) {
        Connection connection = MysqlConfig.getConnection();
        String queryNotStarted = "select \n" +
                "\t*\n" +
                "    from\n" +
                "            jobs j\n" +
                "    where\n" +
                "    j.name LIKE ? OR j.start_date LIKE ? OR j.end_date LIKE ? OR j.id=?";

        List<JobsModel> list = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(queryNotStarted);
            statement.setString(1,"%"+projectName+"%");
            statement.setString(2,"%"+start +"%");
            statement.setString(3,"%"+end+"%");
            statement.setInt(4,id);
            ResultSet resultSet  = statement.executeQuery() ;
            while (resultSet.next())
            {

                int id1 = resultSet.getInt("id");
                String finalName = resultSet.getString("name");
                String start_date = resultSet.getString("start_date");
                String end_date = resultSet.getString("end_date");

                list.add(new JobsModel(id1, finalName, start_date, end_date));
            }
            return list ;

        } catch (SQLException e) {
            System.out.println("Error in ProjectRepository : " + e.getMessage());
            return new ArrayList<>() ;
        }

    }
}
