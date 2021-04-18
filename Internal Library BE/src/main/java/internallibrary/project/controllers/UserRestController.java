package internallibrary.project.controllers;



import internallibrary.project.model.UserClass;
import internallibrary.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3001", maxAge = 3600)
public class UserRestController {


    @Autowired
    UserService userService;

    @PostMapping
    public void addUser(@RequestBody UserClass user){
        userService.addUser(user);
    }

    @GetMapping
    public List<UserClass> getUsers(){
        return userService.getUsers();
    }
}
