package com.hin.spatial.postgis.service;

import com.hin.spatial.postgis.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface userService {
    public User saveUser(User admin);

    public User updateUser(Long adminId,User admin);

    public ResponseEntity<Object> deleteUser(Long adminId);

    public Optional<User> findUserByEmail(String email);
    public Optional<User> findById(Long id);

    public List<User> getAll();
}
