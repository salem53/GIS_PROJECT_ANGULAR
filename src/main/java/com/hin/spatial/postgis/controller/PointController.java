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
        private PointRepository pointRepository;
        @Autowired
        private PointService pointService;

        @GetMapping("/")
        public String back(){return "hii thereee !";}
        @GetMapping("/Points")
        public List<Point> getPoints(Long id)
        {
            return pointRepository.findAllById(id);
        }
        @PostMapping("/Point")
        private void addPoint(@RequestBody Point point)
        {
                pointService.saveOrUpdate(point);

        }








}
