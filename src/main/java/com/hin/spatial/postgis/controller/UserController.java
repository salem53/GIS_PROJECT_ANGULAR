package com.hin.spatial.postgis.controller;

import com.hin.spatial.postgis.model.Point;
import com.hin.spatial.postgis.model.User;
import com.hin.spatial.postgis.repo.UserRepository;
import com.hin.spatial.postgis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UserController {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userservice;


    @GetMapping("/Users")
    public List<User> getUsers(Long id) {
        return userRepository.findAllById(id);
    }

    @PostMapping("/User")
    private void saveUser( User user) {
        userservice.saveOrUpdate(user);

    }

}







