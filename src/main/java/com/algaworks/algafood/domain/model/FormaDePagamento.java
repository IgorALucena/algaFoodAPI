package com.algaworks.algafood.domain.model;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class FormaDePagamento {
	
	private String descricao;

}
