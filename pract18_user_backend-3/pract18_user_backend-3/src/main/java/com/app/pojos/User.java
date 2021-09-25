package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user_table")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class User extends BaseEntity {
	@Column(length = 30)
	private String firstName;
	
	@Column(length = 30)
	private String lastName;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past
	@Column(name = "dob", nullable = false)
	private LocalDate dob;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address")
	@JsonIgnoreProperties("user")
	private Address address;
	
	@Column(length = 30, unique = true, nullable = false)
	private String email;
	
	@Column(length = 10, nullable = false)
	private String phoneNumber;
	
	@Column(length = 30, nullable = false)
	private String password;
	
	@Column(length = 30)
	@Enumerated(EnumType.STRING)
	private Role role;

	public User(String firstName, String lastName, @Past LocalDate dob, String email, String phoneNumber,
			String password, Role role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.role = role;
	}

}
