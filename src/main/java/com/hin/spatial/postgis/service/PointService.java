package com.hin.spatial.postgis.service;

import com.hin.spatial.postgis.model.Point;
import com.hin.spatial.postgis.repo.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointService {

    @Autowired
    private PointRepository pointrepo;
    public List<Point> getAllPoints() {
        return pointrepo.findAll();
    }


}
