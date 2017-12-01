package com.springboot.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "promocion")
public class Promocion {

	private Long idPromocion;
	private String descripcion;
	private BigDecimal precio;
	private List<ComboPromocion> combo;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPromocion")
	public Long getIdPromocion() {
		return idPromocion;
	}
	public void setIdPromocion(Long idPromocion) {
		this.idPromocion = idPromocion;
	}
	
	@Column(name = "descripcion")
	@Size(min=100, max=150)
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Column(name = "precio")
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REFRESH }, orphanRemoval = true, mappedBy = "idComboPromocion", fetch = FetchType.EAGER)
	@Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE,
			org.hibernate.annotations.CascadeType.MERGE, org.hibernate.annotations.CascadeType.PERSIST })
	public List<ComboPromocion> getCombo() {
		return combo;
	}
	public void setCombo(List<ComboPromocion> combo) {
		this.combo = combo;
	}
	
	
}
