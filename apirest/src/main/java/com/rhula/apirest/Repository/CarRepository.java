package com.rhula.apirest.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.rhula.apirest.Model.Car;


@Service
public interface CarRepository extends JpaRepository<Car, Long>{
	default ArrayList<Car> findById(Car car) {
		return null;
	

		
}
	List<Car> findAll();

}