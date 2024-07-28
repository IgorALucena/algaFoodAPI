package com.algaworks.algafood.api.controller;
 
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static com.algaworks.algafood.infrastrucuture.repository.spec.RestauranteSpecs.comFreteGratis;
import static com.algaworks.algafood.infrastrucuture.repository.spec.RestauranteSpecs.comNomeSemelhante;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@RestController
@RequestMapping("/teste")
public class TesteController {

	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	//CONSULTA POR JPQL SEM SPRING DATA
	/*
	@GetMapping("/cozinhas/por-nome")
	public List<Cozinha> cozinhasPorNome(@RequestParam("nome") String nome) {
		return cozinhaRepository.consultaPorNome(nome);
	}*/
	
	//CONSULTA COM SPRING DATA
	@GetMapping("/cozinhas/por-nome")
	public List<Cozinha> cozinhasPorNome(@RequestParam("nome") String nome) {
		return cozinhaRepository.findTodasByNome(nome);
	}
	
	@GetMapping("/cozinhas/unica-por-nome-exata")
	public Optional<Cozinha> cozinhaPorNomeExata(String nome) {
		return cozinhaRepository.findByNome(nome);
	}
	
	@GetMapping("/cozinhas/unica-por-nome-like")
	public List<Cozinha> cozinhaPorNomeLike(String nome) {
		return cozinhaRepository.findTodasByNomeContaining(nome);
	}
	
	@GetMapping("/restaurantes/por-taxa-frete")
	public List<Restaurante> restaurantesPorTaxaFrete(
			BigDecimal taxaInicial, BigDecimal taxaFinal) {
		return restauranteRepository.findByTaxaFreteBetween(taxaInicial, taxaFinal);
	}
	
	@GetMapping("/restaurantes/por-nome")
	public List<Restaurante> restaurantesPorTaxaFrete(
			String nome, Long cozinhaId) {
		return restauranteRepository.findByNomeContainingAndCozinhaId(nome, cozinhaId);
	}
	

	@GetMapping("/restaurantes/com-frete-gratis")
	public List<Restaurante> restaurantesComFreteGratis(String nome) {//UTILIZANDO AS SPECIFICATIONS GERADAS NA FACTORY DE RESTAURANTESPECS
		
		return restauranteRepository.findComFreteGratis(nome); // aqui os predicados dependem do próprio repository
		
		//return restauranteRepository.findAll(comFreteGratis() // aqui os predicados dependem de quem utiliza o respository
				//.and(comNomeSemelhante(nome)));
	}
	@GetMapping("/restaurantes/primeiro")
	public Optional<Restaurante> restaurantePrimeiro() {
		return restauranteRepository.buscarPrimeiro();
	}
	
	/*UTILIZANDO AS ESPECIFICATIONS CRIADOS ATRAVÉS DA INSTANCIAÇÃO
	 * @GetMapping("/restaurantes/com-frete-gratis")
	public List<Restaurante> restaurantesComFreteGratis(String nome) {
		var comFreteGratis = new RestauranteComFreteGratisSpec();
		var comNomeSemelhante = new RestauranteComNomeSemelhanteSpec(nome);
		
		return restauranteRepository.findAll(comFreteGratis.and(comNomeSemelhante)); // utilização dos specification
	}*/
	
	
}