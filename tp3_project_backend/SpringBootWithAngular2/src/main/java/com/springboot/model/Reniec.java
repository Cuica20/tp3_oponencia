package com.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "reniec")
public class Reniec {
	

	private Long reniecDni;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String direccion;
    
    @Id
    @Column(name = "reniecDni")
    public Long getReniecDni() {
		return reniecDni;
	}
	public void setReniecDni(Long reniecDni) {
		this.reniecDni = reniecDni;
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
	@Size(min=100, max=150)
	public String getApPaterno() {
		return apPaterno;
	}
	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}
	
	@Column(name = "apMaterno")
	@Size(min=100, max=150)
	public String getApMaterno() {
		return apMaterno;
	}
	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
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
