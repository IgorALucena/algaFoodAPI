package com.algaworks.algafood.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean // para não instanciar um repository
public interface CustomJpaRepository<T, ID> extends JpaRepository<T, ID> { // ele permanece generíco pois aceitará o
																			// tipo e id de qualquer classe. Agora, ao
																			// invés de chamar o JpaRepository no
																			// Repository de cada classe, chamo o
																			// custom, que trará esse método e todos os
																			// demais pertencentes ao jpaRepository.
																			// Incluimos mais uma interface na
																			// hierarquia.

	/* Repository custom que pertencerá diretamente ao jpaRepository */

	Optional<T> buscarPrimeiro();

}