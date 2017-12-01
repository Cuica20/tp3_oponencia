package com.springboot.model;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.springboot.json.JsonDateSimpleDeserializer;
import com.springboot.json.JsonDateSimpleSerializer;

public class ReservaResult {

	private Long cod_reserva;
	@JsonSerialize(using=JsonDateSimpleSerializer.class)
    @JsonDeserialize(using=JsonDateSimpleDeserializer.class)
    private Date fecha_reserva;
    private String tipo_reserva;
    private String dni;
    private String motivo;
    
    @JsonSerialize(using=JsonDateSimpleSerializer.class)
    @JsonDeserialize(using=JsonDateSimpleDeserializer.class)
    private Date fecha;
    private String hora;
    private String cantidad_personas;
    private String estado;
    private String nombre_cliente;
    private String nombre_local;
    private Long cod_mesa;
    private String nombre_mesa;
    private String mesa;
    
	public Long getCod_reserva() {
		return cod_reserva;
	}
	public void setCod_reserva(Long cod_reserva) {
		this.cod_reserva = cod_reserva;
	}
	public Date getFecha_reserva() {
		return fecha_reserva;
	}
	public void setFecha_reserva(Date fecha_reserva) {
		this.fecha_reserva = fecha_reserva;
	}
	public String getTipo_reserva() {
		return tipo_reserva;
	}
	public void setTipo_reserva(String tipo_reserva) {
		this.tipo_reserva = tipo_reserva;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getNombre_cliente() {
		return nombre_cliente;
	}
	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}
	
	public String getMesa() {
		return mesa;
	}
	public void setMesa(String mesa) {
		this.mesa = mesa;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getNombre_local() {
		return nombre_local;
	}
	public void setNombre_local(String nombre_local) {
		this.nombre_local = nombre_local;
	}
	public String getCantidad_personas() {
		return cantidad_personas;
	}
	public void setCantidad_personas(String cantidad_personas) {
		this.cantidad_personas = cantidad_personas;
	}
	public Long getCod_mesa() {
		return cod_mesa;
	}
	public void setCod_mesa(Long cod_mesa) {
		this.cod_mesa = cod_mesa;
	}
	public String getNombre_mesa() {
		return nombre_mesa;
	}
	public void setNombre_mesa(String nombre_mesa) {
		this.nombre_mesa = nombre_mesa;
	}
	
	
    
	
}
