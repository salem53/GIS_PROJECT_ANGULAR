package com.hin.spatial.postgis.repo;

import com.hin.spatial.postgis.model.Point;

import java.util.List;

public abstract class PointImp implements  PointRepository{

    @Override
    public Point createPoint(Point p) {
       return new Point();

    }
}