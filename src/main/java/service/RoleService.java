package service;

import model.RoleModel;
import repository.RoleRepository;

import java.util.ArrayList;
import java.util.List;

public class RoleService {

    RoleRepository roleRepository = new RoleRepository();
    public List<RoleModel> getAllRoles(){
        updateAllRoleById();
        return roleRepository.getAllRoles();
    }

    public void updateAllRoleById(){
        List<RoleModel> roles = roleRepository.getAllRoles();
        for (int i = 1; i <=roles.size() ; i++) {
            roleRepository.update(roles.get(i-1).getId(),i);
        }
    }

    public List<RoleModel> filterRoles(int id,String name ,String description  ){
        List<RoleModel> roles = getAllRoles();
        List<String >listName = new ArrayList<>( );
        List<String >listDesc = new ArrayList<>( );
        for (RoleModel item : roles
             ) {
            listName.add(item.getRoleName().toLowerCase());
        }
        for (RoleModel item : roles
        ) {
            listDesc.add(item.getDescription().toLowerCase());
        }
        System.out.println("name size : "+listName.size());
        System.out.println("description size: "+listDesc.size());

        name = validString(name,1);
        description = validString(description,2);

        return roleRepository.filterRoles(id,name,description);
    }

    public boolean deleteRoleById(int id){

        return roleRepository.deleteRoleById(id) >= 1;
    }

    public boolean addNewRole(String name, String desc){

        return roleRepository.addNewRole(name,desc) >= 1;
    }

    public int  validNumber(String num) {
        String []list = num.split(" ");
        num ="";
        for (String item : list
        ) {
            if (!item.equals(" ")) {
                num += item;

            }
        }

        int finalNumber = 0;
        try {
            finalNumber = Integer.parseInt(num);
            return finalNumber;
        } catch (Exception e) {
            return 0;
        }
    }

    private static String validString(String myString, int casee) {
        String[] list = myString.split(" ");
        String finalList = "";

        //case 1 : name , case 2 : description
        if (casee == 1) {
            for (String item : list
            ) {
                System.out.println(item);
                if (!item.equals(" ")) {
                    finalList += (item);
                }
            }
        } else if (casee == 2) {
            for (int i = 0; i < list.length; i++) {
                if (!list[i].equals("")) {

                    finalList += (list[i]);
                    if (i == list.length - 1) {
                        break;
                    }
                    finalList += " ";
                }
            }
        }
        return finalList;
    }
}
