package com.hin.spatial.postgis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.DateTimeException;
import java.util.Date;

@Data
@Entity(name = "trajet")
public class Trajet {

	@Id     @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private long id;

	@Column(name="nom")
	private String nom;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date")
	private Date date;


	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "depart_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Point pointDepart;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "arrivee_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Point pointArrivee;


}
