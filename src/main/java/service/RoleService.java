package service;

import model.RoleModel;
import repository.RoleRepository;

import java.util.List;

public class RoleService {

    RoleRepository roleRepository = new RoleRepository();
    public List<RoleModel> getAllRoles(){

        return roleRepository.getAllRoles();
    }

    public RoleModel findRoleById(int id ){

        return roleRepository.findRoleById(id);
    }

    public boolean deleteRoleById(int id){

        return roleRepository.deleteRoleById(id) >= 1;
    }

    public boolean addNewRole(String name, String desc){

        return roleRepository.addNewRole(name,desc) >= 1;
    }

}
