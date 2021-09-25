package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "address_table")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Address extends BaseEntity{
  @Column(length = 30)
  @NotNull
  private String location;
  
  @Column(length = 30)
  @NotNull
  private String city;
  
  @Column(length = 30)
  @NotNull
  private String state;
  

	
  @Column(length = 30)
  @NotNull
  private String country;

//public Address(String location, String city, String state, String country) {
//	super();
//	this.location = location;
//	this.city = city;
//	this.state = state;
//	this.country = country;
//}

}
