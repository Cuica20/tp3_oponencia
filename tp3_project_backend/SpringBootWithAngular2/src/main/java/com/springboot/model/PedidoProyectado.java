package com.springboot.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

@Entity
@Table(name = "pedidoproyectado")
public class PedidoProyectado {
	
	
	private Long idPedidoProyectado;
    private Date fecha;
    private Local local;
    private String estado;
    private String nombre;
    private String descripcion;
    private Integer cantidad;
    private BigDecimal precio;
    private BigDecimal costo;
    private boolean flat;
    private String color;
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPedidoProyectado")
	public Long getIdPedidoProyectado() {
		return idPedidoProyectado;
	}
	public void setIdPedidoProyectado(Long idPedidoProyectado) {
		this.idPedidoProyectado = idPedidoProyectado;
	}
	
	@Column(name = "fecha")
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	@ManyToOne()
    @JoinColumn(name = "idLocal")
	public Local getLocal() {
		return local;
	}
	public void setLocal(Local local) {
		this.local = local;
	}
	
	@Column(name = "estado")
	@Size(min=50, max=100)
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	@Column(name = "nombre")
	@Size(min=100, max=150)
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(name = "descripcion")
	@Size(min=100, max=150)
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Column(name = "cantidad")
	@Digits(fraction = 0, integer = 2)
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	@Column(name = "precio")
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	
	@Column(name = "costo")
	public BigDecimal getCosto() {
		return costo;
	}
	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}
	
	@Column(name = "flat")
	public boolean isFlat() {
		return flat;
	}
	public void setFlat(boolean flat) {
		this.flat = flat;
	}
	
	@Column(name = "color")
	@Size(min=50, max=100)
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
    
    

}
