package com.app.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "customer_table")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Setter
public class Customer extends BaseEntity {

	@Column(name = "petname", length = 30)
	@NotNull
	private String petName;

	@Column(name = "pet_description", length = 100)
	@NotNull
	private String petDescription;

	@Column(name = "pet_food", length = 30)
	@NotNull
	private String petFood;

	@Lob
	@Column(name = "pet_photo")
//   @NotNull
	private byte[] petPhoto;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "customer",fetch=FetchType.LAZY)
//	@JsonIgnoreProperties("customer")
	private Bookings booking;

	@OneToOne(/* cascade = CascadeType.ALL */ )
	@JoinColumn(name = "user_id")
	private User user;

	public String getPetName() {
		return petName;
	}

	public String getPetDescription() {
		return petDescription;
	}

	public String getPetFood() {
		return petFood;
	}

	public byte[] getPetPhoto() {
		return petPhoto;
	}

	//@JsonManagedReference
	public Bookings getBooking() {
		return booking;
	}

	public User getUser() {
		return user;
	}

//	public void addBooking(Bookings booking) {
//		this.booking  = booking;
//		booking.setCustomer(this);
//	}
}
