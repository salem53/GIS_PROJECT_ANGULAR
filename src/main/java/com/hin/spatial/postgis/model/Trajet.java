package com.hin.spatial.postgis.model;

import lombok.Data;
import com.vividsolutions.jts.geom.Point;
import javax.persistence.*;

import java.util.Date;

@Data
@Entity(name = "trajet")
public class Trajet {

	@Id  @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private long id;

	@Column(name="nom")
	private String nom;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date")
	private Date date;


	/*@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "depart_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore*/

	@Column(columnDefinition ="geography")
	private Point pointDepart;
	/*@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "arrivee_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore*/

	@Column(columnDefinition ="geography")
	private Point pointArrivee;

}
