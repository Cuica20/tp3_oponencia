package com.springboot.repository.jdbc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.config.DateUtil;
import com.springboot.config.WhereParams;
import com.springboot.dto.ComandaDTO;
import com.springboot.model.CartaResult;
import com.springboot.model.ClienteViewModel;
import com.springboot.model.DeliveryResult;
import com.springboot.model.MesaViewModel;
import com.springboot.model.PedidoDetalleResult;
import com.springboot.model.PedidoProyectadoFilter;
import com.springboot.model.PedidoResult;
import com.springboot.model.PromocionPagoResult;
import com.springboot.model.RepartoFilter;
import com.springboot.model.RepartoResult;
import com.springboot.model.ReservaFilter;
import com.springboot.model.ReservaResult;
import com.springboot.model.ReservaViewModel;

import com.springboot.model.PedidoProyectadoResult;/*J*/
import com.springboot.model.LocalResult;/*J*/
import com.springboot.model.PedidoProyectadoViewModel; /*J*/

@Repository
public class ReservaJdbcRepository {
	
	@Autowired
    DataSource dataSource;

    private NamedParameterJdbcTemplate jdbcTemplate;
    
    private String getFechaInicio;
    private String getFechaFin;

    @PostConstruct
    public void init() {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

	public List<ReservaResult> searchReserva(ReservaFilter reservaFilter) {
		WhereParams params = new WhereParams();

        String sql = busquedaReservaQuery(reservaFilter, params);

        return jdbcTemplate.query(sql,
                params.getParams(), new BeanPropertyRowMapper<>(ReservaResult.class));
	}
	private String busquedaReservaQuery(ReservaFilter filterViewModel, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		getFechaInicio = DateUtil.format(new SimpleDateFormat("yyyy-MM-dd"), filterViewModel.getFechaInicio());
		getFechaFin = DateUtil.format(new SimpleDateFormat("yyyy-MM-dd"), filterViewModel.getFechaFin());

        sql.append(" SELECT ");
        sql.append(" re.idReserva AS cod_reserva, ");
        sql.append(" re.fecha AS fecha_reserva, ");
        sql.append(" re.tipo AS tipo_reserva, ");
        sql.append(" re.dni AS dni, ");
        sql.append(" re.motivo AS motivo, ");
        sql.append(" re.hora AS hora, ");
        sql.append(" me.idMesa AS cod_mesa, ");
        sql.append(" me.nombre AS nombre_mesa, ");
        sql.append(" re.comentario AS comentario, ");
        sql.append(" cl.nombre AS nombre_cliente, ");
        sql.append(" lo.descripcion AS nombre_local, ");
        sql.append(" re.cantidadPersonas AS cantidad_personas, ");
        sql.append(" cl.nombre AS nombre_cliente, ");        
        sql.append(" re.estado AS estado ");
        sql.append(" FROM reserva re ");
        sql.append(" LEFT JOIN cliente cl ON re.dni = cl.dni ");
        sql.append(" LEFT JOIN local lo ON lo.idLocal = re.idLocal ");
        sql.append(" LEFT JOIN mesa me ON me.idMesa = re.idMesa ");
        sql.append(" WHERE 1=1 ");

        sql.append(params.filter(" AND cl.apPaterno = :apPaterno ", filterViewModel.getAp_paterno()));
        if(filterViewModel.getFechaInicio() != null && filterViewModel.getFechaFin() != null){
        	sql.append(" AND re.fecha between '"+getFechaInicio+"' AND '"+getFechaFin+"' ");
        }
        
        sql.append(params.filter(" AND cl.nombre = :nombre ", filterViewModel.getNombre()));
        sql.append(params.filter(" AND re.tipo = :tipo ", filterViewModel.getTipo_reserva()));
        sql.append(params.filter(" AND lo.descripcion = :descripcion ", filterViewModel.getNombre_local()));

		return sql.toString();
	}

	public ClienteViewModel obtenerInformacionClienteByDNI(Long dni) {
		WhereParams params = new WhereParams();
		String sql = obtenerInformacionClienteByDNIQuery(dni, params);
		
		ClienteViewModel result=new ClienteViewModel();
		List<ClienteViewModel> listaCliente= jdbcTemplate.query(sql, params.getParams(),
				new BeanPropertyRowMapper<ClienteViewModel>(ClienteViewModel.class));
		if(listaCliente!=null && listaCliente.size()>0) {
			result=listaCliente.get(0);
		}
			
		return result;
	}

	private String obtenerInformacionClienteByDNIQuery(Long dni, WhereParams params) {
		
		StringBuilder sql = new StringBuilder();
		
		sql.append(" SELECT ");
        sql.append(" cl.dni AS dni, ");
        sql.append(" cl.nombre AS nombre, ");
        sql.append(" cl.apPaterno AS ap_paterno, ");
        sql.append(" cl.telefono AS telefono, ");
        sql.append(" cl.correo AS correo ");
        
		sql.append(" FROM cliente cl ");
	    sql.append(" WHERE 1=1 ");
	    sql.append(params.filter(" AND cl.dni = :dni ", dni));

		return sql.toString();
	}

	public MesaViewModel obtenerUltimaReservaClienteByDNI(Long dni) {
		WhereParams params = new WhereParams();
		String sql = obtenerUltimaReservaClienteByDNIQuery(dni, params);
		
		MesaViewModel result=new MesaViewModel();
		List<MesaViewModel> listaUltimaReservaCliente= jdbcTemplate.query(sql, params.getParams(),
				new BeanPropertyRowMapper<MesaViewModel>(MesaViewModel.class));
		if(listaUltimaReservaCliente!=null && listaUltimaReservaCliente.size()>0) {
			result=listaUltimaReservaCliente.get(0);
		}
			
		return result;
	}

	private String obtenerUltimaReservaClienteByDNIQuery(Long dni, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" SELECT ");
        sql.append(" me.nombrea AS nombre_mesa, ");
        sql.append(" me.idMesa AS cod_mesa ");
		sql.append(" FROM reserva re ");
		sql.append(" LEFT JOIN mesa me ON re.idMesa = me.idMesa ");
	    sql.append(" WHERE 1=1 ");
	    sql.append(params.filter(" AND re.dni = :dni ", dni));
	    
	    sql.append(" ORDER BY re.fecha DESC LIMIT 1 ");

		return sql.toString();
	}

