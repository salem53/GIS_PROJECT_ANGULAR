package com.hin.spatial.postgis.service;

import com.hin.spatial.postgis.model.Point;
import com.hin.spatial.postgis.model.User;
import com.hin.spatial.postgis.repo.PointRepository;
import com.hin.spatial.postgis.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public void saveOrUpdate(User user)
    {
        userRepository.save(user);
    }

}
