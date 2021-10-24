package com.hin.spatial.postgis.controller;

import com.hin.spatial.postgis.model.User;
import com.hin.spatial.postgis.service.userServiceImpl;
import com.hin.spatial.postgis.controller.encryptDecrypt.AES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("user")
@CrossOrigin("*")
public class userController {
    @Autowired
    private userServiceImpl userService;

    @GetMapping("/{userId}")
    public java.util.Optional<User> getUser(@PathVariable Long userId) {

        return  userService.findById(userId);
    }
    @PostMapping("/add")
    public User createUser(@Valid @RequestBody User admin) {
        admin.setPassword(AES.encrypt(admin.getPassword(),AES.getPersonalkey()));
        return userService.saveUser(admin);
    }
    @GetMapping("/getUserByEmail/{userEmail}")
    public User getUserByEmail(@PathVariable String userEmail) {
        User admin = userService.findUserByEmail(userEmail).get();
        admin.setPassword(AES.decrypt(admin.getPassword(),AES.getPersonalkey()));
        return admin;
    }
    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId,@Valid @RequestBody User adminRequest) {
        return userService.updateUser(userId,adminRequest);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        return userService.deleteUser(userId);
    }

    public userController(userServiceImpl userService) {
        this.userService = userService;
    }
}
