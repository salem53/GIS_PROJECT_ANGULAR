package com.hin.spatial.postgis.model;

import lombok.Data;

import java.util.ArrayList;

import java.util.Map;

@Data
public class TrajetGeoJson {
    private String type;
    private String name;
    private ArrayList<Map<String,Map>> features = new ArrayList<Map<String,Map>>();
}
