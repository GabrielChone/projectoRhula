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

import com.rhula.apirest.Model.Rote;
import com.rhula.apirest.Repository.RoteRepository;

@RestController
@RequestMapping("/rote/v2")
public class RoteResource {
	
	
	@Autowired
	
private RoteRepository roteRepository;
	
	@GetMapping("/rt")
	public ArrayList<Rote> getAllPayments() {
	    return (ArrayList<Rote>) roteRepository.findAll();
	  }
	public ResponseEntity<ArrayList<Rote>> listAll(){
		ArrayList<Rote> rt = (ArrayList<Rote>) roteRepository.findAll();
		
		return !rt.isEmpty() ? ResponseEntity.status(HttpStatus.OK).body(rt) : ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<Rote> registar(@Valid @RequestBody Rote rote ){
		Rote rt = roteRepository.save(rote);
		
		return  ResponseEntity.status(HttpStatus.CREATED).body(rote);
	}
	
	@PutMapping
	public ResponseEntity<Rote> update(@RequestBody Rote rote ){
		
		Rote rt=roteRepository.findOne(rote.getId());
		if(rt!=null) {
			rt =roteRepository.save(rote);
		}
		
		return rt!=null ? ResponseEntity.ok(rt) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("{/delete/id}")
	public ResponseEntity<Rote> deletePayment(@PathVariable (name="id") Long rt ){
		
		Rote rote= roteRepository.findOne(rt);
		if(rote!=null) {
		
		roteRepository.delete(rt);
	}
		
		return rt!=null ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
	}



}
