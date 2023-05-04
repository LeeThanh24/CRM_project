package service;

import model.UserRoleModel;
import repository.UsersRepository;
import repository.UsersRolesRepository;

import java.util.List;

public class UsersRolesService {

    UsersRolesRepository usersRolesRepository = new UsersRolesRepository() ;
    UsersRepository usersRepository= new UsersRepository();
    public List<UserRoleModel> countAllUsersRoles()
    {
        updateAllUserById();
        return usersRolesRepository.countAllUsersRoles();
    }
    public List<UserRoleModel> filterUsers(int id,String firstName ,String lastName ,String email,String roleName )
    {

        return usersRolesRepository.filterUsers(id,firstName,lastName,email,roleName);
    }
    public boolean addNewUserRole(String fullname ,String email ,String password ,int roleId )
    {
        return usersRolesRepository.addNewUserRole(fullname, email, password, roleId) >0;
    }

    public String  findPasswordByEmail(String email )
    {
        return usersRolesRepository.findPasswordByEmail( email);
    }
    public boolean addNewRegisterUser(String fullname ,String email ,String password ,String ava , int roleId )
    {
        return usersRolesRepository.addNewRegisterUser(fullname, email, password, ava,roleId) >0;
    }
    public boolean deleteUserRoleById(int id )
    {
        return usersRolesRepository.deleteUserRoleById(id) >0;
    }

    public void updateAllUserById ()
    {
        List<UserRoleModel> users = usersRolesRepository.countAllUsersRoles();
        for (int i = 1; i <=users.size() ; i++) {
            usersRepository.updateUserById(users.get(i-1).getId(),i);
        }
    }

    public static boolean checkSpaceBar (String myString )
    {
        String [] list = myString.split(" ");
        for (String item : list
             ) {
            if (!item.equals(""))
            {
                return true   ;
            }
        }
        return false ;
    }
    public boolean updatePasswordByEmail (String password, String email  )
    {
        return usersRolesRepository.updatePasswordByEmail(password,email);
    }
}
