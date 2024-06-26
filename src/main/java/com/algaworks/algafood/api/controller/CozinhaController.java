package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
		
		return ResponseEntity.ok(cozinhas);
		
	}
	
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public CozinhasXmlWrapper listarXml(){
		return new CozinhasXmlWrapper(repository.listar());
		
	}
	
	@GetMapping(value = "/{cozinhaId}")// recurso singleton
	public ResponseEntity<Cozinha> buscar(@PathVariable("cozinhaId") Long id) {
		Cozinha cozinha = repository.buscar(id);
		
		if(id != null) {
			return ResponseEntity.ok(cozinha);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cozinha adicionar(@RequestBody Cozinha cozinha) {
		return repository.salvar(cozinha);
			
	}
	
	@PutMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> atualizar(@PathVariable Long cozinhaId, @RequestBody Cozinha cozinha) {
		
		Cozinha cozinhaAtual = repository.buscar(cozinhaId);
		if(cozinhaAtual != null) {
			
			BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");
			
			repository.salvar(cozinhaAtual);
			return ResponseEntity.ok(cozinhaAtual);
			
		}
		return ResponseEntity.notFound().build();
			
	}

}
