package com.algaworks.algafood.infrastrucuture.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;

@Repository
public class CidadeRepositoryImpl implements CidadeRepository {

	@PersistenceContext
	private EntityManager manager;
	
	
	@Override
	public List<Cidade> listar(){
		return manager.createQuery("from Cidade", Cidade.class).getResultList();
	}
	
	@Transactional
	@Override
	public Cidade salvar(Cidade cidade) {
		return manager.merge(cidade);
		
	}
	
	@Override
	public Cidade buscar(Long id){
		return manager.find(Cidade.class, id);
	}
	
	@Transactional
	@Override
	public void remover(Cidade cidade) {
		Cidade busca = buscar(cidade.getId());
		manager.remove(busca);
	}

}
