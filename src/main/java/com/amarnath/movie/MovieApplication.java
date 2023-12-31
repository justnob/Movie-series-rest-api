package com.amarnath.movie;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MovieApplication {
	
	@Bean
	public ModelMapper modleMapper() {
		
		return new ModelMapper();
		
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieApplication.class, args);
	}

}
