package com.algaworks.algafood.infrastrucuture.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;

public class EstadoRepositoryImpl implements EstadoRepository {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Estado> listar() {
		return manager.createQuery("from estado", Estado.class).getResultList();
	}

	@Override
	public Estado salvar(Estado estado) {
		return manager.merge(estado);
	}

	@Override
	public Estado buscar(Long id) {
		return manager.find(Estado.class, id);
	}

	@Override
	public void remover(Estado estado) {
		manager.remove(estado);
		
	}

}
