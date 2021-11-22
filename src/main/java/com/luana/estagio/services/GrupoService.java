package com.luana.estagio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luana.estagio.domain.Grupo;
import com.luana.estagio.repositories.GrupoRepository;

@Service
public class GrupoService {
	
	@Autowired
	private GrupoRepository repository;
	
//	public Grupo findByID(Integer id) {
//		Optional<Grupo> obj = repository.findById(id);
//		return obj.orElseThrow();
//	}
	
	public Grupo findByid(Integer id) {
		return repository.findByid(id);
	}
	
	public List<Grupo> findAll() {
		List<Grupo> list = repository.findAll();
		return list;
	}
	
	public Grupo create(Grupo obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	public Grupo update(Integer id, Grupo obj) {
		Grupo newObj = findByid(id);
		newObj.setNome(obj.getNome());
		newObj.setInstituicao(obj.getInstituicao());
		newObj.setSetor(obj.getSetor());
		newObj.setAlunos(obj.getAlunos());
		newObj.setEstagio(obj.getEstagio());
		return repository.save(newObj);
	}

}
