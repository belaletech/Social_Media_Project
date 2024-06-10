package com.belal.media.Controller;


import com.belal.media.models.User;
import com.belal.media.repository.UserRepository;
import com.belal.media.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;
    @PostMapping("/users")
    public User createUser(@RequestBody User user)
    {
        //for saving data in database
        User savedUser=userService.registerUser(user);
        return savedUser;
    }



    @GetMapping("/users")
    public List<User> getUser()
    {
        List<User> users=userRepository.findAll();
        return users;
    }

    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable("userId")Integer id) throws Exception
    {


        return userService.findUserById(id);
    }

    @PutMapping("/users/{userId}")
    public User updateUser(@RequestBody User user, @PathVariable Integer userId) throws Exception {

        return userService.updateUser(user,userId);
    }

    @DeleteMapping("users/{userId}")
    public String deleteUser(@PathVariable("userId") Integer userId) throws Exception {

        Optional<User> user=userRepository.findById(userId);

        if(user.isEmpty()){
            throw new Exception("user not exist with id"+userId);
        }

        userRepository.delete(user.get());
        return "user deleted successfully with id "+userId;
    }
}
