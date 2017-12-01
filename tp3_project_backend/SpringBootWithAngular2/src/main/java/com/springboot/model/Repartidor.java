package com.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "repartidor")
public class Repartidor {
	
	private Long idRepartidor;
	private String nombre;
	private String apellidos;
	private String estado;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRepartidor")
	public Long getIdRepartidor() {
		return idRepartidor;
	}
	public void setIdRepartidor(Long idRepartidor) {
		this.idRepartidor = idRepartidor;
	}
	
	@Column(name = "nombre")
	@Size(min=100, max=150)
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(name = "apellidos")
	@Size(min=100, max=150)
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	@Column(name = "estado")
	@Size(min=100, max=150)
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	

}
