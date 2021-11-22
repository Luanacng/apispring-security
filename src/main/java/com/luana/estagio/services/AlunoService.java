package com.luana.estagio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luana.estagio.domain.Aluno;
import com.luana.estagio.repositories.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository repository;
	
	public Aluno findByid(Integer id) {
		return repository.findByid(id);
	}
	
//	public Aluno findByID(Integer id) {
//		Optional<Aluno> obj = repository.findById(id);
//		return obj.orElseThrow();
//	}
	
	public List<Aluno> findAll() {
		List<Aluno> list = repository.findAll();
		return list;
	}

	public Aluno create(Aluno obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	public Aluno update(Integer id, Aluno obj) {
		Aluno newObj = findByid(id);
		newObj.setNome(obj.getNome());
		newObj.setMatricula(obj.getMatricula());
		newObj.setCurso(obj.getCurso());
		newObj.setGrupo(obj.getGrupo());
		return repository.save(newObj);
		
	}
}
