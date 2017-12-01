package com.springboot.model;

import java.math.BigDecimal;
import java.util.Date;

public class PedidoProyectadoFilter {

	private String descripcionlocal;
	private Date fechainicio;
	private Date fechafinal;
	private Long idPedidoProyectado;
	private Date fecha;
	private String estado;
	private String descripcion;
	private Integer cantidad;
	private BigDecimal precio;
	private BigDecimal costo;
	private Long flat;
	private Long idlocal;
	private String color;
	
	public Long getIdPedidoProyectado() {
		return idPedidoProyectado;
	}

	public void setIdPedidoProyectado(Long idPedidoProyectado) {
		this.idPedidoProyectado = idPedidoProyectado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public BigDecimal getCosto() {
		return costo;
	}

	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}

	public Long getFlat() {
		return flat;
	}

	public void setFlat(Long flat) {
		this.flat = flat;
	}

	public Long getIdlocal() {
		return idlocal;
	}

	public void setIdlocal(Long idlocal) {
		this.idlocal = idlocal;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Date getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}

	public Date getFechafinal() {
		return fechafinal;
	}

	public void setFechafinal(Date fechafinal) {
		this.fechafinal = fechafinal;
	}

	public String getDescripcionlocal() {
		return descripcionlocal;
	}

	public void setDescripcionlocal(String descripcionlocal) {
		this.descripcionlocal = descripcionlocal;
	}
	
	
}
