package com.algaworks.algafood.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Cozinha;

@Component
public class CadastroCozinhaMain {
	
	@PersistenceContext
	private EntityManager manager;
	
	public List<Cozinha> listar(){
		return manager.createQuery("from Cozinha", Cozinha.class).getResultList();
	}
	
	@Transactional
	public Cozinha adicionar(Cozinha cozinha) {
		return manager.merge(cozinha);
		
	}
	
	public Cozinha buscaPorId(Long id){
		return manager.find(Cozinha.class, id);
	}
	
	@Transactional
	public void exluir(Cozinha cozinha) {
		Cozinha busca = buscaPorId(cozinha.getId());
		manager.remove(busca);
	}

}