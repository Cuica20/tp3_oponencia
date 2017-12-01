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
@Table(name = "detallemesapromocionpago")
public class DetalleMesaPromocionpago {
	
	private Long idDetalleMesaPromocionPago;
	private Mesa mesa;
	private PromocionPago promocionPago;
	
	@Id
    @Column(name = "idDetalleMesaPromocionPago")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getIdDetalleMesaPromocionPago() {
		return idDetalleMesaPromocionPago;
	}
	public void setIdDetalleMesaPromocionPago(Long idDetalleMesaPromocionPago) {
		this.idDetalleMesaPromocionPago = idDetalleMesaPromocionPago;
	}
	
	@ManyToOne()
	@JoinColumn(name = "idMesa")
	public Mesa getMesa() {
		return mesa;
	}
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	
	@ManyToOne()
	@JoinColumn(name = "idPromocionPago")
	public PromocionPago getPromocionPago() {
		return promocionPago;
	}
	public void setPromocionPago(PromocionPago promocionPago) {
		this.promocionPago = promocionPago;
	}
	

}
