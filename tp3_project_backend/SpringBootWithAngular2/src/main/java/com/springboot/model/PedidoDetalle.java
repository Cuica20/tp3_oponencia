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
@Table(name = "pedidodetalle")
public class PedidoDetalle {
	
	private Long idPedidoDetalle;
	private Pedido pedido;
	private String idCarta;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPedidoDetalle")
	public Long getIdPedidoDetalle() {
		return idPedidoDetalle;
	}
	public void setIdPedidoDetalle(Long idPedidoDetalle) {
		this.idPedidoDetalle = idPedidoDetalle;
	}
	
	@ManyToOne()
    @JoinColumn(name = "idPedido")
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	@Column(name = "idCarta")
	@Size(min=10, max=20)
	public String getIdCarta() {
		return idCarta;
	}
	public void setIdCarta(String idCarta) {
		this.idCarta = idCarta;
	}

	
	

}
