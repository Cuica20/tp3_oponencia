package com.springboot.model;

public class PedidoProyectadoResult {
	
	private String idPedidoProyectado;
	private String fecha;
	private String estado;
	private String nombre;
	private String descripcion;
	private String descripcionLocal;
	private Long cantidad;
	private Long precio;
	private Long costo;
	private String color;
	
	public String getIdPedidoProyectado() {
		return idPedidoProyectado;
	}
	public void setIdPedidoProyectado(String idPedidoProyectado) {
		this.idPedidoProyectado = idPedidoProyectado;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	
	public Long getCantidad() {
		return cantidad;
	}
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	public Long getPrecio() {
		return precio;
	}
	public void setPrecio(Long precio) {
		this.precio = precio;
	}
	public Long getCosto() {
		return costo;
	}
	public void setCosto(Long costo) {
		this.costo = costo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDescripcionLocal() {
		return descripcionLocal;
	}
	public void setDescripcionLocal(String descripcionLocal) {
		this.descripcionLocal = descripcionLocal;
	}
	
	

}
