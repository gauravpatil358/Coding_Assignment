package com.user.authentication.service;

import com.user.authentication.model.User;
import com.user.authentication.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;


    public User createUser(User user){
        return userRepo.save(user);
    }

    public User editUser(User user,String userId){
        User exstingUser = userRepo.findById(userId).orElseThrow(()->new RuntimeException("User not found with Id" + userId));
        exstingUser.setName(user.getName());
        exstingUser.setEmail(user.getEmail());
        return userRepo.save(exstingUser);
    }

    public void deleteUser(String userId){

        userRepo.findById(userId).orElseThrow(()-> new RuntimeException("User not found with Id"+userId));
        userRepo.deleteById(userId);
    }


    private List<User> store = new ArrayList<>();

    public UserService(){
        store.add(new User(UUID.randomUUID().toString(),"Gaurav ","gaurav@123.com"));
        store.add(new User(UUID.randomUUID().toString(),"Sachin","sachin@123.com"));
        store.add(new User(UUID.randomUUID().toString(),"Vivek ","vivek@123.com"));
        store.add(new User(UUID.randomUUID().toString(),"Shubham","shubham@123.com"));
    }

    public List<User>  getUser(){
        return this.store;
    }

}
