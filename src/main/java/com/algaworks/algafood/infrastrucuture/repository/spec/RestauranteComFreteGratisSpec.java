package com.algaworks.algafood.infrastrucuture.repository.spec;

import java.math.BigDecimal;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.algaworks.algafood.domain.model.Restaurante;

public class RestauranteComFreteGratisSpec implements Specification<Restaurante> {
	
	/*criação de um predicate para o criteriaquery. Assim posso chamar predicados prontos sem a necessidade de criar na classe de repositoryImpl*/

	private static final long serialVersionUID = 1L;

	@Override
	public Predicate toPredicate(Root<Restaurante> root, CriteriaQuery<?> query, 
			CriteriaBuilder builder) {
		
		return builder.equal(root.get("taxaFrete"), BigDecimal.ZERO);
	}

}