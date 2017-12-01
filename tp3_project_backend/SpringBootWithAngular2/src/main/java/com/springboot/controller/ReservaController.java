package com.springboot.controller;

import com.springboot.model.CartaResult;
import com.springboot.model.ClienteViewModel;
import com.springboot.model.DeliveryResult;
import com.springboot.model.LocalResult;
import com.springboot.model.MesaViewModel;
import com.springboot.model.NotificacionViewModel;
import com.springboot.model.PedidoDetalleResult;
import com.springboot.model.PedidoProyectadoFilter;
import com.springboot.model.PedidoProyectadoResult;
import com.springboot.model.PedidoProyectadoViewModel;
import com.springboot.model.PedidoResult;
import com.springboot.model.PromocionPagoResult;
import com.springboot.model.RepartoFilter;
import com.springboot.model.RepartoResult;
import com.springboot.model.ReservaFilter;
import com.springboot.model.ReservaResult;
import com.springboot.model.ReservaViewModel;
import com.springboot.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Controlador del servicio obtener servicios por empresa, que devolvera a la
 * capa vista un objeto
 * 
 * @author Javier Cuicapuza
 * @version 1.0
 * 
 */
@RestController
@RequestMapping("/reserva")
public class ReservaController {

	@Autowired
	ReservaService reservaService;

