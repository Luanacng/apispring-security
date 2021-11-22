package com.luana.estagio.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luana.estagio.domain.Estagio;
import com.luana.estagio.repositories.EstagioRepository;

@Service
public class EstagioService {
	
	@Autowired
	private EstagioRepository repository;

//	public Estagio findByID(Integer id) {
//		Optional<Estagio> obj = repository.findById(id);
//		return obj.orElseThrow();
//	}
	
	public Estagio findByid(Integer id) {
		return repository.findByid(id);
	}
	
	public List<Estagio> findAllOpen() {
		List<Estagio> list = repository.findAllOpen();
		return list;
	}

	public List<Estagio> findAllClosed() {
		List<Estagio> list = repository.findAllClosed();
		return list;
	}
	
	public List<Estagio> findAll() {
		List<Estagio> list = repository.findAll();
		return list;
	}

	public Estagio create(Estagio obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	public Estagio update(Integer id, Estagio obj) {
		Estagio newObj = findByid(id);
		newObj.setNome(obj.getNome());
		newObj.setDescricao(obj.getDescricao());
		newObj.setInicio(obj.getInicio());
		newObj.setFim(obj.getFim());
		newObj.setGrupo(obj.getGrupo());
		newObj.setFinalizado(obj.getFinalizado());
		return repository.save(newObj);
		
	}
	
}
