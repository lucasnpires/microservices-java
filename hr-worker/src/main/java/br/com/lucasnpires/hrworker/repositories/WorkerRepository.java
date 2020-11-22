package br.com.lucasnpires.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucasnpires.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
