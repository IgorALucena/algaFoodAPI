package com.algaworks.algafood.infrastrucuture.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.FormaDePagamento;
import com.algaworks.algafood.domain.repository.FormaDePagamentoRepository;

@Repository
public class FormaDePagamentoRepositoryImpl implements FormaDePagamentoRepository {

	@PersistenceContext
	private EntityManager manager;
	
	
	@Override
	public List<FormaDePagamento> listar() {
		return manager.createQuery("from formaDePagamento", FormaDePagamento.class).getResultList();
	}

	@Override
	public FormaDePagamento salvar(FormaDePagamento formaDePagamento) {
		return manager.merge(formaDePagamento);
	}

	@Override
	public void remover(FormaDePagamento formaDePagamento) {
		manager.remove(formaDePagamento);
		
	}
	
	

}
