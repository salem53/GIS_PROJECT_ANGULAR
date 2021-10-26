package com.hin.spatial.postgis.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Data;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;

@Data
public class TrajetGeoJson {
    private Map<String, String> map = new HashMap<>();

    @JsonAnyGetter
    public Map<String, String> any(){
        return this.map;
    }

    public Map<String, String> getMap() {
        return this.map;
    }

    @JsonAnySetter
    public void setMap(String key, String value) {
        map.put(key, value);
    }

    @Override
    public String toString() {
        return "Map [map=" + map + "]";
    }
    /*private String type;
    private String name;
    private ArrayList<Map<String,Map>> features = new ArrayList<Map<String,Map>>();*/
}
