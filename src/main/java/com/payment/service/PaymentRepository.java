package com.payment.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentDTO,Integer>{
	public List<PaymentDTO> findByStudentId(Integer studentId);
}
