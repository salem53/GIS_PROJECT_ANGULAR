package com.hin.spatial.postgis.model;


import com.vividsolutions.jts.geom.LineString;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Data
@Embeddable
public class Features {

    private String type;

    @Embedded
    private Properties properties;

    private LineString geometry;


}
