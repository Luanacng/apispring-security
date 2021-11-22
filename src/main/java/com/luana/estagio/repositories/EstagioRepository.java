package com.luana.estagio.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.luana.estagio.domain.Estagio;

@Repository
public interface EstagioRepository extends JpaRepository<Estagio, Integer> {

	@Query("SELECT obj FROM Estagio obj WHERE obj.finalizado = false ORDER BY obj.fim")
	List<Estagio> findAllOpen();

	@Query("SELECT obj FROM Estagio obj WHERE obj.finalizado = true ORDER BY obj.fim")
	List<Estagio> findAllClosed();
	
	Estagio findByid(Integer id);
}
