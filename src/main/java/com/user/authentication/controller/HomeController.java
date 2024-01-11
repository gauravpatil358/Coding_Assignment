package com.user.authentication.controller;

import com.user.authentication.model.User;
import com.user.authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    //http://localhost:8081/home/users

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUser() {
        System.out.println("Getting List of Users ");
        return userService.getUser();
    }

    @GetMapping("/current-user")
    public String getLoggedInUser(Principal principal){
        return principal.getName();
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user){
       return userService.createUser(user);
    }

    @PutMapping("/user/{userId}")
    public User updateUser(@RequestBody User user,@PathVariable String userId){
        return userService.editUser(user,userId);
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
        return "User deleted Successfully with id"+userId;
    }


}
