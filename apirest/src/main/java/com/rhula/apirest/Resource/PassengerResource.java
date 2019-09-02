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
import com.rhula.apirest.Model.Passenger;
import com.rhula.apirest.Repository.PassengerRepository;

@RestController
@RequestMapping
public class PassengerResource {
	@Autowired
	private PassengerRepository passengerRepository;
	
	@GetMapping
	public ArrayList<Passenger> getAllPassenger() {
	    return (ArrayList<Passenger>) passengerRepository.findAll();
	  }
	public ResponseEntity<ArrayList<Passenger>> listAll(){
		ArrayList<Passenger> ps = (ArrayList<Passenger>) passengerRepository.findAll();
		
		return !ps.isEmpty() ? ResponseEntity.status(HttpStatus.OK).body(ps) : ResponseEntity.noContent().build();
	}

	
	@PostMapping("{/criar}")
	public ResponseEntity<Passenger> regist(@Valid @RequestBody Passenger passenger ){
		Passenger ps = passengerRepository.save(passenger);
		
		return  ResponseEntity.status(HttpStatus.CREATED).body(passenger);
	}

	@PutMapping
	public ResponseEntity<Passenger> update(@RequestBody Passenger passenger ){
		
		Passenger ps= passengerRepository.findOne(passenger.getId());
		if(ps!=null) {
			ps = passengerRepository.save(passenger);
		}
		
		return ps!=null ? ResponseEntity.ok(ps) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("{/apagar/id}")
	public ResponseEntity<Passenger> deletePassenger(@PathVariable (name="id") Long ps ){
		
		Passenger passenger= passengerRepository.findOne(ps);
		if(passenger!=null) {
		
			passengerRepository.delete(ps);
	}
		
		return ps!=null ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
	}

}
