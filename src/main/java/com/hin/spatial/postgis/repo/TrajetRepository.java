package com.hin.spatial.postgis.repo;


import com.hin.spatial.postgis.model.Trajet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hin.spatial.postgis.model.User;
import java.util.List;

@Repository
public interface TrajetRepository extends JpaRepository<Trajet, Long> {

        List<Trajet> findByUser(User user);

}
