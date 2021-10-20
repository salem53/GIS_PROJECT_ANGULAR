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


	public void setId(long id) {
		this.id = id;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public void setTrajetArrivee(Set<Trajet> trajetArrivee) {
		this.trajetArrivee = trajetArrivee;
	}

	public void setTrajetDepart(Set<Trajet> trajetDepart) {
		this.trajetDepart = trajetDepart;
	}

	public long getId() {
		return id;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public Set<Trajet> getTrajetArrivee() {
		return trajetArrivee;
	}

	public Set<Trajet> getTrajetDepart() {
		return trajetDepart;
	}
}
