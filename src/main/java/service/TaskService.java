package service;

import repository.TaskRepository;

public class TaskService {
    public int countAllStatusGroupByStatusId(int id )
    {
        return new TaskRepository().countAllStatusGroupByStatusId(id) ;
    }
}
