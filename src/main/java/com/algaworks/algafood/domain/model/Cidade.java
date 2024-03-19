package com.algaworks.algafood.domain.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Cidade {
	
	private String nome;
	
	@ManyToOne
	private Estado estado;

}
