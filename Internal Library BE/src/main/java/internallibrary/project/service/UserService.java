package internallibrary.project.service;



import internallibrary.project.model.UserClass;
import internallibrary.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void addUser(UserClass user){
       if(userRepository.findUserClassByUserId(user.getUserId())==null){
           userRepository.save(user);
       }
    }

    public List<UserClass> getUsers(){
        return userRepository.findAll();
    }
}
