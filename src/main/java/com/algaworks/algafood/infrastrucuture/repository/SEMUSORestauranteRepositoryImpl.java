/*package com.algaworks.algafood.infrastrucuture.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@Repository 
public class RestauranteRepositoryImpl implements RestauranteRepository {

	@PersistenceContext
	private EntityManager manager;
	
	
	@Override
	public List<Restaurante> listar(){
		return manager.createQuery("from Restaurante", Restaurante.class).getResultList();
	}
	
	@Transactional
	@Override
	public Restaurante salvar(Restaurante restaurante) {
		return manager.merge(restaurante);
		
	}
	
	@Override
	public Restaurante buscar(Long id){
		return manager.find(Restaurante.class, id);
	}
	
	@Transactional
	@Override
	public void remover(Restaurante restaurante) {
		Restaurante busca = buscar(restaurante.getId());
		manager.remove(busca);
	}


}*/








