package com.belal.media.Controller;


import com.belal.media.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {


    @GetMapping("/users")
    public List<User> getUsers()
    {
        List<User> users=new ArrayList<>();
        User user1=new User("code","Belal","codewithbelal@gmail.com","123");
        User user2=new User("ayan","Raza","codewithraza@gmail.com","121");
        users.add(user1);
        users.add(user2);
        return users;
    }

}
