package com.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "carta")
public class Carta {
	
	private String idCarta;
	private String nombreCarta;
	
	@Id
    @Column(name = "idCarta")
	@Length(max = 10)
	public String getIdCarta() {
		return idCarta;
	}
	public void setIdCarta(String idCarta) {
		this.idCarta = idCarta;
	}
	
	@Column(name = "nombreCarta")
	@Size(min=100, max=150)
	public String getNombreCarta() {
		return nombreCarta;
	}
	public void setNombreCarta(String nombreCarta) {
		this.nombreCarta = nombreCarta;
	}
}
