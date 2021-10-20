package com.hin.spatial.postgis.model;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "user")
@Table(name ="user",uniqueConstraints={@UniqueConstraint(columnNames={"email"})})
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

}