	/**
	 * Metodo controlador que recibe la peticion de la capa
	 * web para obtener la informacion de la lista de reservas
	 * 
	 * @param ReservaFilter
	 * @return ReservaResult
	 * @throws Exception
	 */
	@RequestMapping(value = "/buscarReserva", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<List<ReservaResult>> buscarReserva(@RequestBody ReservaFilter reservaFilter) throws Exception{
        
    	List<ReservaResult> result;
    	result = reservaService.searchReserva(reservaFilter);
    	if(result == null)
    		result = new ArrayList<>();
    	return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	/**
	 * Metodo controlador que recibe la peticion de la capa
	 * web para obtener la informacion de la reserva por el id
	 * 
	 * @param Long id
	 * @return ReservaViewModel
	 * @throws Exception
	 */
	@RequestMapping(value = "/reservaByCode", method = RequestMethod.POST)
	public @ResponseBody ReservaViewModel reservaByCode(@RequestBody Long code){
		ReservaViewModel result = new ReservaViewModel();
		result = reservaService.getReservaByCode(code);
		if(result == null)
			result = new ReservaViewModel();
		return result;
	}
	
	/**
	 * Metodo controlador que recibe la peticion de la capa
	 * web para obtener la disponibilidad de mesas por dni
	 * 
	 * @param Long dni
	 * @return MesaViewModel
	 * @throws Exception
	 */
	@RequestMapping(value = "/getDisponibilidadMesas", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<List<MesaViewModel>> getDisponibilidadMesas(@RequestBody Long dni) throws Exception{
        
    	List<MesaViewModel> result;
    	result = reservaService.getDisponibilidadMesas(dni);
    	if(result == null)
    		result = new ArrayList<>();
    	return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	/**
	 * Metodo controlador que recibe la peticion de la capa
	 * web para obtener la informacion de las mesas disponibles por hora y fecha
	 * 
	 * @param ReservaViewModel
	 * @return MesaViewModel
	 * @throws Exception
	 */
	@RequestMapping(value = "/getMesaDisponibleByDateHour", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<List<MesaViewModel>> getMesaDisponibleByDateHour(@RequestBody ReservaViewModel reservaViewModel) 	throws Exception{
        
    	List<MesaViewModel> result;
    	result = reservaService.getMesaDisponibleByDateHour(reservaViewModel);
    	if(result == null)
    		result = new ArrayList<>();
    	return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	/**
	 * Metodo controlador que recibe la peticion de la capa
	 * web para notificar la actualizacion de la reserva
	 * 
	 * @param ReservaViewModel
	 * @return NotificacionViewModel
	 * @throws Exception
	 */
	@RequestMapping(value = "/actualizarReserva", method = RequestMethod.POST)
	public @ResponseBody NotificacionViewModel actualizarReserva(@RequestBody ReservaViewModel reservaModel) {
		
		NotificacionViewModel dto = reservaService.actualizarReserva(reservaModel);
		return dto;
	}
	
	/**
	 * Metodo controlador que recibe la peticion de la capa
	 * web para notificar la anulacion de la reserva
	 * 
	 * @param ReservaViewModel
	 * @return NotificacionViewModel
	 * @throws Exception
	 */
	@RequestMapping(value = "/anularReserva", method = RequestMethod.POST)
	public @ResponseBody NotificacionViewModel anularReserva(@RequestBody ReservaViewModel reservaModel) {
		
		NotificacionViewModel dto = reservaService.anularReserva(reservaModel);
		return dto;
	}
	
	/**
	 * Metodo controlador que recibe la peticion de la capa
	 * web para obtener informacion del cliente por dni
	 * 
	 * @param Long dni
	 * @return ClienteViewModel
	 * @throws Exception
	 */
	@RequestMapping(value = "/obtenerInformacionClienteByDNI", method = RequestMethod.POST)
	public @ResponseBody ClienteViewModel obtenerInformacionClienteByDNI(@RequestBody Long dni) {
		ClienteViewModel dto = reservaService.obtenerInformacionClienteByDNI(dni);
		if(dto == null){
			dto = new ClienteViewModel();
		}
		return dto;
	}
	
	/**
	 * Metodo controlador que recibe la peticion de la capa
	 * web para obtener ultima reserva del cliente por dni
	 * 
	 * @param Long dni
	 * @return MesaViewModel
	 * @throws Exception
	 */
	@RequestMapping(value = "/obtenerUltimaReservaClienteByDNI", method = RequestMethod.POST)
	public @ResponseBody MesaViewModel obtenerUltimaReservaClienteByDNI(@RequestBody Long dni) {
		MesaViewModel dto = reservaService.obtenerUltimaReservaClienteByDNI(dni);
		if(dto == null){
			dto = new MesaViewModel();
		}
		return dto;
	}
	
	/**
	 * Metodo controlador que recibe la peticion de la capa
	 * web para obtener disponibilidad de mesa por idMesa
	 * 
	 * @param Long idMesa
	 * @return MesaViewModel
	 * @throws Exception
	 */
	@RequestMapping(value = "/verDisponibilidadMesa", method = RequestMethod.POST)
	public @ResponseBody MesaViewModel verDisponibilidadMesa(@RequestBody Long cod_mesa) {
		MesaViewModel dto = reservaService.verDisponibilidadMesa(cod_mesa);
		if(dto == null){
			dto = new MesaViewModel();
		}
		return dto;
	}
	
	/**
	 * Metodo controlador que recibe la peticion de la capa
	 * web para obtener notificacion del registro de la reserva
	 * 
	 * @param Long ReservaViewModel
	 * @return NotificacionViewModel
	 * @throws Exception
	 */
	@RequestMapping(value = "/registrarReserva", method = RequestMethod.POST)
	public @ResponseBody NotificacionViewModel registrarPermisoEmpleado(@RequestBody ReservaViewModel reservaViewModel) {
		
		NotificacionViewModel dto = reservaService.registrarReserva(reservaViewModel);
		return dto;
	}
	
	/**
	 * Metodo controlador que recibe la peticion de la capa
	 * web para obtener informacion de todos los pedidos
	 * 
	 * @param String
	 * @return PedidoResult
	 * @throws Exception
	 */
	@RequestMapping(value = "/buscarTodoPedido", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<List<PedidoResult>> buscarTodoPedido(@RequestBody String all) throws Exception{
        
    	List<PedidoResult> result;
    	result = reservaService.buscarTodoPedido();
    	if(result == null)
    		result = new ArrayList<>();
    	return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	/**
	 * Metodo controlador que recibe la peticion de la capa
	 * web para obtener informacion de todos las entregas
	 * 
	 * @param String
	 * @return DeliveryResult
	 * @throws Exception
	 */
	@RequestMapping(value = "/buscarTodoDelivery", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<List<DeliveryResult>> buscarTodoDelivery(@RequestBody String all) throws Exception{
        
    	List<DeliveryResult> result;
    	result = reservaService.buscarTodoDelivery();
    	if(result == null)
    		result = new ArrayList<>();
    	return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	/**
	 * Metodo controlador que recibe la peticion de la capa
	 * web para obtener informacion del pedidodetalle por id
	 * 
	 * @param id
	 * @return PedidoDetalleResult
	 * @throws Exception
	 */
	@RequestMapping(value = "/obtenerPedidoDetalleById", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<List<PedidoDetalleResult>> obtenerPedidoDetalleById(@RequestBody Long code) throws Exception{
        
    	List<PedidoDetalleResult> result;
    	result = reservaService.obtenerPedidoDetalleById(code);
    	if(result == null)
    		result = new ArrayList<>();
    	return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	/**
	 * Metodo controlador que recibe la peticion de la capa
	 * web para obtener informacion de toda la promocion de pago
	 * 
	 * @return PromocionPagoResult
	 * @throws Exception
	 */
	@RequestMapping(value = "/buscarpromocionpago", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<List<PromocionPagoResult>> buscarpromocionpago() throws Exception{
        
    	List<PromocionPagoResult> result;
    	result = reservaService.buscarpromocionpago();
    	if(result == null)
    		result = new ArrayList<>();
    	return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	/**
	 * Metodo controlador que recibe la peticion de la capa
	 * web para obtener informacion de toda la carta
	 * 
	 * @return CartaResult
	 * @throws Exception
	 */
	@RequestMapping(value = "/carta", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<List<CartaResult>> carta() throws Exception{
        
    	List<CartaResult> result;
    	result = reservaService.cartaTotal();
    	if(result == null)
    		result = new ArrayList<>();
    	return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	/**
	 * Metodo controlador que recibe la peticion de la capa
	 * web para obtener informacion del reparto
	 * 
	 * @param RepartoFilter
	 * @return RepartoResult
	 * @throws Exception
	 */
	@RequestMapping(value = "/buscarReparto", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<List<RepartoResult>> buscarReparto(@RequestBody RepartoFilter repartoFilter) throws Exception{
        
    	List<RepartoResult> result;
    	result = reservaService.buscarReparto(repartoFilter);
    	if(result == null)
    		result = new ArrayList<>();
    	return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	/**
	 * Metodo controlador elimina el pedido Proyectado
	 * 
	 * @param PedidoProyectadoViewModel
	 * @return NotificacionViewModel
	 * @throws Exception
	 */
	@RequestMapping(value = "/eliminarPedidoProyectado", method = RequestMethod.POST)
	public @ResponseBody NotificacionViewModel eliminarPedidoProyectado(@RequestBody PedidoProyectadoViewModel pedidoproyectadoModel) throws Exception{
		
		NotificacionViewModel dto = reservaService.eliminarPedidoProyectado(pedidoproyectadoModel);
		return dto;
	}
	
	/**
	 * Metodo controlador que busca el pedido Proyectado
	 * 
	 * @param PedidoProyectadoViewModel
	 * @return PedidoProyectadoResult
	 * @throws Exception
	 */
	@RequestMapping(value = "/buscarPedidoProyectado", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<PedidoProyectadoResult>> buscarPedidoProyectado() 	throws Exception{
   	List<PedidoProyectadoResult> result;
    	result = reservaService.buscarPedidoProyectado();
   	if(result == null)
    		result = new ArrayList<>();
    	return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	/**
	 * Metodo controlador que busca el pedido Proyectado por distrito
	 * 
	 * @param PedidoProyectadoFilter
	 * @return PedidoProyectadoResult
	 * @throws Exception
	 */
	@RequestMapping(value = "/buscarPedidoProyectadoByDistrito", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<List<PedidoProyectadoResult>> buscarPedidoProyectadoByDistrito(@RequestBody PedidoProyectadoFilter 	descripcionlocal) 	throws 	Exception{        
    	List<PedidoProyectadoResult> result;
    	result = reservaService.buscarPedidoProyectadoByDistrito(descripcionlocal);
    	if(result == null)
    		result = new ArrayList<>();
    	return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	/**
	 * Metodo controlador que adiciona un pedido proyectado
	 * 
	 * @param PedidoProyectadoFilter
	 * @return PedidoProyectadoResult
	 * @throws Exception
	 */
	@RequestMapping(value = "/agregarPedidoProyectado", method = RequestMethod.POST)
	public @ResponseBody NotificacionViewModel agregarPedidoProyectado(@RequestBody PedidoProyectadoFilter pedidoProyectadoFilter) {
		
		NotificacionViewModel dto = reservaService.agregarPedidoProyectado(pedidoProyectadoFilter);
		return dto;
	}
		
	/**
	 * Metodo controlador que nos trae la informacion del local
	 * 
	 * @param PedidoProyectadoFilter
	 * @return LocalResult
	 * @throws Exception
	 */
	@RequestMapping(value = "/buscarLocales", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<LocalResult>> buscarLocal() throws Exception{
   	List<LocalResult> result;
    	result = reservaService.buscarLocal();
   	if(result == null)
    		result = new ArrayList<>();
    	return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