	public List<MesaViewModel> getDisponibilidadMesas(Long dni) {
		WhereParams params = new WhereParams();

        String sql = getDisponibilidadMesasQuery(dni, params);

        return jdbcTemplate.query(sql,
                params.getParams(), new BeanPropertyRowMapper<>(MesaViewModel.class));
	}

	private String getDisponibilidadMesasQuery(Long dni, WhereParams params) {
		StringBuilder sql = new StringBuilder();

        sql.append(" SELECT ");
        sql.append(" re.idMesa AS cod_mesa, ");
        sql.append(" re.nombre AS nombre_mesa, ");
        sql.append(" re.disponibilidad AS disponibilidad, ");
        sql.append(" re.fecha AS fecha_mesa, ");
        sql.append(" re.hora AS hora_mesa ");
        sql.append(" FROM mesa re ");
        sql.append(" WHERE 1=1 ");

		return sql.toString();
	}

	public List<MesaViewModel> getMesaDisponibleByDateHour(ReservaViewModel reservaViewModel) {
		WhereParams params = new WhereParams();

        String sql = getMesaDisponibleByDateHourQuery(reservaViewModel, params);

        return jdbcTemplate.query(sql,
                params.getParams(), new BeanPropertyRowMapper<>(MesaViewModel.class));
	}

	private String getMesaDisponibleByDateHourQuery(ReservaViewModel reservaViewModel, WhereParams params) {
		StringBuilder sql = new StringBuilder();

        sql.append(" SELECT ");
        sql.append(" re.idMesa AS cod_mesa, ");
        sql.append(" re.nombre AS nombre_mesa, ");
        sql.append(" re.disponibilidad AS disponibilidad, ");
        sql.append(" re.fecha AS fecha_mesa, ");
        sql.append(" re.hora AS hora_mesa ");
        sql.append(" FROM mesa re ");
        sql.append(" WHERE 1=1 ");
        sql.append(params.filter(" AND re.fecha_mesa = :fecha_mesa ", reservaViewModel.getFecha_reserva()));
        sql.append(params.filter(" AND re.hora_mesa = :hora_mesa ", reservaViewModel.getHora()));

        sql.append(" Order by re.nombre_mesa asc ");
		return sql.toString();
	}

