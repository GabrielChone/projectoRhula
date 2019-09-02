package com.rhula.apirest.Resource;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Order;
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

import com.rhula.apirest.Model.Owner;
import com.rhula.apirest.Repository.OwnerRepository;



@RestController
@RequestMapping("/owner/v1")
public class OwnerResource {
	
	@Autowired
	
	private OwnerRepository ownerRepository;
	
	/**
	   * Get all users list.
	   *
	   * @return the list
	   */
	
@GetMapping("/getOwners/v1")
	public ArrayList<Owner> getAllOwners() {
	    return ownerRepository.findAll();
	  }
	public ResponseEntity<ArrayList<Owner>> listAll(){
		ArrayList<Owner> ow = (ArrayList<Owner>) ownerRepository.findAll();
		
		return !ow.isEmpty() ? ResponseEntity.status(HttpStatus.OK).body(ow) : ResponseEntity.noContent().build();
	}
	
	
   /* @GetMapping​({​"/owner/id}"​)
	@GetMapping("/owners")

	  public ResponseEntity<Owner> getUsersById​(​@PathVariable(​value = "id") Long ownerId)
	      throws ResourceNotFoundException {
	    User user =
	        userRepository
	            .findById(userId)
	            .orElseThrow(() -> new ResourceNotFoundException​(​"User not found on :: " + ownerId));
	    return ResponseEntity​.​ok​().​body​(owner);
	  }
	*/
@PostMapping("/postOwners/v1")
public ResponseEntity<Owner> regist(@Valid @RequestBody Owner owner ){
	Owner ow = ownerRepository.save(owner);
	
	return  ResponseEntity.status(HttpStatus.CREATED).body(owner);
}



@PutMapping("/putOwners/v1")
public ResponseEntity<Owner> update(@RequestBody Long owner ){
	
	Owner ow=ownerRepository.findOne(owner);
	if(ow!=null) {
		ow =ownerRepository.save(ow);
	}
	
	return ow!=null ? ResponseEntity.ok(ow) : ResponseEntity.notFound().build();
}

@DeleteMapping("/deleteOwners/v1")
public ResponseEntity<Owner> deleteOwn(@PathVariable (name="id") Long ow ){
	
	Owner owner=ownerRepository.findOne(ow);
	if(owner!=null) {
	
		ownerRepository.delete(ow);
}
	
	return ow!=null ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
}

/*
 * @PutMapping​(​"/owner/{id}"​)
  public ResponseEntity<Owner> updateUser(
      @PathVariable(value = "id") Long userId, @Valid @RequestBody User userDetails)
      throws ResourceNotFoundException {
    User user =
        userRepository
            .findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException​(​"User not found on :: " + userId));
    owner​.​setEmail​(​ownerDetails​.​getEmail​());
    owner​.​setName​(​ownerDetails​.​getName​());
    owner.setUpdatedAt(new Date());
    final Owner updatedOwner = ownerRepository.save(owner);
    return ResponseEntity​.​ok​(​updatedOwner);
  }
*/

/*
 * @DeleteMapping​(​"/owner/{id}"​)
  public Map<String, Boolean> deleteOwner(​@PathVariable​(​value = "id") Long ownerId) throws Exception {
    Owner owner =
        ownerRepository
            .findById(ownerId)
            .orElseThrow(() -> new ResourceNotFoundException​(​"Owner not found on :: " + ownerId));
    ownerRepository​.​delete​(​owner​);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }
}
 */




/**
 * @DeleteMapping
	public ResponseEntity<Produto> apagarProd(@RequestBody Produto produto ){
		
		Produto produt=produtoRepository.findById(produto.getId()).get();
		if(produt!=null) {
		
			produtoRepository.delete(produt);
}
		
		return produt!=null ? ResponseEntity.ok(produt) : ResponseEntity.notFound().build();
	}
	
 * 
 * 
 */

}
