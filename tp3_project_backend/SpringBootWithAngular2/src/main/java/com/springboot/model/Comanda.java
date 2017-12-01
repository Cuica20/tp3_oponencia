package com.springboot.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "comanda")
public class Comanda {

	private Long 		idComanda;
	private Date 		fecha;
	private Mesa 		mesa;
	private String 		numeroComensales;
	private String 		nombreCamarero;
	private String 		sugerencia;
	private List<DetalleCartaComanda> detalleCartaComanda;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idComanda")
	public Long getIdComanda() {
		return idComanda;
	}
	public void setIdComanda(Long idComanda) {
		this.idComanda = idComanda;
	}
	
	@Column(name = "fecha")
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	@ManyToOne()
    @JoinColumn(name = "idMesa")
	public Mesa getMesa() {
		return mesa;
	}
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	
	@Column(name = "numeroComensales")
	@Size(min=2, max=3)
	public String getNumeroComensales() {
		return numeroComensales;
	}
	public void setNumeroComensales(String numeroComensales) {
		this.numeroComensales = numeroComensales;
	}
	
	@Column(name = "nombreCamarero")
	@Size(min=100, max=150)
	public String getNombreCamarero() {
		return nombreCamarero;
	}
	public void setNombreCamarero(String nombreCamarero) {
		this.nombreCamarero = nombreCamarero;
	}
	
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REFRESH }, orphanRemoval = true, mappedBy = "comanda", fetch = FetchType.EAGER)
	@Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE,
			org.hibernate.annotations.CascadeType.MERGE, org.hibernate.annotations.CascadeType.PERSIST })
	public List<DetalleCartaComanda> getDetalleCartaComanda() {
		return detalleCartaComanda;
	}
	public void setDetalleCartaComanda(List<DetalleCartaComanda> detalleCartaComanda) {
		this.detalleCartaComanda = detalleCartaComanda;
	}
	
	@Column(name = "sugerencia")
	@Size(min=100, max=150)
	public String getSugerencia() {
		return sugerencia;
	}
	public void setSugerencia(String sugerencia) {
		this.sugerencia = sugerencia;
	}
	
	
	
}
