package com.hin.spatial.postgis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.LineString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

import java.util.Date;

@Data
@Entity(name = "trajet")
public class Trajet {

	@Id  @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private long id;

	@Column(name="tipe")
	private String type;

	@Column(name="name")
	private String name;

	@Embedded
	private Features features;




	/*@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date")
	private Date date;*/


	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_user", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private User user;

	/*@Column(columnDefinition ="pointDepart")
	private Point pointDepart;


	@Column(columnDefinition ="pointArrivee")
	private Point pointArrivee;*/

	/*@Column(columnDefinition="geography")
	private LineString trajectoire;*/

}
