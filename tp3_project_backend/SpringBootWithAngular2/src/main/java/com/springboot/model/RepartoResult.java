package com.springboot.model;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.springboot.json.JsonDateSimpleDeserializer;
import com.springboot.json.JsonDateSimpleSerializer;
import com.springboot.json.JsonHourSimpleSerializer;
import com.springboot.json.JsonOnlyHourSimpleSerializer;

public class RepartoResult {
	
	private Long cod_reparto;
    private String direccion_reparto;
    private String zona_reparto;
    @JsonSerialize(using=JsonOnlyHourSimpleSerializer.class)
    @JsonDeserialize(using=JsonDateSimpleDeserializer.class)
    private Date horainicio_reparto;
    @JsonSerialize(using=JsonOnlyHourSimpleSerializer.class)
    @JsonDeserialize(using=JsonDateSimpleDeserializer.class)
    private Date horaasignado_reparto;
    private String estado_reparto;
    private String cod_carta;
    private String nombres_repartidor;
    
    private String dest_latitude_reparto;
    private String dest_longitud_reparto;
    private String orig_latitude_reparto;
    private String orig_longitud_reparto;
    
	public Long getCod_reparto() {
		return cod_reparto;
	}
	public void setCod_reparto(Long cod_reparto) {
		this.cod_reparto = cod_reparto;
	}
	public String getDireccion_reparto() {
		return direccion_reparto;
	}
	public void setDireccion_reparto(String direccion_reparto) {
		this.direccion_reparto = direccion_reparto;
	}
	public String getZona_reparto() {
		return zona_reparto;
	}
	public void setZona_reparto(String zona_reparto) {
		this.zona_reparto = zona_reparto;
	}
	public Date getHorainicio_reparto() {
		return horainicio_reparto;
	}
	public void setHorainicio_reparto(Date horainicio_reparto) {
		this.horainicio_reparto = horainicio_reparto;
	}
	public Date getHoraasignado_reparto() {
		return horaasignado_reparto;
	}
	public void setHoraasignado_reparto(Date horaasignado_reparto) {
		this.horaasignado_reparto = horaasignado_reparto;
	}
	public String getEstado_reparto() {
		return estado_reparto;
	}
	public void setEstado_reparto(String estado_reparto) {
		this.estado_reparto = estado_reparto;
	}
	public String getCod_carta() {
		return cod_carta;
	}
	public void setCod_carta(String cod_carta) {
		this.cod_carta = cod_carta;
	}
	public String getNombres_repartidor() {
		return nombres_repartidor;
	}
	public void setNombres_repartidor(String nombres_repartidor) {
		this.nombres_repartidor = nombres_repartidor;
	}
	public String getDest_latitude_reparto() {
		return dest_latitude_reparto;
	}
	public void setDest_latitude_reparto(String dest_latitude_reparto) {
		this.dest_latitude_reparto = dest_latitude_reparto;
	}
	public String getDest_longitud_reparto() {
		return dest_longitud_reparto;
	}
	public void setDest_longitud_reparto(String dest_longitud_reparto) {
		this.dest_longitud_reparto = dest_longitud_reparto;
	}
	public String getOrig_latitude_reparto() {
		return orig_latitude_reparto;
	}
	public void setOrig_latitude_reparto(String orig_latitude_reparto) {
		this.orig_latitude_reparto = orig_latitude_reparto;
	}
	public String getOrig_longitud_reparto() {
		return orig_longitud_reparto;
	}
	public void setOrig_longitud_reparto(String orig_longitud_reparto) {
		this.orig_longitud_reparto = orig_longitud_reparto;
	}
    
	
    

}
