package com.springboot.model;

public class LocalViewModel {

	private Long cod_local;
	private String nombre_local;
	private String ubicacion;
	private String telefono;
	private Long aforo;
	public Long getCod_local() {
		return cod_local;
	}
	public void setCod_local(Long cod_local) {
		this.cod_local = cod_local;
	}
	public String getNombre_local() {
		return nombre_local;
	}
	public void setNombre_local(String nombre_local) {
		this.nombre_local = nombre_local;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Long getAforo() {
		return aforo;
	}
	public void setAforo(Long aforo) {
		this.aforo = aforo;
	}
	
	
}
