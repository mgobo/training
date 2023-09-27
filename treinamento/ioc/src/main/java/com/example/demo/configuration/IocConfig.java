package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.beans.Animal;

@Configuration
public class IocConfig {

	private Animal animal;
	
	@Bean
	public Animal animal() {
		if(this.animal == null) {
			return new Animal();
		}
		return null;
	}
	
}
