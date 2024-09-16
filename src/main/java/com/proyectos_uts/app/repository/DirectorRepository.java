package com.proyectos_uts.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectos_uts.app.entity.DirectorEntity;



@Repository
public interface DirectorRepository extends JpaRepository<DirectorEntity, Long> {

	DirectorEntity findByCedulaAndContra(Long cedula, String contra);
}
