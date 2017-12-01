package com.springboot.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "promocionpago")
public class PromocionPago {

	private Long idPromocionPago;
	private Promocion promocion;
	private String estado;
	private boolean notificado;
	private List<DetalleMesaPromocionpago> detallemesapromocionpago;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPromocionPago")
	public Long getIdPromocionPago() {
		return idPromocionPago;
	}
	public void setIdPromocionPago(Long idPromocionPago) {
		this.idPromocionPago = idPromocionPago;
	}
	
	@ManyToOne()
    @JoinColumn(name = "idPromocion")
	public Promocion getPromocion() {
		return promocion;
	}
	public void setPromocion(Promocion promocion) {
		this.promocion = promocion;
	}
	
	@Column(name = "estado")
	@Size(min=100, max=150)
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REFRESH }, orphanRemoval = true, mappedBy = "promocionPago", fetch = FetchType.EAGER)
	@Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE,
			org.hibernate.annotations.CascadeType.MERGE, org.hibernate.annotations.CascadeType.PERSIST })
	public List<DetalleMesaPromocionpago> getDetallemesapromocionpago() {
		return detallemesapromocionpago;
	}
	public void setDetallemesapromocionpago(List<DetalleMesaPromocionpago> detallemesapromocionpago) {
		this.detallemesapromocionpago = detallemesapromocionpago;
	}
	
	@Column(name = "notificado")
	public boolean isNotificado() {
		return notificado;
	}
	public void setNotificado(boolean notificado) {
		this.notificado = notificado;
	}
	
	
	
}
