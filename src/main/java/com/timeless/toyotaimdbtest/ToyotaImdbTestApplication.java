package com.timeless.toyotaimdbtest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication @Slf4j
public class ToyotaImdbTestApplication implements CommandLineRunner {

	public static void main(String[] args) {

		log.info("Starting the application");
		SpringApplication.run(ToyotaImdbTestApplication.class, args);
		log.info("Application finished");
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Application started with command-line argument: {}", args[0]);
	}
}
