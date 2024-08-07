package com.algaworks.algafood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.algaworks.algafood.infrastrucuture.repository.CustomJpaRepositoryImpl;

@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImpl.class) // tornando o repository base o custom que foi criado. Útil quando não queremos repetir código.
@SpringBootApplication
public class AlgafoodApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlgafoodApiApplication.class, args);
	}

}
