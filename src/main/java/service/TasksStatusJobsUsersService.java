package service;

import model.TasksStatusJobsUsersModel;
import repository.TaskRepository;
import repository.TasksStatusJobsUsersRepository;

import java.util.ArrayList;
import java.util.List;

public class TasksStatusJobsUsersService {
    TasksStatusJobsUsersRepository tasksStatusJobsUsersRepository= new TasksStatusJobsUsersRepository() ;
    TaskRepository taskRepository = new TaskRepository() ;
    public List<TasksStatusJobsUsersModel> countAllTasksStatusJobsUsers()
    {
        updateAllById();
        return tasksStatusJobsUsersRepository.countAllTasksStatusJobsUsers();
    }

    public  List<TasksStatusJobsUsersModel> filterTasks (int id ,String taskName ,String projectName ,String doer , String start ,String end ,  String status )
    {
       return  tasksStatusJobsUsersRepository.filterTasks(id,taskName,projectName,doer,start,end,status);
    }
    public boolean updateAllById()
    {
        return tasksStatusJobsUsersRepository.updateAllIdOfTasks();
    }
    public List<TasksStatusJobsUsersModel> countAllTasksStatusJobsUsersByEmail(String email )
    {
        return tasksStatusJobsUsersRepository.countAllTasksStatusJobsUsersByEmail(email);
    }
    public boolean updateTasks(String taskName ,String start ,String end , int userId ,int jobId,int statusId  )
    {
        String []listStringStart = start.split("/");
        String afterConvertStart = "";
        afterConvertStart=listStringStart[2]+"/"+listStringStart[1] +"/"+listStringStart[0];

        //convert end
        String []listStringEnd = end.split("/");
        String afterConvertEnd = "";
        afterConvertEnd=listStringEnd[2]+"/"+listStringEnd[1] +"/"+listStringEnd[0];
        return taskRepository.updateTask(taskName,afterConvertStart,afterConvertEnd,userId,jobId,statusId);
    }


    public boolean addNewTasksStatusJobsUsers(String taskName ,String start ,String end ,int user_id ,int job_id ,int status_id )
    {
        //convert start
        String []listStringStart = start.split("/");
        String afterConvertStart = "";
        afterConvertStart=listStringStart[2]+"/"+listStringStart[1] +"/"+listStringStart[0];

        //convert end
        String []listStringEnd = end.split("/");
        String afterConvertEnd = "";
        afterConvertEnd=listStringEnd[2]+"/"+listStringEnd[1] +"/"+listStringEnd[0];
        return tasksStatusJobsUsersRepository.addNewTasksStatusJobsUsers(taskName,afterConvertStart,afterConvertEnd,user_id,job_id,status_id)>0;
    }

    public boolean deleteTaskById(int id )
    {
        return tasksStatusJobsUsersRepository.deleteTaskById(id)>0;
    }
}
