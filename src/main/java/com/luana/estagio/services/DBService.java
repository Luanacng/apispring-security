package com.luana.estagio.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luana.estagio.domain.Aluno;
import com.luana.estagio.domain.Estagio;
import com.luana.estagio.domain.Grupo;
import com.luana.estagio.domain.Setor;
import com.luana.estagio.repositories.AlunoRepository;
import com.luana.estagio.repositories.EstagioRepository;
import com.luana.estagio.repositories.GrupoRepository;
import com.luana.estagio.repositories.SetorRepository;

@Service
public class DBService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private SetorRepository setorRepository;
	
	@Autowired
	private GrupoRepository grupoRepository;
	
	@Autowired
	private EstagioRepository estagioRepository;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public void instanciaBaseDeDados() throws ParseException {
		
		
		Aluno aluno1 = new Aluno(null,"Ana","1adfs232","Medicina",null);
		Aluno aluno2 =new Aluno(null,"Leticia","1dfsf232","Enfermagem",null);
		Aluno aluno3 = new Aluno(null,"Luana","1adfs232","Computação",null);
		Aluno aluno4 =new Aluno(null,"Julia","1dfsf232","Medicina",null);

		alunoRepository.saveAll(Arrays.asList(aluno1,aluno2,aluno3,aluno4));
		
		Setor setor1 = new Setor(null,"Setor x");
		Setor setor2 = new Setor(null,"Setor y");
		Setor setor3 = new Setor(null,"Setor z");
		setorRepository.saveAll(Arrays.asList(setor1,setor2,setor3));
		
		Estagio estagio = new Estagio(null,"Estagio 1", "Descricao", sdf.parse("25/03/2022"), sdf.parse("25/03/2022"),null,false);
		Estagio estagio2 = new Estagio(null,"Estagio 2", "Descricao", sdf.parse("25/03/2022"), sdf.parse("25/03/2022"),null,false);

		estagioRepository.saveAll(Arrays.asList(estagio,estagio2));
		
		Grupo grupo = new Grupo(null,"Grupo A","UEMA","setor 1");
		grupo.getAlunos().add(aluno1);
		grupo.getEstagio().add(estagio);
		
		Grupo grupo2 = new Grupo(null,"Grupo B","UFMA","setor 2");
		grupo2.getAlunos().add(aluno2);
		grupo2.getAlunos().add(aluno3);
		grupo2.getEstagio().add(estagio2);
		
		grupoRepository.saveAll(Arrays.asList(grupo,grupo2));
		
		
		
		
	
	}
	

}
