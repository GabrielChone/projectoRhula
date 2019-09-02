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

import com.rhula.apirest.Model.Payment;
import com.rhula.apirest.Repository.PaymentRepository;

@RestController
@RequestMapping("/passenger/v2")

public class PaymentResource {
	
	@Autowired
	
	private PaymentRepository paymentRepository;
	
	@GetMapping("/paym")
	public ArrayList<Payment> getAllPayments() {
	    return (ArrayList<Payment>) paymentRepository.findAll();
	  }
	public ResponseEntity<ArrayList<Payment>> listAll(){
		ArrayList<Payment> py = (ArrayList<Payment>) paymentRepository.findAll();
		
		return !py.isEmpty() ? ResponseEntity.status(HttpStatus.OK).body(py) : ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<Payment> registar(@Valid @RequestBody Payment payment ){
		Payment py = paymentRepository.save(payment);
		
		
		return  ResponseEntity.status(HttpStatus.CREATED).body(payment);
	}

	@PutMapping
	public ResponseEntity<Payment> update(@RequestBody Payment payment ){
		
		Payment pym=paymentRepository.findOne(payment.getId());
		if(pym!=null) {
			pym =paymentRepository.save(payment);
		}
		
		return pym!=null ? ResponseEntity.ok(pym) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("{/delete/id}")
	public ResponseEntity<Payment> deletePayment(@PathVariable (name="id") Long pym ){
		
		Payment payment= paymentRepository.findOne(pym);
		if(payment!=null) {
		
		paymentRepository.delete(pym);
	}
		
		return pym!=null ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
	}


}
