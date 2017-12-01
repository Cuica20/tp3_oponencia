package com.springboot.dto;


public class ComandaDTO {
	
	private Long 		id_comanda;
	private Long 		cod_mesa;
	private String 		nombre_camarero;
	private String 		id_carta;
	private String		sugerencia_promocionpago;
	
	public Long getId_comanda() {
		return id_comanda;
	}
	public void setId_comanda(Long id_comanda) {
		this.id_comanda = id_comanda;
	}
	public Long getCod_mesa() {
		return cod_mesa;
	}
	public void setCod_mesa(Long cod_mesa) {
		this.cod_mesa = cod_mesa;
	}
	public String getNombre_camarero() {
		return nombre_camarero;
	}
	public void setNombre_camarero(String nombre_camarero) {
		this.nombre_camarero = nombre_camarero;
	}
	public String getId_carta() {
		return id_carta;
	}
	public void setId_carta(String id_carta) {
		this.id_carta = id_carta;
	}
	public String getSugerencia_promocionpago() {
		return sugerencia_promocionpago;
	}
	public void setSugerencia_promocionpago(String sugerencia_promocionpago) {
		this.sugerencia_promocionpago = sugerencia_promocionpago;
	}
	
	

}
