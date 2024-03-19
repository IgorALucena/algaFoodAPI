package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.FormaDePagamento;

public interface FormaDePagamentoRepository {
	
	List<FormaDePagamento> listar();
	FormaDePagamento salvar(FormaDePagamento formaDePagamento);
	void remover(FormaDePagamento formaDePagamento);

}
