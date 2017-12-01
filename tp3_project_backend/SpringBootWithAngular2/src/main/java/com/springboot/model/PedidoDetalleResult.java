package com.springboot.model;

public class PedidoDetalleResult {

	private Long id_pedidetalle;
	private Long id_pedido;
	private String cod_carta;
	
	public Long getId_pedidetalle() {
		return id_pedidetalle;
	}
	public void setId_pedidetalle(Long id_pedidetalle) {
		this.id_pedidetalle = id_pedidetalle;
	}
	public Long getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(Long id_pedido) {
		this.id_pedido = id_pedido;
	}
	public String getCod_carta() {
		return cod_carta;
	}
	public void setCod_carta(String cod_carta) {
		this.cod_carta = cod_carta;
	}
	
	
}
