package br.com.lucasnpires.hrworker.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucasnpires.hrworker.entities.Worker;
import br.com.lucasnpires.hrworker.repositories.WorkerRepository;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/workers")
@Slf4j
public class WorkerResource {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private WorkerRepository repository;
	
	@GetMapping
	private ResponseEntity<List<Worker>> findAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	
	@GetMapping(value = "/{id}")
	private ResponseEntity<Worker> findById(@PathVariable Long id){
//		int x = 1;		
//		if(x == 1)
//			throw new RuntimeException("teste");
		
//		try {
//			Thread.sleep(3000L);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		log.info("PORT = " + env.getProperty("local.server.port"));
		
		return ResponseEntity.ok(repository.findById(id).orElse(new Worker()));
	}
	
}
