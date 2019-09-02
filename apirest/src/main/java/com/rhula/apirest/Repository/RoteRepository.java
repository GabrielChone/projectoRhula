package com.rhula.apirest.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rhula.apirest.Model.Rote;


public interface RoteRepository extends JpaRepository<Rote, Long> {
	
	default ArrayList<Rote> findById(Long Id) {
		return null;

}
	List<Rote> findAll();
}