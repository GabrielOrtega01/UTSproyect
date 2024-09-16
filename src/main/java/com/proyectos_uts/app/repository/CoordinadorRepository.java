package com.proyectos_uts.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectos_uts.app.entity.CoordinadorEntity;



@Repository
public interface CoordinadorRepository extends JpaRepository<CoordinadorEntity, Long>{

	CoordinadorEntity findByCedulaAndContra(Long cedula, String contra);
}
