package com.proyectos_uts.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "proyectos")
public class ProyectoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String anteproyecto;

	private String descripcion;

	private String estadoDirector;

	private String radicadoAnteproyecto;

	private String estadoEvaluador;

	private String estadoFinal;

	private String radicadoComite;

	private String calificacion;

	@JoinColumn(name = "director_id")
	@ManyToOne
	private DirectorEntity director;

	@JoinColumn(name = "evaluador_id")
	@ManyToOne
	private EvaluadorEntity evaluador;

	@JoinColumn(name = "estudiante_id")
	@ManyToOne
	private EstudianteEntity estudiante;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnteproyecto() {
		return anteproyecto;
	}

	public void setAnteproyecto(String anteproyecto) {
		this.anteproyecto = anteproyecto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstadoDirector() {
		return estadoDirector;
	}

	public void setEstadoDirector(String estadoDirector) {
		this.estadoDirector = estadoDirector;
	}

	public String getRadicadoAnteproyecto() {
		return radicadoAnteproyecto;
	}

	public void setRadicadoAnteproyecto(String radicadoAnteproyecto) {
		this.radicadoAnteproyecto = radicadoAnteproyecto;
	}

	public String getEstadoEvaluador() {
		return estadoEvaluador;
	}

	public void setEstadoEvaluador(String estadoEvaluador) {
		this.estadoEvaluador = estadoEvaluador;
	}

	public String getEstadoFinal() {
		return estadoFinal;
	}

	public void setEstadoFinal(String estadoFinal) {
		this.estadoFinal = estadoFinal;
	}

	public String getRadicadoComite() {
		return radicadoComite;
	}

	public void setRadicadoComite(String radicadoComite) {
		this.radicadoComite = radicadoComite;
	}

	public String getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}

	public DirectorEntity getDirector() {
		return director;
	}

	public void setDirector(DirectorEntity director) {
		this.director = director;
	}

	public EvaluadorEntity getEvaluador() {
		return evaluador;
	}

	public void setEvaluador(EvaluadorEntity evaluador) {
		this.evaluador = evaluador;
	}

	public EstudianteEntity getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(EstudianteEntity estudiante) {
		this.estudiante = estudiante;
	}
}
