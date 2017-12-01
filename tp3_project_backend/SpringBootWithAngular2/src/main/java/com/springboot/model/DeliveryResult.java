package com.springboot.model;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.springboot.json.JsonDateSimpleDeserializer;
import com.springboot.json.JsonDateSimpleSerializer;
import com.springboot.json.JsonHourSimpleSerializer;

public class DeliveryResult {
	
	private Long id_deliv;
	private String longitud;
	private String latitude;
	private Long dni;
	private String estado_deliv;
	@JsonSerialize(using=JsonHourSimpleSerializer.class)
    @JsonDeserialize(using=JsonDateSimpleDeserializer.class)
	private Date fecha_deliv;
	@JsonSerialize(using=JsonHourSimpleSerializer.class)
    @JsonDeserialize(using=JsonDateSimpleDeserializer.class)
	private Date horaestimada_deliv;
	private String cod_carta_deliv;
	
	public Long getId_deliv() {
		return id_deliv;
	}
	public void setId_deliv(Long id_deliv) {
		this.id_deliv = id_deliv;
	}
	
	public Long getDni() {
		return dni;
	}
	public void setDni(Long dni) {
		this.dni = dni;
	}
	public String getEstado_deliv() {
		return estado_deliv;
	}
	public void setEstado_deliv(String estado_deliv) {
		this.estado_deliv = estado_deliv;
	}
	public Date getFecha_deliv() {
		return fecha_deliv;
	}
	public void setFecha_deliv(Date fecha_deliv) {
		this.fecha_deliv = fecha_deliv;
	}
	public String getCod_carta_deliv() {
		return cod_carta_deliv;
	}
	public void setCod_carta_deliv(String cod_carta_deliv) {
		this.cod_carta_deliv = cod_carta_deliv;
	}
	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public Date getHoraestimada_deliv() {
		return horaestimada_deliv;
	}
	public void setHoraestimada_deliv(Date horaestimada_deliv) {
		this.horaestimada_deliv = horaestimada_deliv;
	}
	
	
	
	

}
