package com.lab3.JalaStreaming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class JalaStreamingApplication {

	public static void main(String[] args) {
		SpringApplication.run(JalaStreamingApplication.class, args);
	}

}
