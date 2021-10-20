package com.hin.spatial.postgis.controller;


import com.hin.spatial.postgis.model.Point;
import com.hin.spatial.postgis.repo.PointImp;
import com.hin.spatial.postgis.repo.PointRepository;
import com.hin.spatial.postgis.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping
public class PointController {
        @Autowired
        private PointService PointService;

        @GetMapping("/Points")
        public List<Point> getPoints()
        {
            return PointService.getAllPoints();
        }
        @PostMapping("/Point")
        public void add(@RequestBody PointRepository pt ){
             pt.createPoint(new Point());
        }







}
