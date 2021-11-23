package com.hin.spatial.postgis.model;

import com.sun.istack.NotNull;
import com.vividsolutions.jts.geom.Point;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity(name = "utilisateur")
@Table(name ="utilisateur",uniqueConstraints={@UniqueConstraint(columnNames={"email"})})
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@Column(name="firstName")
	@NotNull
	private String firstName;

	@Column(name="lastName")
	@NotNull
	private String lastName;


	@Column(name="email")
	@NotNull
	private String email;

	@Column(name="password")
	@NotNull
	private String password;

	public User(long id, String firstName, String lastName, String email, String password) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public User() {
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
