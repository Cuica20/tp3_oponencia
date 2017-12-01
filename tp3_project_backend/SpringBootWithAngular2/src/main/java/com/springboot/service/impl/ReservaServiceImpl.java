package com.springboot.service.impl;

import com.springboot.repository.jdbc.ReservaJdbcRepository;
import com.springboot.repository.jpa.ClienteJpaRepository;
import com.springboot.repository.jpa.LocalJpaRepository;
import com.springboot.repository.jpa.MesaJpaRepository;
import com.springboot.repository.jpa.PedidoProyectadoJpaRepository;
//import com.springboot.repository.jpa.PedidoProyectadoJpaRepository;
import com.springboot.repository.jpa.ReservaJpaRepository;
import com.springboot.model.CartaResult;
import com.springboot.model.Cliente;
import com.springboot.model.ClienteViewModel;
import com.springboot.model.DeliveryResult;
import com.springboot.model.Local;
import com.springboot.model.Mesa;
import com.springboot.model.MesaViewModel;
import com.springboot.model.NotificacionViewModel;
import com.springboot.model.PedidoDetalleResult;
import com.springboot.model.PedidoProyectado;
import com.springboot.model.PedidoProyectadoFilter;
import com.springboot.model.PedidoResult;
import com.springboot.model.PromocionPagoResult;
import com.springboot.model.RepartoFilter;
import com.springboot.model.RepartoResult;
import com.springboot.model.Reserva;
import com.springboot.model.ReservaFilter;
import com.springboot.model.ReservaResult;
import com.springboot.model.ReservaViewModel;
import com.springboot.service.ReservaService;

import com.springboot.model.PedidoProyectadoResult;/*J*/
import com.springboot.model.LocalResult;/*J*/
import com.springboot.model.PedidoProyectadoViewModel; /*J*/


import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Implementacion del service que obtiene los servicios de la empresa
 * @author javiercuica
 * @version 1.0
 */
@Component
public class ReservaServiceImpl implements ReservaService {

	@Autowired
	ReservaJdbcRepository reservaJdbcRepository;
	
	@Autowired
	ReservaJpaRepository reservaJpaRepository;
	
	@Autowired
	PedidoProyectadoJpaRepository pedidoproyectadoJpaRepository;
	
	@Autowired
	ClienteJpaRepository clienteJpaRepository;
	
	@Autowired
	MesaJpaRepository mesaJpaRepository;
	
	@Autowired
	LocalJpaRepository localJpaRepository;
	
	Mapper mapper;

	@Override
	public List<ReservaResult> searchReserva(ReservaFilter reservaFilter) {
		return reservaJdbcRepository.searchReserva(reservaFilter);
	}

	@Override
	public ReservaViewModel getReservaByCode(Long cod_reserva) {
		ReservaViewModel dto = new ReservaViewModel();
		
		Reserva reservaEntity = reservaJpaRepository.findOne(cod_reserva);
		dto.setCod_reserva(reservaEntity.getIdReserva());
		dto.setFecha_reserva(reservaEntity.getFecha());
		dto.setTipo_reserva(reservaEntity.getTipo());
		dto.setMotivo(reservaEntity.getMotivo());
		dto.setHora(reservaEntity.getHora());
		dto.setCantidad_personas(reservaEntity.getCantidadPersonas());
		dto.setEstado(reservaEntity.getEstado());
		dto.setComentario(reservaEntity.getComentario());
		
		Cliente clienteEntity = clienteJpaRepository.findOne(reservaEntity.getCliente().getDni());
		dto.setDni(clienteEntity.getDni());
		dto.setNombre(clienteEntity.getNombre());
		dto.setAp_paterno(clienteEntity.getApPaterno());
		dto.setCorreo(clienteEntity.getCorreo());
		dto.setTelefono(clienteEntity.getTelefono());
		
		Mesa mesaEntity = mesaJpaRepository.findOne(reservaEntity.getMesa().getIdMesa());
		dto.setCod_mesa(mesaEntity.getIdMesa());
		
		Local localEntity = localJpaRepository.findLocalByName(reservaEntity.getLocal().getDescripcion());
		dto.setNombre_local(localEntity.getDescripcion());
		
		
		return dto;
	}

