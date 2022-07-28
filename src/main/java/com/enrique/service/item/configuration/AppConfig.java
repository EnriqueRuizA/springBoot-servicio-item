package com.enrique.service.item.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
	
	@Bean ("clienteRest")
	public RestTemplate registerRestTemplate() {
		return new RestTemplate();
	}
}
