package service;

import model.TasksStatusJobsUsersModel;
import repository.TaskRepository;
import repository.TasksStatusJobsUsersRepository;

import java.util.ArrayList;
import java.util.List;

public class TaskService {
    public int countAllStatusGroupByStatusId(int id) {
        return new TaskRepository().countAllStatusGroupByStatusId(id);
    }

    public List<Integer> percentProfile(String email) {
        List<Integer> list = new ArrayList<>();
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        List<TasksStatusJobsUsersModel> listModel = new TasksStatusJobsUsersService().countAllTasksStatusJobsUsersByEmail(email);
        for (TasksStatusJobsUsersModel item : listModel
        ) {

            if (item.getStatus().equals("Chưa thực hiện")) {
                count1 += 1;
            } else if (item.getStatus().equals("Đang thực hiện")) {
                count2 += 1;
            } else {
                count3 += 1;
            }
        }
        list.add(count1);
        list.add(count2);
        list.add(count3);
        return list ;
    }

}
