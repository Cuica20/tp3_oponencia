package com.springboot.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "reparto")
public class Reparto {
	
	private Long idReparto;
    private String direccion;
    private Date horaInicio;
    private Date horaAsignado;
    private String estado;
    private String origLatitud;
	private String origLongitud;
	private String destLatitud;
	private String destLongitud;
    private Pedido pedido;
    private Repartidor repartidor;
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReparto")
	public Long getIdReparto() {
		return idReparto;
	}
	public void setIdReparto(Long idReparto) {
		this.idReparto = idReparto;
	}
	
	@Column(name = "direccion")
	@Size(min=100, max=150)
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@Column(name = "horaInicio")
	public Date getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}
	
	@Column(name = "horaAsignado")
	public Date getHoraAsignado() {
		return horaAsignado;
	}
	public void setHoraAsignado(Date horaAsignado) {
		this.horaAsignado = horaAsignado;
	}
	
	@Column(name = "estado")
	@Size(min=100, max=150)
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	@OneToOne()
	@JoinColumn(name = "idPedido")
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	@OneToOne()
	@JoinColumn(name = "idRepartidor")
	public Repartidor getRepartidor() {
		return repartidor;
	}
	public void setRepartidor(Repartidor repartidor) {
		this.repartidor = repartidor;
	}
	
	@Column(name = "origLatitud")
	@Size(min=100, max=150)
	public String getOrigLatitud() {
		return origLatitud;
	}
	public void setOrigLatitud(String origLatitud) {
		this.origLatitud = origLatitud;
	}
	
	@Column(name = "origLongitud")
	@Size(min=100, max=150)
	public String getOrigLongitud() {
		return origLongitud;
	}
	public void setOrigLongitud(String origLongitud) {
		this.origLongitud = origLongitud;
	}
	
	@Column(name = "destLatitud")
	@Size(min=100, max=150)
	public String getDestLatitud() {
		return destLatitud;
	}
	public void setDestLatitud(String destLatitud) {
		this.destLatitud = destLatitud;
	}
	
	@Column(name = "destLongitud")
	@Size(min=100, max=150)
	public String getDestLongitud() {
		return destLongitud;
	}
	public void setDestLongitud(String destLongitud) {
		this.destLongitud = destLongitud;
	}
    

}
