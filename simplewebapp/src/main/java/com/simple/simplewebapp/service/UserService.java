package com.simple.simplewebapp.service;

import com.simple.simplewebapp.entity.User;
import com.simple.simplewebapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //@Autowired
    //private BCryptPasswordEncoder passwordEncoder;

    public void registerUser(User user) {
        //String encodedPassword = passwordEncoder.encode(user.getPassword());
        //user.setPassword(encodedPassword);
        userRepository.save(user);
    }

    public User loginUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        //if (user != null && passwordEncoder.matches(password, user.getPassword())) {
        if (user != null && password.equals(user.getPassword())) {
            return user;
        }
        return null;
    }
}

