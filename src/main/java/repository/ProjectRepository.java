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
                "    u.fullname as fullname , s.name as status ,j.name as project,t.name as task, t.start_date as startDate ,t.end_date as endDate\n" +
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
                "    u.fullname as fullname , s.name as status ,j.name as project,t.name as task, t.start_date as startDate ,t.end_date as endDate\n" +
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
                "    u.fullname as fullname , s.name as status ,j.name as project,t.name as task, t.start_date as startDate ,t.end_date as endDate\n" +
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
                listNotStarted.add(new ProjectDetailModel(fullname, status, project, task, startDate, endDate));

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
                listInProcess.add(new ProjectDetailModel(fullname, status, project, task, startDate, endDate));

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
                listFinished.add(new ProjectDetailModel(fullname, status, project, task, startDate, endDate));

            }
            list.add(listNotStarted);
            list.add(listInProcess);
            list.add(listFinished);

        } catch (SQLException e) {
            System.out.println("Error in ProjectRepository : " + e.getMessage());
        }


        return list;
    }
}