	public MesaViewModel verDisponibilidadMesa(Long cod_mesa) {
        
        WhereParams params = new WhereParams();
		String sql = verDisponibilidadMesaQuery(cod_mesa, params);
		
		MesaViewModel result=new MesaViewModel();
		List<MesaViewModel> listaUltimaReservaCliente= jdbcTemplate.query(sql, params.getParams(),
				new BeanPropertyRowMapper<MesaViewModel>(MesaViewModel.class));
		if(listaUltimaReservaCliente!=null && listaUltimaReservaCliente.size()>0) {
			result=listaUltimaReservaCliente.get(0);
		}
			
		return result;
	}

	private String verDisponibilidadMesaQuery(Long cod_mesa, WhereParams params) {
		StringBuilder sql = new StringBuilder();

        sql.append(" SELECT ");
        sql.append(" re.idMesa AS cod_mesa, ");
        sql.append(" re.nombre AS nombre_mesa, ");
        sql.append(" re.disponibilidad AS disponibilidad, ");
        sql.append(" re.fecha AS fecha_mesa, ");
        sql.append(" re.hora AS hora_mesa ");
        sql.append(" FROM mesa re ");
        sql.append(" WHERE 1=1 ");
		return sql.toString();
	}

	public List<PedidoResult> buscarTodoPedido() {
		WhereParams params = new WhereParams();

        String sql = buscarTodoPedidoQuery(params);

        return jdbcTemplate.query(sql,
                params.getParams(), new BeanPropertyRowMapper<>(PedidoResult.class));
	}

	private String buscarTodoPedidoQuery(WhereParams params) {
		
		StringBuilder sql = new StringBuilder();

        sql.append(" SELECT ");
        sql.append(" re.idPedido AS id_pedido, ");
        sql.append(" re.dni AS dni ");
        sql.append(" FROM pedido re ");
        sql.append(" WHERE 1=1 ");
        
		return sql.toString();
	}

	public List<DeliveryResult> buscarTodoDelivery() {
		WhereParams params = new WhereParams();

        String sql = buscarTodoDeliveryQuery(params);

        return jdbcTemplate.query(sql,
                params.getParams(), new BeanPropertyRowMapper<>(DeliveryResult.class));
	}

	/*J*/
	public List<PedidoProyectadoResult> agregarPedidoProyectado(PedidoProyectadoFilter descripcionlocal) {
		WhereParams params = new WhereParams();

        String sql = agregarPedidoProyectado(descripcionlocal, params);

        return jdbcTemplate.query(sql,
                params.getParams(), new BeanPropertyRowMapper<>(PedidoProyectadoResult.class));
	}
	
	private String agregarPedidoProyectado(PedidoProyectadoFilter descripcionlocal, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		

		sql.append("INSERT INTO ");
        sql.append("pedidoproyectado");
        sql.append(" (idPedidoProyectado,fecha,estado,nombre,descripcion,cantidad,precio,costo,flat,idLocal,color ");
        sql.append(") VALUES (13,'2017-11-22','Enviar','Lechuga Americana','Congelada',19.0,8.50,79.8,1,1,'#7dd97d'");
        
        sql.append(");");
		return sql.toString();
	}
	
	
	public List<PedidoProyectadoResult> buscarPedidoProyectadoByDistrito(PedidoProyectadoFilter descripcionlocal) {
		WhereParams params = new WhereParams();

        String sql = buscarPedidoProyectadoByDistrito(descripcionlocal, params);

        return jdbcTemplate.query(sql,
                params.getParams(), new BeanPropertyRowMapper<>(PedidoProyectadoResult.class));
	}

