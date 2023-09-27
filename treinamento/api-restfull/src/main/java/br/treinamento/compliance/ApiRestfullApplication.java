package br.treinamento.compliance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class ApiRestfullApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestfullApplication.class, args);
	}

}
