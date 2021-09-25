package com.app.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "hostel_table")
@NoArgsConstructor
@AllArgsConstructor
@Setter
//@Getter
@ToString
public class PetHostel extends BaseEntity{
    @Column(name = "hostel_name",length = 30)
    @NotNull
	private String hostelName;
    
    @Lob
    @Column(name = "hostel_logo")
	private byte[] logo;
    
    @Column(name = "aadhar_card_details",length = 12,unique = true)
    @NotNull
//    @Min(value = 12)
//    @Max(value = 12)
	private String ownerAadharCard;
    
    @Column(name = "registeration_amount")
    @NotNull
    private double registerationAmount;
    
    @Column(name = "availibility_status")
    @NotNull
	private boolean isAvailable;
    
    @NotNull
	private int capacity;
    
    @NotNull
    private double perDayCost;
    @Column(name = "verification_status")
    @NotNull
	private boolean isVerified;
    
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "hostel",fetch=FetchType.EAGER)
    @JsonIgnoreProperties("hostel")
    @JsonManagedReference
    private List<Bookings> bookings;
    
    @OneToOne
    @JoinColumn(name = "petHostel_id")
    private User user;

	public String getHostelName() {
		return hostelName;
	}

	public byte[] getLogo() {
		return logo;
	}

	public String getOwnerAadharCard() {
		return ownerAadharCard;
	}

	public double getRegisterationAmount() {
		return registerationAmount;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public int getCapacity() {
		return capacity;
	}

	public boolean isVerified() {
		return isVerified;
	}
//	@JsonManagedReference	
//public List<Bookings> getBookings() {
//		return bookings;
//	}

	public User getUser() {
		return user;
	}

	public double getPerDayCost() {
		return perDayCost;
	}

	
    
}
