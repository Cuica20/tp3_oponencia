package com.springboot.model;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.springboot.json.JsonDateSimpleDeserializer;
import com.springboot.json.JsonDateSimpleSerializer;

public class ReservaViewModel {
	
	private Long cod_reserva;
	@JsonSerialize(using=JsonDateSimpleSerializer.class)
	@JsonDeserialize(using=JsonDateSimpleDeserializer.class)
    private Date fecha_reserva;
    private String tipo_reserva;
    private String motivo;
    private String hora;
    private String cantidad_personas;
    private String estado;
    private String comentario;
    
    private Long dni;
    private String nombre;
    private String ap_paterno;
    private String correo;
    private String telefono;
    private Long cod_mesa;
    private Long cod_mesa_anterior;
    private String nombre_mesa;
    private Long mesa;
    private String nombre_local;
    
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
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Long getDni() {
		return dni;
	}
	public void setDni(Long dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAp_paterno() {
		return ap_paterno;
	}
	public void setAp_paterno(String ap_paterno) {
		this.ap_paterno = ap_paterno;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Long getCod_mesa() {
		return cod_mesa;
	}
	public void setCod_mesa(Long cod_mesa) {
		this.cod_mesa = cod_mesa;
	}
	public String getCantidad_personas() {
		return cantidad_personas;
	}
	public void setCantidad_personas(String cantidad_personas) {
		this.cantidad_personas = cantidad_personas;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public String getNombre_local() {
		return nombre_local;
	}
	public void setNombre_local(String nombre_local) {
		this.nombre_local = nombre_local;
	}
	public Long getMesa() {
		return mesa;
	}
	public void setMesa(Long mesa) {
		this.mesa = mesa;
	}
	public String getNombre_mesa() {
		return nombre_mesa;
	}
	public void setNombre_mesa(String nombre_mesa) {
		this.nombre_mesa = nombre_mesa;
	}
	public Long getCod_mesa_anterior() {
		return cod_mesa_anterior;
	}
	public void setCod_mesa_anterior(Long cod_mesa_anterior) {
		this.cod_mesa_anterior = cod_mesa_anterior;
	}
	

}
