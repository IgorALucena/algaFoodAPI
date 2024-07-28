package com.algaworks.algafood.infrastrucuture.repository.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.algaworks.algafood.domain.model.Restaurante;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RestauranteComNomeSemelhanteSpec implements Specification<Restaurante> {
	
	/*criação de um predicate para o criteriaquery. Assim posso chamar predicados prontos sem a necessidade de criar na classe de repositoryImpl*/

	private static final long serialVersionUID = 1L;

	private String nome;
	
	@Override
	public Predicate toPredicate(Root<Restaurante> root, CriteriaQuery<?> query, 
			CriteriaBuilder builder) {
		
		return builder.like(root.get("nome"), "%" + nome + "%");
	}

}