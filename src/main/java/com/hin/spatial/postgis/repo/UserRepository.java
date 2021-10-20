package com.hin.spatial.postgis.repo;

import com.hin.spatial.postgis.model.Point;
import com.hin.spatial.postgis.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository <User,Long> {
    public List<User> findAllById(Long id);


}

