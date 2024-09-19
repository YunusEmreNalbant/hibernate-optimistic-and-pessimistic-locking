package com.yunusemrenalbant.locking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class HibernatePessimisticOptimisticApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernatePessimisticOptimisticApplication.class, args);
	}

}
