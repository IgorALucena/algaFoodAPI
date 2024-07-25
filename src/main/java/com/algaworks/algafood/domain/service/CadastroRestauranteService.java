package com.algaworks.algafood.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {
	
	@Autowired
	private RestauranteRepository cozinhaRepository;
	
	public List<Restaurante> listar(){
		List<Restaurante> restaurantes = cozinhaRepository.listar();
		return restaurantes;
	}
	
	public Restaurante buscar(Long id){
		Restaurante restaurante = cozinhaRepository.buscar(id);
		return restaurante;
	}

}
