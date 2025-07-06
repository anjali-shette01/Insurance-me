package com.insuranceme.insurance_me;

import com.insuranceme.insurance_me.model.Policy;
import com.insuranceme.insurance_me.repository.PolicyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InsuranceMeApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceMeApplication.class, args);
	}

	@Bean
	public CommandLineRunner preloadData(PolicyRepository repo) {
		return args -> {
			repo.save(new Policy(null, "John Doe", "Health", 12000.0, "2025-01-01", "2026-01-01"));
			repo.save(new Policy(null, "Alice", "Car", 8000.0, "2025-02-01", "2026-02-01"));
			repo.save(new Policy(null, "Bob", "Life", 15000.0, "2025-03-01", "2030-03-01"));
		};
	}
}
