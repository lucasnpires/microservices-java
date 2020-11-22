package br.com.lucasnpires.hrpayroll.services;

import org.springframework.stereotype.Service;

import br.com.lucasnpires.hrpayroll.entities.Payment;

@Service
public class PaymentService {
	
	
	public Payment getPayment(Long workerId, Integer days) {
		return Payment.builder().name("Bob").dailyIncome(200.00).days(days).build();				
	}
}
