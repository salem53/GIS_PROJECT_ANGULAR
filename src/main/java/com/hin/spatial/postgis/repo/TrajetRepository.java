package com.hin.spatial.postgis.repo;


import com.hin.spatial.postgis.model.City;
import com.hin.spatial.postgis.model.Trajet;
import com.hin.spatial.postgis.model.User;
import com.vividsolutions.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrajetRepository extends JpaRepository<Trajet, Long> {
    List<Trajet> findByUser(User user);
}
