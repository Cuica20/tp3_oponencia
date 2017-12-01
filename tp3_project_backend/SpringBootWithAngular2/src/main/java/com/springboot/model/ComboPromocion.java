package com.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "combopromocion")
public class ComboPromocion {
	
	private Long idComboPromocion;
	private String parametroUno;
	private String parametroDos;
	private String parametroTres;
	private Promocion promocion;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idComboPromocion")
	public Long getIdComboPromocion() {
		return idComboPromocion;
	}
	public void setIdComboPromocion(Long idComboPromocion) {
		this.idComboPromocion = idComboPromocion;
	}
	
	@ManyToOne()
    @JoinColumn(name = "idPromocion")
	public Promocion getPromocion() {
		return promocion;
	}
	public void setPromocion(Promocion promocion) {
		this.promocion = promocion;
	}
	
	@Column(name = "parametroUno")
	@Size(min=100, max=150)
	public String getParametroUno() {
		return parametroUno;
	}
	public void setParametroUno(String parametroUno) {
		this.parametroUno = parametroUno;
	}
	
	@Column(name = "parametroDos")
	@Size(min=100, max=150)
	public String getParametroDos() {
		return parametroDos;
	}
	public void setParametroDos(String parametroDos) {
		this.parametroDos = parametroDos;
	}
	
	@Column(name = "parametroTres")
	@Size(min=100, max=150)
	public String getParametroTres() {
		return parametroTres;
	}
	public void setParametroTres(String parametroTres) {
		this.parametroTres = parametroTres;
	}
	
}
