package com.hin.spatial.postgis.service;

import com.hin.spatial.postgis.model.Point;
import com.hin.spatial.postgis.repo.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointService {

    @Autowired
    private PointRepository pointRepository;

    public void saveOrUpdate(Point point)
    {
        pointRepository.save(point);
    }

    public void deletePoint(long id)
    {
        pointRepository.deleteById( id);
    }

    public void updatePoint(Point point, long Pointid)
    {
        pointRepository.save(point);
    }


}
