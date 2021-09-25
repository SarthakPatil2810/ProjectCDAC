package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.PetHostel;

public interface HostelRepository extends  JpaRepository<PetHostel, Integer>  {


	@Query(value = "select h from PetHostel h")
	List<PetHostel> displayHostel();
	
	
	
}
