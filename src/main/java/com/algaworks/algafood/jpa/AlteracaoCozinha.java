/* EXEMPLO DE UTILIZAÇÃO JPA PURO
 * package com.algaworks.algafood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

public class AlteracaoCozinha {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class).web(WebApplicationType.NONE).run(args);

		CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);
		
		Cozinha cozinha1 = new Cozinha();
		
		cozinha1.setNome("brasileira");
		cozinha1.setId(1L);
		
		cozinha1 = cozinhaRepository.salvar(cozinha1);
		
		System.out.println(cozinha1.getNome() + " " + cozinha1.getId());
		
	}

}*/
