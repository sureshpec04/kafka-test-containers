package com.testcontainers.springkafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringKafkaContainerApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringKafkaContainerApp.class, args);
	}
}
