package com.luana.estagio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luana.estagio.domain.Setor;
import com.luana.estagio.repositories.SetorRepository;

@Service
public class SetorService {

	@Autowired
	private SetorRepository repository;
	
//	public Setor findByID(Integer id) {
//		Optional<Setor> obj = repository.findById(id);
//		return obj.orElseThrow();
//	}
	
	public Setor findByid(Integer id) {
		return repository.findByid(id);
	}
	
	public List<Setor> findAll() {
		List<Setor> list = repository.findAll();
		return list;
	}
	
	public Setor create(Setor obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	public Setor update(Integer id, Setor obj) {
		Setor newObj = findByid(id);
		newObj.setNome(obj.getNome());
		return repository.save(newObj);
	}
}
