package com.cafemanager.cafe.service;


import com.cafemanager.cafe.entity.Student;
import com.cafemanager.cafe.entity.User;
import com.cafemanager.cafe.repository.StudentRepository;
import com.cafemanager.cafe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User addUser(User user) {
        User u = userRepository.save(user);
        return userRepository.save(user);
    }

    public User findByUserEmail(String userEmail) {
     User userInfo = userRepository.findByEmail(userEmail);
     if (userInfo != null) {
         return userInfo;
     }
     return null;

    }

}
