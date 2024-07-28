package com.algaworks.algafood.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import com.algaworks.algafood.domain.model.Restaurante;

public interface RestauranteRepositoryQuerys {
	/*
	 * REPOSITORY QUE DEVERÁ REUNIR IMPLEMENTAÇÕES CUSTOMIZADAS PARA RESTAURANTE.
	 * METODOS ESTÃO IMPLEMENTADOS NO PACOTE DE INFRA REPO. INTERFAZER SERÁ
	 * IMPLEMENTADA NO REPOSITORY OFICIAL JUNTAMENTE COM O JPAREPOSITORY
	 */
	
	List<Restaurante> findCustom(String nome, 
			BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);
	
	List<Restaurante> findComFreteGratis(String nome);

}