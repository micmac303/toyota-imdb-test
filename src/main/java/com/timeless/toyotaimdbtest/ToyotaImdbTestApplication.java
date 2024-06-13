package com.timeless.toyotaimdbtest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication @Slf4j
public class ToyotaImdbTestApplication {

    public static void main(String[] args) {

		log.info("\n\n\n*** Starting the application\n\n\n*** ");
		SpringApplication.run(ToyotaImdbTestApplication.class, args);
		log.info("\n\n\n*** Application finished\n\n\n*** ");
	}
}
