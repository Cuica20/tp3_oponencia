package com.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "local")
public class Local {
	
	private Long idLocal;
	private String descripcion;
	private String direccion;
	private String ubicacion;
	private String telefono;
	private Integer aforo;
	
	@Id
    @Column(name = "idLocal")
	public Long getIdLocal() {
		return idLocal;
	}
	public void setIdLocal(Long idLocal) {
		this.idLocal = idLocal;
	}
	
	@Column(name = "descripcion")
	@Size(min=100, max=150)
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Column(name = "ubicacion")
	@Size(min=100, max=150)
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	@Column(name = "telefono")
	@Size(min=9, max=12)
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	@Column(name = "aforo")
	@Digits(fraction = 0, integer = 3)
	public Integer getAforo() {
		return aforo;
	}
	public void setAforo(Integer aforo) {
		this.aforo = aforo;
	}
	
	@Column(name = "direccion")
	@Size(min=100, max=150)
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
