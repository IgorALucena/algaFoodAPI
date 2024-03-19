package com.algaworks.algafood.infrastrucuture.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.FormaDePagamento;
import com.algaworks.algafood.domain.repository.FormaDePagamentoRepository;

@Repository
public class FormaDePagamentoRepositoryImpl implements FormaDePagamentoRepository {

	@PersistenceContext
	private EntityManager manager;
	
	
	@Override
	public List<FormaDePagamento> listar() {
		return manager.createQuery("from FormaDePagamento", FormaDePagamento.class).getResultList();
	}

	@Transactional
	@Override
	public FormaDePagamento salvar(FormaDePagamento formaDePagamento) {
		return manager.merge(formaDePagamento);
	}

	@Transactional
	@Override
	public void remover(FormaDePagamento formaDePagamento) {
		FormaDePagamento busca = buscar(formaDePagamento.getId());
		manager.remove(busca);
		
	}

	@Override
	public FormaDePagamento buscar(Long id) {
		return manager.find(FormaDePagamento.class, id);
	}
	
	

}
