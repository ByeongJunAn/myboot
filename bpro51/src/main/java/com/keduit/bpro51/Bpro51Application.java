package com.keduit.bpro51;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Bpro51Application {

	public static void main(String[] args) {
		SpringApplication.run(Bpro51Application.class, args);
	}

}
