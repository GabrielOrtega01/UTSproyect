package com.proyectos_uts.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudiantes")
public class EstudianteEntity {

	@Id
	private Long cedula;

	private String nombre;

	private String apellido;

	private String contra;

	private String telefono;

	private String carreraEstudiando;

	public Long getCedula() {
		return this.cedula;
	}

	public void setCedula(Long cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCarreraEstudiando() {
		return carreraEstudiando;
	}

	public void setCarreraEstudiando(String carreraEstudiando) {
		this.carreraEstudiando = carreraEstudiando;
	}
}
