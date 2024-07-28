package com.algaworks.algafood.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Cozinha;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {

	// ASSINATURA MÉTODO JPQL IMPLEMENTADO NO IMPL
	// List<Cozinha> consultaPorNome(String nome);

	/*
	 * Caso eu queira relizar uma busca por uma propriedade específica, basta eu
	 * atribuir o nome da assinatura do método igual a propriedade pela qual eu
	 * quero buscar o registro no banco. Ou posso adicionar prefixos reconhecidos
	 * pelo spring, como findBy<nome_da_propriedade>. Find e by são prefixos e entre
	 * um e outro posso adicionar o que eu desejar. CONSULTAR: https://docs.spring.io/spring-data/jpa/docs/1.4.3.RELEASE/reference/html/repository-query-keywords.html
	 * 
	 * PREFIXOS: find, query, get, exists, count...
	 * FLAGS: First, Top2...
	 * KEYWORDS: containing...
	 * 
	 * ex: List<Cozinha> nome(String nome);
	 * 
	 * Isso fará com que a busca por queryparms busque a cozinha pelo nome
	 * informado. O spring fica responsável pela implementação do método.
	 * 
	 * IMPORTANTE: NÃO SERÁ TRATADO COMO LIKE, SERÁ TRATADO COM UMA CONSULTA EXATA,
	 * SENDO NECESSÁRIO REPASSAR O NOME COMPLETO NA QUERY PARA FUNCIONAR
	 * 
	 * EX DE CHAMADA:
	 * 
	 * @GetMapping("/cozinhas/por-nome") public List<Cozinha>
	 * cozinhasPorNome(@RequestParam("nome") String nome) { return
	 * cozinhaRepository.nome(nome); }
	 */

	// ASSINATURA DE MÉTODOS IMPLEMENTADOS PELO SPRING DATA
	List<Cozinha> findTodasByNome(String nome);
	
	//OBS: busca com LIKE. Containing é uma keyword que proporciona o percent
	List<Cozinha> findTodasByNomeContaining(String nome);
	
	Optional<Cozinha> findByNome(String nome);

}
