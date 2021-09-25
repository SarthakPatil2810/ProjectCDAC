package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "review_table")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Review extends BaseEntity {
    @Column(name = "review_description")  
    @NotNull
	private String reviewDescription;
    
    @Column(name = "rating")
    @Min(value = 1)
    @Max(value = 5)
    @NotNull
	private int rating;
	
    @ManyToOne
    @JoinColumn(name = "hostel_id")
    private PetHostel hostel;
	
}
