package com.hin.spatial.postgis.repo;


import com.hin.spatial.postgis.model.Trajet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrajetRepository extends JpaRepository<Trajet, Long> {
}
