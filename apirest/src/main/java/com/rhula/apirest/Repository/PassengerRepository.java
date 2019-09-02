package com.rhula.apirest.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.rhula.apirest.Model.Passenger;


@Service
public interface PassengerRepository extends JpaRepository<Passenger, Long> {
	
	default ArrayList<Passenger> findById(Long Id) {
		return null;

}
	List<Passenger> findAll();
}