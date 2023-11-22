package com.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8026")
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
	@PostMapping("/feePayment")
	public ResponseEntity<String> feePayment(@RequestBody PaymentDTO paymentDTO){
		paymentService.addPayment(paymentDTO);
		return ResponseEntity.ok().body("Payment Successful!");
	}
	@GetMapping("/paymentDetails/{studentId}")
	public ResponseEntity<String> paymentInfo(@PathVariable Integer studentId){
		long total=paymentService.paymentDetails(studentId);
		return ResponseEntity.ok().body("Total Fees Paid by Student= "+total);
	}
}
