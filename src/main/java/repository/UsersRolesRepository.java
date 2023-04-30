package repository;

import config.MysqlConfig;
import model.UserRoleModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersRolesRepository {
    public List<UserRoleModel> countAllUsersRoles()
    {
        Connection connection= MysqlConfig.getConnection();
        String query = "select u.id as user_id,fullname ,email, name as role_name  from users u INNER JOIN roles r ON u.role_id=r.id";
        List<UserRoleModel> myList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next())
            {
                int id = resultSet.getInt("user_id");
                String fullname = resultSet.getString("fullname");
                String email = resultSet.getString("email");
                String role_name = resultSet.getString("role_name");

                //get firstname and lastname
                String []list = fullname.split(" ");
                String firstName =list[list.length-1];
                String lastName = list[0];

                //get username
                String []listt = email.split("@");
                String username = "@"+listt[0];

                myList.add(new UserRoleModel(id,firstName,lastName,username,role_name));

            }
        } catch (SQLException e) {
            System.out.println("Error in querying in UsersRoles repository : "+e.getMessage());
        }

        return myList;
    }

    public String findAvaByEmail(String email )
    {
        Connection connection= MysqlConfig.getConnection();
        String query = "select u.avatar as avatar  from users u where u.email = ? ";
        List<UserRoleModel> myList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,email);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next())
            {
                return resultSet.getString("avatar");
            }
        } catch (SQLException e) {
            System.out.println("Error in querying in UsersRoles repository : "+e.getMessage());
            return "avaMale.png";
        }

       return "";
    }
    public int addNewUserRole(String fullname ,String email ,String password ,int roleId)
    {
        Connection connection= MysqlConfig.getConnection();
        String query ="insert into users(id ,email,password,fullname,role_id) values (?,?,?,?,?)";
        int currentId  = countAllUsersRoles().size();
        System.out.println("Current id : "+currentId); //-> current id +1
        int isSuccess =0 ;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,currentId+1);
            statement.setString(2,email);
            statement.setString(3,password);
            statement.setString(4,fullname);
            statement.setInt(5,roleId);
            isSuccess = statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error in adding new userRole : "+e.getMessage());
        }
        return isSuccess;
    }

    public int deleteUserRoleById (int id )
    {
        Connection connection= MysqlConfig.getConnection();
        String query ="delete from users where id = ?";
        int isSuccess =0 ;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            isSuccess = statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error in deleting a userRole : "+e.getMessage());
        }
        return isSuccess;
    }
}
