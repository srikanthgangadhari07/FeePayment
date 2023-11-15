package com.payment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {

	@Autowired
	PaymentRepository paymentRepository;
	
	public void addPayment(PaymentDTO paymentDTO) {
		paymentRepository.save(paymentDTO);
	}
	
	public long paymentDetails(Integer studentId) {
		List<PaymentDTO> paymentList=paymentRepository.findByStudentId(studentId);
		return paymentList.stream().map(x->x.getAmount()).reduce(0L,(subtotal,amount)->subtotal+amount);
	}
}
