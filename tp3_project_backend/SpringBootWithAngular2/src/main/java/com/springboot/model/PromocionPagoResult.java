package com.springboot.model;

public class PromocionPagoResult {
	
	private Long id_promocionpago;
	private String estado_promocionpago;
	private String mesa_promocionpago;
	private String detalle_promocion;
	private String platos_promocion;
	
	public Long getId_promocionpago() {
		return id_promocionpago;
	}
	public void setId_promocionpago(Long id_promocionpago) {
		this.id_promocionpago = id_promocionpago;
	}
	public String getEstado_promocionpago() {
		return estado_promocionpago;
	}
	public void setEstado_promocionpago(String estado_promocionpago) {
		this.estado_promocionpago = estado_promocionpago;
	}
	public String getMesa_promocionpago() {
		return mesa_promocionpago;
	}
	public void setMesa_promocionpago(String mesa_promocionpago) {
		this.mesa_promocionpago = mesa_promocionpago;
	}
	public String getDetalle_promocion() {
		return detalle_promocion;
	}
	public void setDetalle_promocion(String detalle_promocion) {
		this.detalle_promocion = detalle_promocion;
	}
	public String getPlatos_promocion() {
		return platos_promocion;
	}
	public void setPlatos_promocion(String platos_promocion) {
		this.platos_promocion = platos_promocion;
	}
	
	
	

}
