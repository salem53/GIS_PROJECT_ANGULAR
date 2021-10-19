package com.hin.spatial.postgis.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity(name = "point")
public class Point {

	@Id
	@Column(name="id")
	private long id;
	
	@Column(name="latitude")
	private double latitude;
	
	@Column(name="longitude")
	private double longitude;

	@OneToMany(mappedBy="pointArrivee")
	private Set<Trajet> trajetArrivee;

	@OneToMany(mappedBy="pointDepart")
	private Set<Trajet> trajetDepart;



}
