package com.rhula.apirest.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rhula.apirest.Error.PaymentNotFoundException;
import com.rhula.apirest.Model.Payment;
import com.rhula.apirest.Repository.PaymentRepository;





@Service
public class PaymentService {
	
    private PaymentRepository paymentRepository;
@Autowired

public PaymentService(PaymentRepository paymentRepository) {
    this.paymentRepository = paymentRepository;
}

/**
 * Find All Payments
 *
 * @return
 */

public List<Payment> findAll() {
    return paymentRepository.findAll();
}

/**
 * Find payment by Id
 *
 * @param id Id of payment
 * @return If exist return payment
 */
public ArrayList<Payment> findById(Long id) {

    return paymentRepository.findById(id);
}




/**
 * Quantity of paymnt
 *
 * @return int
 */
public long total() {

    return paymentRepository.count();
}


/*public Payment findOne(Long id) {

    Optional<Payment> payment = paymentRepository.findById(id);

    if (payment.isPresent()) {

        return payment.get();
    } else {

        // TODO Criar o arquivo de mensagens
        throw new PaymentNotFoundException("Payment Not Found!");
    }
}*/
}
