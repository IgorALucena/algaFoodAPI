package com.algaworks.algafood.infrastrucuture.repository;

import static com.algaworks.algafood.infrastrucuture.repository.spec.RestauranteSpecs.comFreteGratis;
import static com.algaworks.algafood.infrastrucuture.repository.spec.RestauranteSpecs.comNomeSemelhante;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepositoryQuerys;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQuerys {

	/* QUERYS COM CRITERIA */

	@PersistenceContext
	private EntityManager manager;

	@Lazy // tag para evitar dependência circular.
	@Autowired
	private RestauranteRepository restauranteRepository;

	@Override
	public List<Restaurante> findCustom(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {
		var builder = manager.getCriteriaBuilder(); // retorna uma instancia do Criteria builder

		var criteria = builder.createQuery(Restaurante.class); // O criteriaQuery precisa do Criteria builder
		var root = criteria.from(Restaurante.class); // até basicamente eu criei uma jpql "from Restaurante"

		var predicates = new ArrayList<Predicate>();

		if (StringUtils.hasText(nome)) {
			predicates.add(builder.like(root.get("nome"), "%" + nome + "%")); // adicionando na lista o nome caso tenha
																				// sido passado, pegando o atributo da
																				// classe restaurante que será comparado
																				// com o parametro passado. Os demais
																				// seguem a mesma ideia.
		}

		if (taxaFreteInicial != null) {
			predicates.add(builder.greaterThanOrEqualTo(root.get("taxaFrete"), taxaFreteInicial));
		}

		if (taxaFreteFinal != null) {
			predicates.add(builder.lessThanOrEqualTo(root.get("taxaFrete"), taxaFreteFinal));
		}

		criteria.where(predicates.toArray(new Predicate[0]));// O criteria recebe sempre um array de predicate, sendo
																// neceessário a instanciação em questão.

		var query = manager.createQuery(criteria);
		return query.getResultList();
	}

	@Override
	public List<Restaurante> findComFreteGratis(String nome) {
		return restauranteRepository.findAll(comFreteGratis().and(comNomeSemelhante(nome)));// fazendo o nosso método
																							// personalizado com os
																							// predicate. Ele agora
																							// depende do repository e
																							// não mais de quem utiliza
																							// o repository para colocar
																							// os predicate
	}

}

/*
 * SOBRE PREDICADOS NO CRITERIAAPI: Predicate nomePredicate =
 * builder.like(root.get("nome"), "%" + nome + "%");
 * 
 * Predicate taxaInicialPredicate = builder
 * .greaterThanOrEqualTo(root.get("taxaFrete"), taxaFreteInicial);
 * 
 * Predicate taxaFinalPredicate = builder
 * .lessThanOrEqualTo(root.get("taxaFrete"), taxaFreteFinal);
 * 
 * criteria.where(nomePredicate, taxaInicialPredicate, taxaFinalPredicate);
 * 
 * obs: O TIPO É PREDICADE E EU POSSO ATRIBUIR DA MANEIRA ACIMA, DESDE QUE NÃO
 * SEJA NECESSÁRIO DINAMICIDADE. SE NÃO, POSSO FAZER COMO ABAIXO:
 */