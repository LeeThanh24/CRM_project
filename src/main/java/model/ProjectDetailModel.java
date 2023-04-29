package model;

public class ProjectDetailModel {
    private String name ;
    private String status ;
    private String project;
    private String task ;
    private String startDate  ;
    private String endDate;

    private String email;
    public String getAva() {
        return ava;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAva(String ava) {
        this.ava = ava;
    }

    private String ava ;

    public ProjectDetailModel() {
    }

    public ProjectDetailModel(String name, String status, String project, String task, String startDate, String endDate ,String ava) {
        this.name = name;
        this.status = status;
        this.project = project;
        this.task = task;
        this.startDate = startDate;
        this.endDate = endDate;
        this.ava=ava;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
