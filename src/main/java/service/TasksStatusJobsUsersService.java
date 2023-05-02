package service;

import model.TasksStatusJobsUsersModel;
import repository.TasksStatusJobsUsersRepository;

import java.util.ArrayList;
import java.util.List;

public class TasksStatusJobsUsersService {
    TasksStatusJobsUsersRepository tasksStatusJobsUsersRepository= new TasksStatusJobsUsersRepository() ;
    public List<TasksStatusJobsUsersModel> countAllTasksStatusJobsUsers()
    {
        tasksStatusJobsUsersRepository.updateAllIdOfTasks();
        return tasksStatusJobsUsersRepository.countAllTasksStatusJobsUsers();
    }

    public List<TasksStatusJobsUsersModel> countAllTasksStatusJobsUsersByEmail(String email )
    {
        return tasksStatusJobsUsersRepository.countAllTasksStatusJobsUsersByEmail(email);
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
