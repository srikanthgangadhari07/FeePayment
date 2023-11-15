package com.payment.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class FeePaymentApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder().
		profiles("dev").sources(FeePaymentApplication.class).run(args);
	}

}
