package com.rhula.apirest.Resource;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rhula.apirest.Model.Car;
import com.rhula.apirest.Repository.CarRepository;

@RestController
@RequestMapping("/car/v1")

public class CarResource  {
	
	@Autowired
	
	private CarRepository carRepository;
	
	@GetMapping("/car")
	public ArrayList<Car> getAllCars() {
	    return (ArrayList<Car>) carRepository.findAll();
	  }
	public ResponseEntity<ArrayList<Car>> listAll(){
		ArrayList<Car> ca = (ArrayList<Car>) carRepository.findAll();
		
		return !ca.isEmpty() ? ResponseEntity.status(HttpStatus.OK).body(ca) : ResponseEntity.noContent().build();
	}

	
	@PostMapping
	public ResponseEntity<Car> registar(@Valid @RequestBody Car car ){
		Car ca = carRepository.save(car);
		
		return  ResponseEntity.status(HttpStatus.CREATED).body(car);
	}

	@PutMapping
	public ResponseEntity<Car> update(@RequestBody Car car ){
		
		Car ca=carRepository.findOne(car.getId());
		if(ca!=null) {
			ca =carRepository.save(car);
		}
		
		return ca!=null ? ResponseEntity.ok(ca) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("{/apagar/id}")
	public ResponseEntity<Car> deleteCar(@PathVariable (name="id") Long ca ){
		
		Car car= carRepository.findOne(ca);
		if(car!=null) {
		
			carRepository.delete(ca);
	}
		
		return ca!=null ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
	}
}
