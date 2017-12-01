package com.springboot.service.job;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.dto.ComandaDTO;
import com.springboot.model.Comanda;
import com.springboot.model.ComboPromocion;
import com.springboot.model.DetalleMesaPromocionpago;
import com.springboot.model.Mesa;
import com.springboot.model.Pedido;
import com.springboot.model.Promocion;
import com.springboot.model.PromocionPago;
import com.springboot.model.Repartidor;
import com.springboot.model.Reparto;
import com.springboot.repository.jdbc.ReservaJdbcRepository;
import com.springboot.repository.jpa.ComandaJpaRepository;
import com.springboot.repository.jpa.MesaJpaRepository;
import com.springboot.repository.jpa.PedidoJpaRepository;
import com.springboot.repository.jpa.PromocionJpaRepository;
import com.springboot.repository.jpa.PromocionPagoJpaRepository;
import com.springboot.repository.jpa.RepartidorJpaRepository;
import com.springboot.repository.jpa.RepartoJpaRepository;

@Service
public class PromocionJobImpl {
	
	@Autowired
	PromocionJpaRepository promocionJpaRepository;
	
	@Autowired
	ComandaJpaRepository comandaJpaRepository;
	
	@Autowired
	ReservaJdbcRepository reservaJdbcRepository;
	
	@Autowired
	PromocionPagoJpaRepository promocionPagoJpaRepository;
	
	@Autowired
	MesaJpaRepository mesaJpaRepository;
	
	@Autowired
	PedidoJpaRepository pedidoJpaRepository;
	
	@Autowired
	RepartidorJpaRepository repartidorJpaRepository;
	
	@Autowired
	RepartoJpaRepository repartoJpaRepository;
	
	@Scheduled(fixedRate = 30000)  // every 30 seconds
	@Transactional
	public void findPromocion() {
		
		List<Promocion> promocionEntity = promocionJpaRepository.findAll();
		for(Promocion promocionDTO: promocionEntity) {
			for(ComboPromocion comboDTO: promocionDTO.getCombo()) {
				List<ComandaDTO> comandaDTO = reservaJdbcRepository.buscarComandaPendiente(comboDTO.getParametroUno(), comboDTO.getParametroDos(), comboDTO.getParametroTres());
				if(comandaDTO.size()<3) {
					System.out.println("NO CUMPLE LA CONDICION");
				}else {
					PromocionPago promocionPago = new PromocionPago();
					Promocion promo = promocionJpaRepository.findOne(comboDTO.getPromocion().getIdPromocion());
					promocionPago.setPromocion(promo);
					promocionPago.setEstado("Pendiente");
					promocionPago.setNotificado(false);
					promocionPago.setDetallemesapromocionpago(new ArrayList<DetalleMesaPromocionpago>());
					
					for(ComandaDTO comandaModel: comandaDTO) {
						DetalleMesaPromocionpago detalleMesaPromoPago = new DetalleMesaPromocionpago();
						Mesa mesa = mesaJpaRepository.findOne(comandaModel.getCod_mesa());
						detalleMesaPromoPago.setMesa(mesa);
						detalleMesaPromoPago.setPromocionPago(promocionPago);
						promocionPago.getDetallemesapromocionpago().add(detalleMesaPromoPago);
						
						Comanda comandaEntity = comandaJpaRepository.findOne(comandaModel.getId_comanda());
						comandaEntity.setSugerencia("Notificada");
						comandaJpaRepository.save(comandaEntity);
						System.out.println("SI CUMPLE LA CONDICION:" + comandaModel.getCod_mesa() +" ---- "+comandaModel.getId_comanda()+"PROMOCION_ID: "+comboDTO.getPromocion().getIdPromocion());
						
					}
					
					promocionPagoJpaRepository.save(promocionPago);
					promocionPagoJpaRepository.flush();
					System.out.println(promocionPago);
					
				}
				
			}
			
		}
		
	}
	
	@Scheduled(fixedRate = 30000)  // every 30 seconds
	@Transactional
	public void asignarRepartidor() {
		
		Date currentDate = new Date();
		List<Pedido> pedidoEntity = pedidoJpaRepository.findPedidoPendiente("PorAsignarReparto",currentDate);

		for(Pedido pedidoModel: pedidoEntity) {
			Long diferencia = getDateDiff(pedidoModel.getFecha(),currentDate,TimeUnit.MINUTES);
			if((diferencia>4 && diferencia<6) && pedidoEntity.size()>2) {
				System.out.println("Hay mas de 2 pedidos en 5 minutos");
				System.out.println("Asignar reparto");
				updateAndInsertPedidoReparto(pedidoModel,currentDate);
				
			}else if(diferencia<11 && pedidoEntity.size()>2) {
				System.out.println("Hay mas de 2 pedidos entre 6 a 10 minutos");
				updateAndInsertPedidoReparto(pedidoModel,currentDate);
				
			}else if(diferencia<16 && pedidoEntity.size()>2) {
				System.out.println("Hay mas de 3 pedidos entre 10 a 15 minutos");
				updateAndInsertPedidoReparto(pedidoModel,currentDate);
				
			}else if((diferencia>19) && (pedidoEntity.size()==1 || pedidoEntity.size()==2)) {
				System.out.println("Hay un pedido o dos");
				updateAndInsertPedidoReparto(pedidoModel,currentDate);
			}
		}
		
	}
	
	private void updateAndInsertPedidoReparto(Pedido pedidoModel, Date currentDate) {
		Pedido pedidoEntity = pedidoJpaRepository.findOne(pedidoModel.getIdPedido());
		pedidoEntity.setEstado("RepartoAsignado");
		pedidoJpaRepository.save(pedidoEntity);
		pedidoJpaRepository.flush();
		
		Reparto repartoEntity = new Reparto();
		repartoEntity.setDireccion(pedidoModel.getDireccion());
		repartoEntity.setHoraInicio(pedidoModel.getFecha());
		repartoEntity.setHoraAsignado(currentDate);
		repartoEntity.setEstado("RepartoAsignado");
		repartoEntity.setOrigLatitud("-12.100417");
		repartoEntity.setOrigLongitud("-77.001944");
		repartoEntity.setDestLatitud(pedidoModel.getLatitud());
		repartoEntity.setDestLongitud(pedidoModel.getLongitud());
		repartoEntity.setPedido(pedidoModel);
		List<Repartidor> Repartidor = repartidorJpaRepository.buscarRepartidorLibre("Libre");
		
		Repartidor repartidorEntity = null;
		for(Repartidor repar: Repartidor) {
			repartidorEntity = repartidorJpaRepository.findOne(repar.getIdRepartidor());
			break;
		}
		
		repartidorEntity.setEstado("Ocupado");
		repartoEntity.setRepartidor(repartidorEntity);
		repartidorJpaRepository.save(repartidorEntity);
		repartidorJpaRepository.flush();
		
		
		repartoJpaRepository.save(repartoEntity);
		repartoJpaRepository.flush();
		
	}

	public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
	    long diffInMillies = date2.getTime() - date1.getTime();
	    return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
	}
	
	private class TotalCartaComanda {
		
		private String id_mesa;
		private String id_carta;
		
		private TotalCartaComanda() {}
		
		public String getId_mesa() {
			return id_mesa;
		}
		public void setId_mesa(String id_mesa) {
			this.id_mesa = id_mesa;
		}
		public String getId_carta() {
			return id_carta;
		}
		public void setId_carta(String id_carta) {
			this.id_carta = id_carta;
		}
		
		
	}

}
