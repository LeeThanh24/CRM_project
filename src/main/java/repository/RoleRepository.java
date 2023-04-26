package repository;

import config.MysqlConfig;
import model.RoleColumn;
import model.RoleModel;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleRepository {

    public List<RoleModel> getAllRoles(){
        List<RoleModel> listRoles = new ArrayList<>();
        Connection connection = MysqlConfig.getConnection();
        String query = "select * from roles";

        try{
            ResultSet resultSet = connection.prepareStatement(query).executeQuery();
            while(resultSet.next()){
                RoleModel roleModel = new RoleModel();
                roleModel.setId(resultSet.getInt(RoleColumn.ID.getValue()));
                roleModel.setRoleName(resultSet.getString(RoleColumn.NAME.getValue()));
                roleModel.setDescription(resultSet.getString(RoleColumn.DESCRIPTION.getValue()));

                listRoles.add(roleModel);
            }
        }catch (Exception e){
            System.out.println("Lỗi câu query getAllRoles " + e.getMessage());
        }

        return listRoles;
    }

    public int deleteRoleById(int id){
        int isDeleteSuccess = 0;
        Connection connection = MysqlConfig.getConnection();
        String query = "delete from roles r where r.id = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,id);

            isDeleteSuccess = statement.executeUpdate();
        }catch (Exception e){
            System.out.println("Error delete role by id " + e.getMessage());
        }finally {
            try{
                connection.close();
            }catch (Exception e){

            }
        }
        return isDeleteSuccess;
    }

    public int addNewRole(String name, String desc) {
        Connection connection = MysqlConfig.getConnection();
        String query = "insert into roles (id,name,description) values (?,?,?)";
        int currentId = getAllRoles().size();
        int  isSuccess = 0;
        try {

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,currentId+1);
            statement.setString(2,name);
            statement.setString(3,desc);
            isSuccess=statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error in mysql adding new roles  "+e.getMessage());
        }
        return isSuccess;
    }

}
