package service;

import model.UserModel;
import repository.UsersRepository;

import javax.servlet.http.Cookie;
import java.util.List;

public class UsersService {
    UsersRepository usersRepository = new UsersRepository();
    public List<UserModel> countAllUsersByWithFullname()
    {
        return usersRepository.countAllUsersByWithFullname();
    }
    public List<String> findNameUserByEmail ( Cookie []cookies)
    {
        String email ="" ;
        for (Cookie cookie : cookies
             ) {
            if (cookie.getName().equals("username"))
            {
                email = cookie.getValue();
                break;
            }
        }
        return usersRepository.findUserByEmail(email) ;
    }

    public String getFirstName ( String fullname)
    {
        String []temp= fullname.split(" ");
        if (temp.length==1)
        {
            return temp[0];
        }else
        {
            return temp[temp.length-1];
        }
    }
}
