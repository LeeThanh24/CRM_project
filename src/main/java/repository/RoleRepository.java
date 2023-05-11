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


    public List<RoleModel> filterRoles(int id ,String name ,String description) {
        Connection connection = MysqlConfig.getConnection();

        String query = ("select r.id , r.name ,r.description from roles r where r.name LIKE ? OR r.description LIKE ? OR r.id = ?");

        try {
            List<RoleModel> roleModels = new ArrayList<>() ;
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(3,id );
            statement.setString (1,"%" + name + "%" );
            statement.setString(2,"%" + description + "%" );
//            System.out.println("query role : "+query);
            ResultSet result = statement.executeQuery();
            while (result.next() )
            {
                RoleModel roleModel = new RoleModel() ;
                roleModel.setId(result.getInt("id"));
                roleModel.setRoleName(result.getString("name"));
                roleModel.setDescription(result.getString("description"));
                roleModels.add(  roleModel );
            }
            return roleModels;

        } catch (SQLException e) {
            System.out.println("Error in mysql find role by id : "+e.getMessage());
            return new ArrayList<>();
        }

    }


    public boolean update(int oldId,int newId) {
        Connection connection = MysqlConfig.getConnection();

        String query = ("update  roles \n" +
                "set id = ? \n" +
                "where id = ? ");

        try {
            List<RoleModel> roleModels = new ArrayList<>() ;
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,newId );
            statement.setInt(2,oldId );

            boolean isSuccess = false ;

//            System.out.println("query role : "+query);
            isSuccess = (statement.executeUpdate()>0);
            return isSuccess;

        } catch (SQLException e) {
            System.out.println("Error in mysql update role by id : "+e.getMessage());
            return false ;
        }

    }

    public boolean updateRole(String name , String description ) {
        Connection connection = MysqlConfig.getConnection();

        String query = ("update  roles\n" +
                "    set name = ? , description =?\n" +
                "    where name = ?");

        try {

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,name );
            statement.setString(2,description );
            statement.setString(3,name );
            boolean isSuccess = false ;
            isSuccess = (statement.executeUpdate()>0);
            return isSuccess;

        } catch (SQLException e) {
            System.out.println("Error in mysql update role  : "+e.getMessage());
            return false ;
        }

    }
}
