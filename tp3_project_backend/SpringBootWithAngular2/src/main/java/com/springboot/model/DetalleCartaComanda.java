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

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "detallecartacomanda")
public class DetalleCartaComanda {
	
	private Long idDetalleCartaComanda;
	private Comanda comanda;
	private Carta carta;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDetalleCartaComanda")
	public Long getIdDetalleCartaComanda() {
		return idDetalleCartaComanda;
	}
	public void setIdDetalleCartaComanda(Long idDetalleCartaComanda) {
		this.idDetalleCartaComanda = idDetalleCartaComanda;
	}
	
	@ManyToOne()
	@JoinColumn(name = "idCarta")
	public Carta getCarta() {
		return carta;
	}
	public void setCarta(Carta carta) {
		this.carta = carta;
	}
	
	@ManyToOne()
    @JoinColumn(name = "idComanda")
	public Comanda getComanda() {
		return comanda;
	}
	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}

}
