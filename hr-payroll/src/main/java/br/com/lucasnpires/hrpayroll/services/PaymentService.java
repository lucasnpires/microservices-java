package br.com.lucasnpires.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.lucasnpires.hrpayroll.entities.Payment;
import br.com.lucasnpires.hrpayroll.entities.Worker;

@Service
public class PaymentService {
		
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${hr-worker.host}")
	private String workerHost;
	
	public Payment getPayment(Long workerId, Integer days) {
		
		Map<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("id", workerId.toString());
		
		Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);
		
		
		return Payment.builder().name(worker.getName()).dailyIncome(worker.getDailyIncome()).days(days).build();				
	}
}
