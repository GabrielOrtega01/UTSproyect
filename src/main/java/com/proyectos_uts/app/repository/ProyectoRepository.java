package com.proyectos_uts.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.proyectos_uts.app.entity.AdministradorEntity;
import com.proyectos_uts.app.entity.DirectorEntity;
import com.proyectos_uts.app.entity.EstudianteEntity;
import com.proyectos_uts.app.entity.EvaluadorEntity;
import com.proyectos_uts.app.entity.ProyectoEntity;



@Repository
public interface ProyectoRepository extends JpaRepository<ProyectoEntity, Long>{

	List<ProyectoEntity> findByEstudiante(EstudianteEntity estudiante);

	List<ProyectoEntity> findByDirector(DirectorEntity director);

	List<ProyectoEntity> findByEvaluador(EvaluadorEntity evaluador);
	
	@Query("SELECT p FROM ProyectoEntity p JOIN FETCH p.director d JOIN FETCH p.evaluador e JOIN FETCH p.estudiante s")
	List<ProyectoEntity> findAllProyectosConRelaciones();

}
