package com.rhula.apirest.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rhula.apirest.Model.Payment;


public interface PaymentRepository extends JpaRepository<Payment, Long>{
	
	default ArrayList<Payment> findById(Long Id) {
		return null;

}
	List<Payment> findAll();
}