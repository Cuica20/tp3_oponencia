package com.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cliente")
public class Cliente {

	private Long 	dni;
	private String 	nombre;
	private String 	apPaterno;
	private String 	apMaterno;
	private String 	telefono;
	private String 	correo;

	@Id
	@Column(name = "dni")
	public Long getDni() {
		return dni;
	}
	public void setDni(Long dni) {
		this.dni = dni;
	}

	@Column(name = "nombre")
	@Size(min=100, max=150)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "apPaterno")
	@Size(min=100, max=100)
	public String getApPaterno() {
		return apPaterno;
	}
	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}

	@Column(name = "apMaterno")
	@Size(min=100, max=100)
	public String getApMaterno() {
		return apMaterno;
	}
	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}

	@Column(name = "telefono")
	@Size(min=9, max=12)
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Column(name = "correo")
	@Size(min=100, max=150)
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

}
