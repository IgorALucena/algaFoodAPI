package com.algaworks.algafood.domain.model;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class Permissao {

	private String nome;
	private String descricao;
	
}
