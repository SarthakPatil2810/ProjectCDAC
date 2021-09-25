package com.app.service;

import java.util.List;

import com.app.pojos.PetHostel;

public interface IHostelService {
	public List<PetHostel> fetchAllHostels();
	public List<PetHostel> displayHostel();
	public PetHostel saveHostelDetails(PetHostel hostel);
	public PetHostel updatePetHostelDetails(PetHostel detachedPetHostel);
	public PetHostel getPetHostelById(int hostelId);

	
}
