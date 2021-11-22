package com.luana.estagio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luana.estagio.domain.Grupo;

public interface GrupoRepository extends JpaRepository<Grupo, Integer> {

	Grupo findByid(Integer id);
}
