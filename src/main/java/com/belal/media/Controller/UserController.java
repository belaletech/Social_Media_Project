package com.belal.media.Controller;


import com.belal.media.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {


    @GetMapping("/users")
    public List<User> getUser()
    {
        List<User> users=new ArrayList<>();
        User user1=new User(1,"code","Belal","codewithbelal@gmail.com","123");
        User user2=new User(2,"ayan","Raza","codewithraza@gmail.com","121");
        users.add(user1);
        users.add(user2);
        return users;
    }

    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable("userId")Integer id)
    {
        User user1=new User(1,"code","Belal","codewithbelal@gmail.com","123");
        user1.setId(id);
        return user1;
    }


    @PostMapping("/users")
    public User createUser(@RequestBody User user)
    {
        User newUser=new User();
        newUser.setId(user.getId());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());


        return newUser;
    }

}
