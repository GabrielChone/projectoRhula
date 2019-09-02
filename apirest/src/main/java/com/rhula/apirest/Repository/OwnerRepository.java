package com.rhula.apirest.Repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.rhula.apirest.Model.Owner;



@Service
public interface OwnerRepository extends JpaRepository<Owner, Long>{
	
	default ArrayList<Owner> findById(Long Id) {
		return null;

}
	ArrayList<Owner> findAll();

}