	private String buscarPedidoProyectadoByDistrito(PedidoProyectadoFilter descripcionlocal, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		
        sql.append(" SELECT ");
        sql.append(" PEPRO.idPedidoProyectado as idPedidoProyectado, PEPRO.fecha as fecha, PEPRO.estado as estado, PEPRO.nombre as nombre, PEPRO.descripcionlocal as descripcionlocal, PEPRO.cantidad as cantidad, ");
        sql.append(" PEPRO.precio as precio, PEPRO.costo as costo, LO.descripcion as descripcionlocal, PEPRO.color as color");
        sql.append(" FROM pedidoproyectado PEPRO LEFT JOIN local LO  ");
        sql.append(" ON PEPRO.idLocal = LO.idLocal ");
        sql.append(" WHERE PEPRO.flat = 1 ");
        sql.append(params.filter(" AND LO.descripcion = :descripcion ", descripcionlocal.getDescripcionlocal()));

		return sql.toString();
	}
		
	//
	/*public List<ReservaResult> searchReserva(ReservaFilter reservaFilter) {
		WhereParams params = new WhereParams();

        String sql = busquedaReservaQuery(reservaFilter, params);

        return jdbcTemplate.query(sql,
                params.getParams(), new BeanPropertyRowMapper<>(ReservaResult.class));
	}*/
	/*private String busquedaReservaQuery(ReservaFilter filterViewModel, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		getFechaInicio = DateUtil.format(new SimpleDateFormat("yyyy-MM-dd"), filterViewModel.getFechaInicio());
		getFechaFin = DateUtil.format(new SimpleDateFormat("yyyy-MM-dd"), filterViewModel.getFechaFin());

        sql.append(" SELECT ");
        sql.append(" re.cod_reserva AS cod_reserva, ");
        sql.append(" re.fecha_reserva AS fecha_reserva, ");
        sql.append(" re.tipo_reserva AS tipo_reserva, ");
        sql.append(" re.dni AS dni, ");
        sql.append(" re.motivo AS motivo, ");
        sql.append(" re.hora AS hora, ");
        sql.append(" me.cod_mesa AS cod_mesa, ");
        sql.append(" me.nombre_mesa AS nombre_mesa, ");
        sql.append(" re.comentario AS comentario, ");
        sql.append(" cl.nombre AS nombre_cliente, ");
        sql.append(" lo.nombre_local AS nombre_local, ");
        sql.append(" re.cantidad_personas AS cantidad_personas, ");
        sql.append(" cl.nombre AS nombre_cliente, ");        
        sql.append(" re.estado AS estado ");
        sql.append(" FROM reserva re ");
        sql.append(" LEFT JOIN cliente cl ON re.dni = cl.dni ");
        sql.append(" LEFT JOIN local lo ON lo.id_local = re.id_local ");
        sql.append(" LEFT JOIN mesa me ON me.cod_mesa = re.cod_mesa ");
        sql.append(" WHERE 1=1 ");

        sql.append(params.filter(" AND cl.ap_paterno = :ap_paterno ", filterViewModel.getAp_paterno()));
        if(filterViewModel.getFechaInicio() != null && filterViewModel.getFechaFin() != null){
        	sql.append(" AND re.fecha_reserva between '"+getFechaInicio+"' AND '"+getFechaFin+"' ");
        }
        
        sql.append(params.filter(" AND cl.nombre = :nombre ", filterViewModel.getNombre()));
        sql.append(params.filter(" AND re.tipo_reserva = :tipo_reserva ", filterViewModel.getTipo_reserva()));
        sql.append(params.filter(" AND lo.nombre_local = :nombre_local ", filterViewModel.getNombre_local()));

		return sql.toString();
	}*/
	//
	
	public List<PedidoProyectadoResult> buscarPedidoProyectado() {
		WhereParams params = new WhereParams();

        String sql = buscarTodoPedidoProyectado(params);

        return jdbcTemplate.query(sql,
                params.getParams(), new BeanPropertyRowMapper<>(PedidoProyectadoResult.class));
	}
	
