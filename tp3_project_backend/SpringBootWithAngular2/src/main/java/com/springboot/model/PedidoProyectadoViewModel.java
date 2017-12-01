package com.springboot.model;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.springboot.json.JsonDateSimpleDeserializer;
import com.springboot.json.JsonDateSimpleSerializer;

public class PedidoProyectadoViewModel {
	
	private String descripcionlocal;
	private Long idPedidoProyectado;
	
	

	public Long getIdPedidoProyectado() {
		return idPedidoProyectado;
	}

	public void setIdPedidoProyectado(Long idPedidoProyectado) {
		this.idPedidoProyectado = idPedidoProyectado;
	}

	public String getDescripcionlocal() {
		return descripcionlocal;
	}

	public void setDescripcionlocal(String descripcionlocal) {
		this.descripcionlocal = descripcionlocal;
	}
	
	

}
