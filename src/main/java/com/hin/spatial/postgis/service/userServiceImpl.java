package com.hin.spatial.postgis.service;

import com.hin.spatial.postgis.controller.Exceptions.ResourceNotFoundException;
import com.hin.spatial.postgis.model.User;
import com.hin.spatial.postgis.repo.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service("User service")
@Transactional
public class userServiceImpl implements userService{
    @Autowired
    private userRepository user;
    @Override
    public User saveUser(User admin) {
        return user.save(admin);
    }

    @Override
    public User updateUser(Long adminId, User admin) {

        return user.findById(adminId).map(userRequest -> {
            userRequest.setFirstName(admin.getFirstName());
            userRequest.setLastName(admin.getLastName());
            userRequest.setEmail(admin.getEmail());
            return user.save(userRequest);
        }).orElseThrow(() -> new ResourceNotFoundException("AdminId " + adminId + " not found"));
    }

    @Override
    public ResponseEntity<Object> deleteUser(Long adminId) {
        return user.findById(adminId).map(admin -> {
            user.delete(admin);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("AdminId " +
                adminId + " not found"));
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return user.findByEmail(email);
    }

    @Override
    public Optional<User> findById(Long id) {
        return user.findById(id);
    }

    @Override
    public List<User> getAll() {
        return user.findAll();
    }

    public userServiceImpl(userRepository user) {
        this.user = user;
    }
}