	private String buscarTodoPedidoProyectado(WhereParams params) {
		StringBuilder sql = new StringBuilder();

        sql.append(" SELECT ");
        sql.append(" PEPRO.idPedidoProyectado as idPedidoProyectado, ");
        sql.append(" PEPRO.fecha as fecha, ");
        sql.append(" PEPRO.estado as estado, ");
        sql.append(" PEPRO.nombre as nombre, ");
        sql.append(" PEPRO.descripcion as descripcion, ");
        sql.append(" PEPRO.cantidad as cantidad, ");
        sql.append(" PEPRO.costo as costo, ");
        sql.append(" PEPRO.precio as precio, ");
        sql.append(" LO.descripcion as descripcionlocal, ");
        sql.append(" PEPRO.color as color ");
        sql.append(" FROM pedidoproyectado PEPRO LEFT JOIN local LO ON PEPRO.idLocal = LO.idLocal ");
        sql.append(" WHERE PEPRO.flat = 1 ");
        
		return sql.toString();
	}
	
	
	
	
	public List<LocalResult> buscarLocal() {
		WhereParams params = new WhereParams();

        String sql = buscarLocal(params);

        return jdbcTemplate.query(sql,
                params.getParams(), new BeanPropertyRowMapper<>(LocalResult.class));
	}

	private String buscarLocal(WhereParams params) {
		StringBuilder sql = new StringBuilder();

        sql.append(" SELECT ");
        sql.append(" idLocal as idLocal, descripcion as descripcion, direccion as direccion ");
        sql.append(" FROM local ");
        sql.append(" WHERE 1=1 ");
        
		return sql.toString();
	}
	
	
	/*J*/
	
	
	private String buscarTodoDeliveryQuery(WhereParams params) {
		StringBuilder sql = new StringBuilder();

        sql.append(" SELECT ");
        sql.append(" re.idDelivery AS id_deliv, ");
        sql.append(" re.latitud AS latitude, ");
        sql.append(" re.longitud AS longitud, ");
        sql.append(" re.dni AS dni, ");
        sql.append(" re.estado AS estado_deliv, ");
        sql.append(" re.fecha AS fecha_deliv, ");
        sql.append(" re.horaEstimada AS horaestimada_deliv, ");
        sql.append(" re.idCarta AS cod_carta_deliv ");
        
        
        sql.append(" FROM entrega re ");
        sql.append(" WHERE 1=1 ");
        
		return sql.toString();
	}

	public List<PedidoDetalleResult> obtenerPedidoDetalleById(Long code) {
		WhereParams params = new WhereParams();

        String sql = obtenerPedidoDetalleByIdQuery(code, params);

        return jdbcTemplate.query(sql,
                params.getParams(), new BeanPropertyRowMapper<>(PedidoDetalleResult.class));
	}

	private String obtenerPedidoDetalleByIdQuery(Long code, WhereParams params) {
		StringBuilder sql = new StringBuilder();

        sql.append(" SELECT ");
        sql.append(" re.idPedidoDetalle AS id_pedidetalle, ");
        sql.append(" re.idCarta AS cod_carta, ");
        sql.append(" re.idPedido AS id_pedido ");
        sql.append(" FROM pedidodetalle re ");
        sql.append(" WHERE 1=1 ");
        sql.append(params.filter(" AND re.idPedido = :idPedido ", code));
        
		return sql.toString();
	}

	public List<ComandaDTO> buscarComandaPendiente(String detalle1_promocion, String detalle2_promocion,
			String detalle3_promocion) {
		
		WhereParams params = new WhereParams();

        String sql = buscarComandaPendienteQuery(detalle1_promocion, detalle2_promocion,detalle3_promocion, params);

        return jdbcTemplate.query(sql,
                params.getParams(), new BeanPropertyRowMapper<>(ComandaDTO.class));
	}

	private String buscarComandaPendienteQuery(String detalle1_promocion, String detalle2_promocion,
			String detalle3_promocion, WhereParams params) {
		
		StringBuilder sql = new StringBuilder();

        sql.append(" select c.idComanda AS id_comanda, ");
        sql.append(" c.idMesa AS cod_mesa, ");
        sql.append(" c.nombreCamarero AS nombre_camarero, ");
        sql.append(" dcc.idCarta AS id_carta ");
        sql.append(" from comanda c INNER JOIN detallecartacomanda dcc ON c.idComanda = dcc.idComanda ");
        sql.append(" WHERE 1=1 ");
        sql.append(" AND c.sugerencia = 'Pendiente' ");
        sql.append(" AND dcc.idCarta in ('");
		sql.append(detalle1_promocion);
		sql.append("','");
		sql.append(detalle2_promocion);
		sql.append("','");
		sql.append(detalle3_promocion);
		sql.append("')");
        
		return sql.toString();
	}