	@Override
	public NotificacionViewModel actualizarReserva(ReservaViewModel reservaModel) {

		NotificacionViewModel notificacion = new NotificacionViewModel();
		
		try{
			Reserva dto = new Reserva();
	
			dto.setIdReserva(reservaModel.getCod_reserva());
			dto.setFecha(reservaModel.getFecha_reserva());
			dto.setTipo(reservaModel.getTipo_reserva());
			dto.setMotivo(reservaModel.getMotivo());
			dto.setHora(reservaModel.getHora());
			dto.setCantidadPersonas(reservaModel.getCantidad_personas());
			dto.setEstado(reservaModel.getEstado());
			dto.setComentario(reservaModel.getComentario());
			
			Cliente clienteEntity = clienteJpaRepository.findOne(reservaModel.getDni());
			dto.setCliente(clienteEntity);
			
			Mesa mesaEntityAnterior = mesaJpaRepository.findOne(reservaModel.getCod_mesa_anterior());

			Mesa mesaentiAnterior = new Mesa();
			mesaentiAnterior.setIdMesa(mesaEntityAnterior.getIdMesa());
			mesaentiAnterior.setDisponibilidad(true);
			mesaentiAnterior.setFecha(mesaEntityAnterior.getFecha());
			mesaentiAnterior.setHora(mesaEntityAnterior.getHora());
			mesaJpaRepository.save(mesaentiAnterior);
			mesaJpaRepository.flush();
			
			Mesa mesaEntity = mesaJpaRepository.findOne(reservaModel.getCod_mesa());
			Mesa mesaentiNueva = new Mesa();
			mesaentiNueva.setIdMesa(mesaEntity.getIdMesa());
			mesaentiNueva.setDisponibilidad(false);
			mesaentiNueva.setFecha(mesaEntity.getFecha());
			mesaentiNueva.setHora(mesaEntity.getHora());
			mesaJpaRepository.save(mesaentiNueva);
			mesaJpaRepository.flush();
			
			dto.setMesa(mesaEntity);
			
			Local localEntity = localJpaRepository.findLocalByName(reservaModel.getNombre_local());
			dto.setLocal(localEntity);
			
			reservaJpaRepository.save(dto);
			reservaJpaRepository.flush();
			
			notificacion.setCodigo(1L);
			notificacion.setSeverity("success");
			notificacion.setSummary("Runakuna Success");
			notificacion.setDetail("Se actualizo exitosamente");
			return notificacion;
			
		} catch (Exception e) {
			notificacion.setCodigo(0L);
			notificacion.setSeverity("error");
			notificacion.setSummary("Runakuna Error");
			notificacion.setDetail("No es posible registrar, "+e.getMessage());
			e.printStackTrace();
		}
		return notificacion;
	}

	@Override
	public NotificacionViewModel anularReserva(ReservaViewModel reservaModel) {
		NotificacionViewModel notificacion = new NotificacionViewModel();
		Reserva entity = reservaJpaRepository.findOne(reservaModel.getCod_reserva());
		entity.setEstado("Anulado");
		reservaJpaRepository.save(entity);
		reservaJpaRepository.flush();
		
		Mesa mesaenti = new Mesa();
		mesaenti.setIdMesa(reservaModel.getCod_mesa());
		mesaenti.setDisponibilidad(true);
		mesaenti.setFecha(reservaModel.getFecha_reserva());
		mesaenti.setHora(reservaModel.getHora());
		mesaJpaRepository.save(mesaenti);
		mesaJpaRepository.flush();
		
		notificacion.setCodigo(1L);
		notificacion.setSeverity("success");
		notificacion.setSummary("Runakuna Success");
		notificacion.setDetail("El registro fue anulado correctamente");
		return notificacion;
	}

	@Override
	public ClienteViewModel obtenerInformacionClienteByDNI(Long dni) {
		ClienteViewModel dto = reservaJdbcRepository.obtenerInformacionClienteByDNI(dni);
		return dto;
	}

	@Override
	public MesaViewModel obtenerUltimaReservaClienteByDNI(Long dni) {
		MesaViewModel dto = reservaJdbcRepository.obtenerUltimaReservaClienteByDNI(dni);
		return dto;
	}

	@Override
	public NotificacionViewModel registrarReserva(ReservaViewModel reservaModel) {
		NotificacionViewModel notificacion = new NotificacionViewModel();
		
		try{
			Reserva dto = new Reserva();
			dto.setFecha(reservaModel.getFecha_reserva());
			dto.setTipo(reservaModel.getTipo_reserva());
			dto.setMotivo(reservaModel.getMotivo());
			dto.setHora(reservaModel.getHora());
			dto.setCantidadPersonas(reservaModel.getCantidad_personas());
			dto.setEstado("Confirmado");
			dto.setComentario(reservaModel.getComentario());
			
			Cliente clienteEntity = clienteJpaRepository.findOne(reservaModel.getDni());
			if(clienteEntity == null){
				Cliente clienteDto = new Cliente();
				clienteDto.setDni(reservaModel.getDni());
				clienteDto.setNombre(reservaModel.getNombre());
				clienteDto.setApPaterno(reservaModel.getAp_paterno());
				clienteDto.setCorreo(reservaModel.getCorreo());
				clienteDto.setTelefono(reservaModel.getTelefono());
				clienteJpaRepository.save(clienteDto);
				reservaJpaRepository.flush();
				
				Cliente clienteEnti = clienteJpaRepository.findOne(clienteDto.getDni());
				dto.setCliente(clienteEnti);
			}else{
				dto.setCliente(clienteEntity);
			}
			
			Mesa mesaenti = new Mesa();
			mesaenti.setIdMesa(reservaModel.getCod_mesa());
			mesaenti.setDisponibilidad(false);
			mesaenti.setFecha(reservaModel.getFecha_reserva());
			mesaenti.setHora(reservaModel.getHora());
			mesaJpaRepository.save(mesaenti);
			mesaJpaRepository.flush();
			
			Mesa mesaEntity = mesaJpaRepository.findOne(reservaModel.getCod_mesa());
			dto.setMesa(mesaEntity);
			
			Local localEntity = localJpaRepository.findLocalByName(reservaModel.getNombre_local());
			dto.setLocal(localEntity);
			
			reservaJpaRepository.save(dto);
			reservaJpaRepository.flush();
			
			notificacion.setCodigo(1L);
			notificacion.setSeverity("success");
			notificacion.setSummary("Runakuna Success");
			notificacion.setDetail("Se actualizo exitosamente");
			return notificacion;
		} catch (Exception e) {
			notificacion.setCodigo(0L);
			notificacion.setSeverity("error");
			notificacion.setSummary("Runakuna Error");
			notificacion.setDetail("No es posible registrar, "+e.getMessage());
			e.printStackTrace();
		}
		return notificacion;
	}

