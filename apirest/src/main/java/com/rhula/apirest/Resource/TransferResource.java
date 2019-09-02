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

import com.rhula.apirest.Model.Transfer;
import com.rhula.apirest.Repository.TransferRepository;

@RestController
@RequestMapping("/transfer/v2")
public class TransferResource {
	
	@Autowired
	
	private TransferRepository transferRepository;
		
		@GetMapping("/tr")
		public ArrayList<Transfer> getAllTransfer() {
		    return (ArrayList<Transfer>) transferRepository.findAll();
		  }
		public ResponseEntity<ArrayList<Transfer>> listAll(){
			ArrayList<Transfer> tr = (ArrayList<Transfer>) transferRepository.findAll();
			
			return !tr.isEmpty() ? ResponseEntity.status(HttpStatus.OK).body(tr) : ResponseEntity.noContent().build();
		}
		
		@PostMapping
		public ResponseEntity<Transfer> regist(@Valid @RequestBody Transfer transfer ){
			Transfer tr = transferRepository.save(transfer);
			
			return  ResponseEntity.status(HttpStatus.CREATED).body(transfer);
		}
		
		@PutMapping
		public ResponseEntity<Transfer> update(@RequestBody Transfer transfer ){
			
			Transfer tr=transferRepository.findOne(transfer.getId());
			if(tr!=null) {
				tr =transferRepository.save(transfer);
			}
			
			return tr!=null ? ResponseEntity.ok(tr) : ResponseEntity.notFound().build();
		}
		
		@DeleteMapping("{/apagar/id}")
		public ResponseEntity<Transfer> deleteTransfer(@PathVariable (name="id") Long tr ){
			
			Transfer transfer= transferRepository.findOne(tr);
			if(transfer!=null) {
			
			transferRepository.delete(tr);
		}
			
			return tr!=null ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
		}


}
