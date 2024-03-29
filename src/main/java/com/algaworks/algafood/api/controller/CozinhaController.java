package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.api.model.CozinhasXmlWrapper;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

@RestController
@RequestMapping(value = "/cozinhas")
public class CozinhaController {
	
	@Autowired
	
	private CozinhaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Cozinha>> listar(){//coleção de recursos
		List<Cozinha> cozinhas = repository.listar();
		
		return ResponseEntity.status(HttpStatus.OK).body(cozinhas);
		
	}
	
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public CozinhasXmlWrapper listarXml(){
		return new CozinhasXmlWrapper(repository.listar());
		
	}
	
	@GetMapping(value = "/{cozinhaId}")// recurso singleton
	public Cozinha buscar(@PathVariable("cozinhaId") Long id) {
		return repository.buscar(id);
	}

}
