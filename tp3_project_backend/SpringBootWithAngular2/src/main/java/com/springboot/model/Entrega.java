package com.springboot.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "entrega")
public class Entrega {
	
	private Long idEntrega;
	private String latitud;
	private String longitud;
	private Long dni;
	private String estado;
	private Date fecha;
	private Date horaEstimada;
	private String idCarta;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEntrega")
	public Long getIdEntrega() {
		return idEntrega;
	}
	public void setIdEntrega(Long idEntrega) {
		this.idEntrega = idEntrega;
	}
	
	@Column(name = "latitud")
	@Size(min=100, max=150)
	public String getLatitud() {
		return latitud;
	}
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}
	
	@Column(name = "longitud")
	@Size(min=100, max=150)
	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	
	@Column(name = "dni")
	public Long getDni() {
		return dni;
	}
	public void setDni(Long dni) {
		this.dni = dni;
	}
	
	@Column(name = "estado")
	@Size(min=40, max=50)
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	@Column(name = "fecha")
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	@Column(name = "horaEstimada")
	public Date getHoraEstimada() {
		return horaEstimada;
	}
	public void setHoraEstimada(Date horaEstimada) {
		this.horaEstimada = horaEstimada;
	}
	
	@Column(name = "idCarta")
	@Size(min=20, max=25)
	public String getIdCarta() {
		return idCarta;
	}
	public void setIdCarta(String idCarta) {
		this.idCarta = idCarta;
	}
	
	

}
