package com.algaworks.algafood.infrastrucuture.repository.spec;

import java.math.BigDecimal;

import org.springframework.data.jpa.domain.Specification;

import com.algaworks.algafood.domain.model.Restaurante;

public class RestauranteSpecs {

	/*
	 * Fábrica de Specifications Assim não preciso chamar manualmente como nas
	 * classes Restaurante com frete GratisSpec e nem restaurante com
	 * NomeSemelhanteSpec. A specification, por outro lado, permanece sendo
	 * responsabilidade de quem tá usando o repo e não do repo.
	 */

	public static Specification<Restaurante> comFreteGratis() {
		return (root, query, builder) -> builder.equal(root.get("taxaFrete"), BigDecimal.ZERO);
	}

	public static Specification<Restaurante> comNomeSemelhante(String nome) {
		return (root, query, builder) -> builder.like(root.get("nome"), "%" + nome + "%");
	}

}