	public List<PromocionPagoResult> buscarpromocionpago() {
		WhereParams params = new WhereParams();

        String sql = buscarpromocionpagoQuery(params);

        return jdbcTemplate.query(sql,
                params.getParams(), new BeanPropertyRowMapper<>(PromocionPagoResult.class));
	}

	private String buscarpromocionpagoQuery(WhereParams params) {
		StringBuilder sql = new StringBuilder();

        sql.append(" select p.idPromocionPago AS id_promocionpago, ");
        sql.append(" p.estado AS estado_promocionpago, ");
        sql.append(" dmp.idMesa AS mesa_promocionpago, ");
        sql.append(" pn.descripcion AS detalle_promocion, ");
        sql.append(" CONCAT(cb.parametroUno, ' ', cb.parametroDos, ', ', cb.parametroTres) AS platos_promocion ");
        
        sql.append(" from promocionpago p INNER JOIN detallemesapromocionpago dmp ON p.idPromocionPago = dmp.idPromocionPago inner join promocion pn on pn.idPromocion = p.idPromocion left join combopromocion cb ON cb.idPromocion=pn.idPromocion ");
        sql.append(" WHERE 1=1 ");
        sql.append(params.filter(" AND p.notificado = :notificado ", false));
        
		return sql.toString();
	}

	public List<CartaResult> cartaTotal() {
		WhereParams params = new WhereParams();

        String sql = cartaTotalQuery(params);

        return jdbcTemplate.query(sql,
                params.getParams(), new BeanPropertyRowMapper<>(CartaResult.class));
	}

	private String cartaTotalQuery(WhereParams params) {
		StringBuilder sql = new StringBuilder();

        sql.append(" select c.idCarta AS id_carta, ");
        sql.append(" c.nombre AS nombre_carta ");
        
        sql.append(" from carta c ");
        sql.append(" WHERE 1=1 order by idCarta ASC ");
        
		return sql.toString();
	}

	public List<RepartoResult> buscarReparto(RepartoFilter repartoFilter) {
		WhereParams params = new WhereParams();

        String sql = buscarRepartoQuery(repartoFilter,params);

        return jdbcTemplate.query(sql,
                params.getParams(), new BeanPropertyRowMapper<>(RepartoResult.class));
	}

	private String buscarRepartoQuery(RepartoFilter filterViewModel, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		//vendemas tlf=5149222
		Date currentDate = new Date();
		getFechaInicio = DateUtil.format(new SimpleDateFormat("yyyy-MM-dd"), currentDate);
		
        sql.append(" SELECT ");
        sql.append(" re.idReparto AS cod_reparto, ");
        sql.append(" re.direccion AS direccion_reparto, ");
        sql.append(" re.horaInicio AS horainicio_reparto, ");
        sql.append(" re.horaAsignado AS horaasignado_reparto, ");
        sql.append(" re.estado AS estado_reparto, ");
        
        sql.append(" re.destLatitud AS dest_latitude_reparto, ");
        sql.append(" re.destLongitud AS dest_longitud_reparto, ");
        sql.append(" re.origLatitud AS orig_latitude_reparto, ");
        sql.append(" re.origLongitud AS orig_longitud_reparto, ");
        //CARTA
        sql.append(" pd.idCarta AS cod_carta, ");
        //REPARTIDOR
        sql.append(" CONCAT(repa.nombre, ' ', repa.apellidos) AS nombres_repartidor ");
        sql.append(" FROM reparto re ");
        sql.append(" INNER JOIN pedido p ON re.idPedido = p.idPedido ");
        sql.append(" LEFT JOIN pedidodetalle pd ON p.idPedido = pd.idPedido ");
        sql.append(" LEFT JOIN repartidor repa ON re.idRepartidor = repa.idRepartidor ");
        sql.append(" WHERE 1=1 ");
        sql.append(params.filter(" AND re.idReparto = :idReparto ", filterViewModel.getCod_reparto()));
        sql.append(params.filter(" AND re.estado = :estado ", filterViewModel.getEstado_reparto()));
        sql.append(params.filter(" AND DATE(re.horaInicio) = :horaInicio ", getFechaInicio));

		return sql.toString();
	}

	
	

}
