package com.enrique.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringBootServicioItemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootServicioItemApplication.class, args);
	}

}
