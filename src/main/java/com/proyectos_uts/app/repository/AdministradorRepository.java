package com.proyectos_uts.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectos_uts.app.entity.AdministradorEntity;



@Repository
public interface AdministradorRepository extends JpaRepository<AdministradorEntity, Long>{

	AdministradorEntity findByUsuarioAndContra(String usuario, String contra);
}
