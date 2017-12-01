package com.springboot.model;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.springboot.json.JsonDateSimpleDeserializer;
import com.springboot.json.JsonDateSimpleSerializer;

public class MesaViewModel {

	private String cod_mesa;
	private String nombre_mesa;
	private boolean disponibilidad;
	@JsonSerialize(using=JsonDateSimpleSerializer.class)
    @JsonDeserialize(using=JsonDateSimpleDeserializer.class)
	private Date fecha_mesa;
	private String hora_mesa;
	private String sugerencia_mesa;
	private String reservadoPor_mesa;
	public String getCod_mesa() {
		return cod_mesa;
	}
	public void setCod_mesa(String cod_mesa) {
		this.cod_mesa = cod_mesa;
	}
	public String getNombre_mesa() {
		return nombre_mesa;
	}
	public void setNombre_mesa(String nombre_mesa) {
		this.nombre_mesa = nombre_mesa;
	}
	public boolean isDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	public Date getFecha_mesa() {
		return fecha_mesa;
	}
	public void setFecha_mesa(Date fecha_mesa) {
		this.fecha_mesa = fecha_mesa;
	}
	public String getHora_mesa() {
		return hora_mesa;
	}
	public void setHora_mesa(String hora_mesa) {
		this.hora_mesa = hora_mesa;
	}
	public String getSugerencia_mesa() {
		return sugerencia_mesa;
	}
	public void setSugerencia_mesa(String sugerencia_mesa) {
		this.sugerencia_mesa = sugerencia_mesa;
	}
	public String getReservadoPor_mesa() {
		return reservadoPor_mesa;
	}
	public void setReservadoPor_mesa(String reservadoPor_mesa) {
		this.reservadoPor_mesa = reservadoPor_mesa;
	}
	
}
