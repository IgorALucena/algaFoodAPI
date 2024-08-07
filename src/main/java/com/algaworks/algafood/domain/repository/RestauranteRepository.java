package com.algaworks.algafood.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Restaurante;

@Repository
public interface RestauranteRepository
		extends CustomJpaRepository<Restaurante, Long>, RestauranteRepositoryQuerys, JpaSpecificationExecutor<Restaurante> { // para utilizar as especifications, precisamos do JpaSpecificationExecutor

	List<Restaurante> findByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);

	List<Restaurante> findByNomeContainingAndCozinhaId(String nome, Long cozinha);

	// @Query("from Restaurante where nome like %:nome% and cozinha.id = :id") //
	// query externalizada no META-INF em xml
	List<Restaurante> consultarPorNome(String nome, @Param("id") Long cozinha);

}