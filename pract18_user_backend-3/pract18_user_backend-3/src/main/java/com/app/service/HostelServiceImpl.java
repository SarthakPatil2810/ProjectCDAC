package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custome_exception.UserHandlingException;
import com.app.dao.HostelRepository;
import com.app.pojos.PetHostel;

@Service
@Transactional
public class HostelServiceImpl implements IHostelService {
	@Autowired
	private HostelRepository hostelRepo;
	@Override
	public List<PetHostel> fetchAllHostels() {
	
		return hostelRepo.findAll();
	}
	@Override
	public PetHostel saveHostelDetails(PetHostel hostel) {
	
		return hostelRepo.save(hostel);
	}
	@Override
	public List<PetHostel> displayHostel() {
		
		return hostelRepo.displayHostel();
	}
	@Override
	public PetHostel updatePetHostelDetails(PetHostel detachedPetHostel) {
		
		return hostelRepo.save(detachedPetHostel);
	}
	@Override
	public PetHostel getPetHostelById(int hostelId) {
		
		return hostelRepo.findById(hostelId).orElseThrow(()->new UserHandlingException("invalid User ID"));
	}

}
