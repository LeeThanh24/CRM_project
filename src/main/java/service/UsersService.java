package service;

import model.UserModel;
import repository.UsersRepository;

import java.util.List;

public class UsersService {
    public List<UserModel> countAllUsersByWithFullname()
    {
        return new UsersRepository().countAllUsersByWithFullname();
    }
}
