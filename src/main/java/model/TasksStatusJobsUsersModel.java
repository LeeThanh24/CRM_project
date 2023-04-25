package model;

public class TasksStatusJobsUsersModel {
    private int id ;
    private String taskName ;
    private String projName ;
    private String executer ;
    private String start ;
    private String end ;
    private String status ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TasksStatusJobsUsersModel(int id , String taskName, String projName, String executer, String start, String end, String status) {
        this.taskName = taskName;
        this.projName = projName;
        this.executer = executer;
        this.start = start;
        this.end = end;
        this.status = status;
        this.id=id ;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    public String getExecuter() {
        return executer;
    }

    public void setExecuter(String executer) {
        this.executer = executer;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
