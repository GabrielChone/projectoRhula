package com.rhula.apirest.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rhula.apirest.Model.Transfer;


public interface TransferRepository extends JpaRepository<Transfer, Long>{
	
	default ArrayList<Transfer> findById(Long Id) {
		return null;

}
	List<Transfer> findAll();
}