package com.batch.execution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BatchExecutionApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchExecutionApplication.class, args);
	}

}
