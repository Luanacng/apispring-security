package com.luana.estagio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luana.estagio.domain.Setor;

public interface SetorRepository extends JpaRepository<Setor, Integer> {

	Setor findByid(Integer id);
}
