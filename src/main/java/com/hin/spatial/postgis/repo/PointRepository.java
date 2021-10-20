package com.hin.spatial.postgis.repo;

import com.hin.spatial.postgis.model.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointRepository extends JpaRepository<Point,Long> {
    public List<Point>  findAll();
    public Point createPoint(Point p);

}