	@Override
	public List<MesaViewModel> getDisponibilidadMesas(Long dni) {
		return reservaJdbcRepository.getDisponibilidadMesas(dni);
	}

	@Override
	public List<MesaViewModel> getMesaDisponibleByDateHour(ReservaViewModel reservaViewModel) {
		return reservaJdbcRepository.getMesaDisponibleByDateHour(reservaViewModel);
	}

	@Override
	public MesaViewModel verDisponibilidadMesa(Long cod_mesa) {
		return reservaJdbcRepository.verDisponibilidadMesa(cod_mesa);
	}

	@Override
	public List<PedidoResult> buscarTodoPedido() {
		return reservaJdbcRepository.buscarTodoPedido();
	}

	@Override
	public List<DeliveryResult> buscarTodoDelivery() {
		return reservaJdbcRepository.buscarTodoDelivery();
	}
	
	/*J*/
	
	@Override
	public List<PedidoProyectadoResult> buscarPedidoProyectado() {
		return reservaJdbcRepository.buscarPedidoProyectado();
	}
	
	@Override
	public List<PedidoProyectadoResult> buscarPedidoProyectadoByDistrito(PedidoProyectadoFilter descripcionlocal) {
		return reservaJdbcRepository.buscarPedidoProyectadoByDistrito(descripcionlocal);
	}

	@Override
	public NotificacionViewModel agregarPedidoProyectado(PedidoProyectadoFilter model) {
		
		NotificacionViewModel notificacion = new NotificacionViewModel();
		
		try{
			PedidoProyectado dto = new PedidoProyectado();
			dto.setFecha(model.getFecha());
			Local local = localJpaRepository.findOne(model.getIdlocal());
			dto.setLocal(local);
			dto.setEstado(model.getEstado());
			dto.setNombre(model.getEstado());
			dto.setDescripcion(model.getDescripcion());
			dto.setCantidad(model.getCantidad());
			dto.setPrecio(model.getPrecio());
			dto.setCosto(model.getCosto());
			dto.setFlat(false);
			dto.setColor(model.getColor());
			
			pedidoproyectadoJpaRepository.save(dto);
			pedidoproyectadoJpaRepository.flush();
			
			notificacion.setCodigo(1L);
			notificacion.setSeverity("success");
			notificacion.setSummary("Runakuna Success");
			notificacion.setDetail("Se registro exitosamente");
			return notificacion;
		} catch (Exception e) {
			notificacion.setCodigo(0L);
			notificacion.setSeverity("error");
			notificacion.setSummary("Runakuna Error");
			notificacion.setDetail("No es posible registrar, "+e.getMessage());
			e.printStackTrace();
		}
		return notificacion;
		
	}	
	
	public List<LocalResult> buscarLocal() {
		return reservaJdbcRepository.buscarLocal();
	}
	
	@Override
	public NotificacionViewModel eliminarPedidoProyectado(PedidoProyectadoViewModel pedidoproyectadoModel) {
		NotificacionViewModel notificacion = new NotificacionViewModel();
		PedidoProyectado entity = pedidoproyectadoJpaRepository.findOne(pedidoproyectadoModel.getIdPedidoProyectado());
		pedidoproyectadoJpaRepository.delete(entity);
		pedidoproyectadoJpaRepository.flush();
		
		
		notificacion.setCodigo(1L);
		notificacion.setSeverity("success");
		notificacion.setSummary("Runakuna Success");
		notificacion.setDetail("El registro fue eliminado correctamente");
		return notificacion;
	}

	@Override
	public List<PedidoDetalleResult> obtenerPedidoDetalleById(Long code) {
		return reservaJdbcRepository.obtenerPedidoDetalleById(code);
	}

	@Override
	public List<PromocionPagoResult> buscarpromocionpago() {
		return reservaJdbcRepository.buscarpromocionpago();
	}

	@Override
	public List<CartaResult> cartaTotal() {
		return reservaJdbcRepository.cartaTotal();
	}

	@Override
	public List<RepartoResult> buscarReparto(RepartoFilter repartoFilter) {
		return reservaJdbcRepository.buscarReparto(repartoFilter);
	}
	
}
