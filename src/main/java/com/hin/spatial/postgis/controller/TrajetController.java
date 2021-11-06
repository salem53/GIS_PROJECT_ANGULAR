package com.hin.spatial.postgis.controller;


import com.hin.spatial.postgis.model.Trajet;
import com.hin.spatial.postgis.model.TrajetGeoJson;
import com.hin.spatial.postgis.model.User;
import com.hin.spatial.postgis.repo.TrajetRepository;
import com.hin.spatial.postgis.repo.userRepository;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping({"/trajet"})
@CrossOrigin("*")
public class TrajetController {

    @Autowired
    private TrajetRepository trajetRepository;

    @Autowired
    private userRepository userRepo;

    public TrajetController(TrajetRepository trajetRepository){
        this.trajetRepository = trajetRepository;
    }

   // get trajet
    @GetMapping("/{trajetId}")
    public Trajet getTrajetById(@PathVariable Long trajetId) {

        java.util.Optional<Trajet> optionalTrajet = trajetRepository.findById(trajetId);
        if(optionalTrajet.isPresent()) {
            Trajet trajet = optionalTrajet.get();
            return trajet;
        }
        return null;

    }

    // get all trajects
    @GetMapping("/all")
    public List<Trajet> getAlltrajects() {
        return trajetRepository.findAll();
    }


    //add trajet
    @PostMapping
    public Trajet createTrajet(@RequestBody @Valid Trajet trajet){
        Long id = trajet.getFeatures().getProperties().getIdUser();
        System.out.println(id);
        User user = userRepo.getById(id);
        trajet.setUser(user);
        return trajetRepository.save(trajet);
    }


}
