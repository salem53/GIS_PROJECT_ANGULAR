package com.hin.spatial.postgis.controller;


import com.hin.spatial.postgis.model.Trajet;
import com.hin.spatial.postgis.model.TrajetGeoJson;
import com.hin.spatial.postgis.model.User;
import com.hin.spatial.postgis.repo.TrajetRepository;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping({"/trajet"})
@CrossOrigin("*")
public class TrajetController {

    @Autowired
    private TrajetRepository trajetRepository;

    public TrajetController(TrajetRepository trajetRepository){
        this.trajetRepository = trajetRepository;
    }

    // get trajet
    @GetMapping("/{trajetId}")
    public Map getTrajetById(@PathVariable Long trajetId) {

        // get trajet from database
        java.util.Optional<Trajet> optionalTrajet = trajetRepository.findById(trajetId);
        //verify trajet is present
        if(optionalTrajet.isPresent()) {
            Trajet trajet = optionalTrajet.get();


            //Build the geoJson : result
            //Build the geoJson : result
            HashMap geoJson = new HashMap();
            geoJson.put("type","FeatureCollection");
            geoJson.put("name",trajet.getNom());

            // Create features list : will contain 3 featurs
            // the 1st : with type LineString (trajectoire)
            // the 2nd : with type Point (pointDepart)
            // the 3rd : with type Point (pointArrivee)

            ArrayList<Map> features = new ArrayList<Map>();
            HashMap trajectFeature= new HashMap(),pointDepartFeature= new HashMap(),pointArriveeFeature= new HashMap(),properties= new HashMap();

            properties.put("id_trajet",trajet.getId());
            properties.put("user",trajet.getUser());
            properties.put("date",trajet.getDate());

            trajectFeature.put("type","Feature");
            trajectFeature.put("properties",properties);
            trajectFeature.put("geometry",trajet.getTrajectoire());

            pointDepartFeature.put("type","Feature");
            pointDepartFeature.put("properties",properties);
            pointDepartFeature.put("geometry",trajet.getPointDepart());

            pointArriveeFeature.put("type","Feature");
            pointArriveeFeature.put("properties",properties);
            pointArriveeFeature.put("geometry",trajet.getPointArrivee());

            features.add(trajectFeature) ;
            features.add(pointDepartFeature) ;
            features.add(pointArriveeFeature) ;

            geoJson.put("features",features);

            return geoJson;

        }
        return null;

    }

    //add trajet
    @PostMapping
    public Trajet createTrajet(@RequestBody TrajetGeoJson trajetGeoJson){

        Trajet trajet = new Trajet();

        trajet.setNom(trajetGeoJson.getName());
        trajet.setDate((Date)trajetGeoJson.getFeatures().get(0).get("properties").get("date"));
        trajet.setUser((User)trajetGeoJson.getFeatures().get(0).get("properties").get("user"));
        trajet.setTrajectoire((LineString) trajetGeoJson.getFeatures().get(0).get("geometry"));
        trajet.setPointDepart((Point)trajetGeoJson.getFeatures().get(1).get("geometry"));
        trajet.setPointArrivee((Point)trajetGeoJson.getFeatures().get(2).get("geometry"));

        return trajetRepository.save(trajet);

    }


}
