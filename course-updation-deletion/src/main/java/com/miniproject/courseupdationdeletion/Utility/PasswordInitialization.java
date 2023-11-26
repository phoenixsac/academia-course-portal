package com.miniproject.courseupdationdeletion.Utility;

import com.miniproject.courseupdationdeletion.Entities.User;
import com.miniproject.courseupdationdeletion.Repository.UserRepository;
import com.miniproject.courseupdationdeletion.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class PasswordInitialization {

    @Autowired
    private UserServiceImpl userService; // Assuming you have a UserService to manage users

    @Autowired
    private UserRepository userRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostConstruct
    private void init() {
        storeHashedPasswords();
    }

    public void storeHashedPasswords(){
        System.out.println("Inside hash pwd method");
        String encodedPass;
        List<User> userList=userRepo.getAllUsers();
        for (User user : userList) {
            encodedPass = hashPassword(user.getPassword());
            user.setPassword(encodedPass);
        }

        userRepo.saveAll(userList);
    }

    private String hashPassword(String rawPassword) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(rawPassword);
    }
}
