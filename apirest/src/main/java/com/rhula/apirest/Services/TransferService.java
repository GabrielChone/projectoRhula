package com.rhula.apirest.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rhula.apirest.Model.Transfer;
import com.rhula.apirest.Repository.TransferRepository;

@Service

public class TransferService {
	
	private TransferRepository transferRepository;
	@Autowired

	public TransferService(TransferRepository transferRepository) {
	    this.transferRepository = transferRepository;
	}
	
	/**
	 * Find All Transfers
	 *
	 * @return
	 */

	public List<Transfer> findAll() {
	    return transferRepository.findAll();
	}
	/**
	 * Find transfers by Id
	 *
	 * @param id Id of transfer
	 * @return If exist return transfer
	 */
	public ArrayList<Transfer> findById(Long id) {

	    return transferRepository.findById(id);
	}

}
