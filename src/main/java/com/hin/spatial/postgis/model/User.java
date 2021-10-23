package com.hin.spatial.postgis.model;

import com.vividsolutions.jts.geom.Point;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity(name = "utilisateur")
@Table(name ="utilisateur",uniqueConstraints={@UniqueConstraint(columnNames={"email"})})
public class User {

	@Id     @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@Column(name="firstName")
	private String firstName;

	@Column(name="lastName")
	private String lastName;


	@Column(name="email")
	private String email;

	@Column(name="password")
	private String password;

	@OneToMany(mappedBy="user")
	private Set<Trajet> trajets;
}
