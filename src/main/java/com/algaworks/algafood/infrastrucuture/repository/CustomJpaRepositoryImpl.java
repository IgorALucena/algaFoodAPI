package com.algaworks.algafood.infrastrucuture.repository;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.algaworks.algafood.domain.repository.CustomJpaRepository;

public class CustomJpaRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID>
	implements CustomJpaRepository<T, ID> { // SimpleJpaRepository é a implementação base do jpa

	private EntityManager manager;
	
	public CustomJpaRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, 
			EntityManager entityManager) {
		super(entityInformation, entityManager);
		
		this.manager = entityManager;
	}

	@Override
	public Optional<T> buscarPrimeiro() {
		var jpql = "from " + getDomainClass().getName(); // pegando a classe que estará atribuida para este repository (o T do generics).
		
		T entity = manager.createQuery(jpql, getDomainClass())
			.setMaxResults(1) //limitando o resultado a uma linha
			.getSingleResult();
		
		return Optional.ofNullable(entity);
	}

}