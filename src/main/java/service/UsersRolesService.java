package service;

import model.UserRoleModel;
import repository.UsersRepository;
import repository.UsersRolesRepository;

import java.util.List;

public class UsersRolesService {
    public List<UserRoleModel> countAllUsersRoles()
    {
        return new UsersRolesRepository().countAllUsersRoles();
    }
    public boolean addNewUserRole(String fullname ,String email ,String password ,int roleId )
    {
        return new UsersRolesRepository().addNewUserRole(fullname, email, password, roleId) >0;
    }

    public boolean deleteUserRoleById(int id )
    {
        return new UsersRolesRepository().deleteUserRoleById(id) >0;
    }

}
