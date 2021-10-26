package com.hin.spatial.postgis.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.Set;

@Data
@Embeddable
public class Properties {

    private Long idUser;

    @Temporal(TemporalType.TIMESTAMP)
    @ElementCollection
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Set<Date> dateTime;
}
