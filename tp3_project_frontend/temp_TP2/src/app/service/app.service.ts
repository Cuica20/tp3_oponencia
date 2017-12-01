import {Injectable} from "@angular/core";
import {Headers, Http} from "@angular/http";
import {ReservaResult} from "../dto/reservaResult";
import {Observable} from "rxjs/Observable";
import {ReservaFilter} from "../dto/ReservaFilter";
import {environment} from "../../environments/environment";
import {Reserva} from "../dto/Reserva";
import {NotificacionResult} from "../dto/notificacionresult";
import {Cliente} from "../dto/Cliente";
import {Mesa} from "../dto/Mesa";
import {PedidoResult} from "../dto/PedidoResult";
import {DeliveryResult} from "../dto/DeliveryResult";
import {PedidoDetalle} from "../dto/PedidoDetalle";
import {PromocionPagoResult} from "../dto/PromocionPagoResult";
import {CartaResult} from "../dto/CartaResult";
import {RepartoFilter} from "../dto/RepartoFilter";
import {RepartoResult} from "../dto/RepartoResult";
import {Abastecimiento} from "../dto/Abastecimiento";
import {AbastecimientoFilter} from "../dto/AbastecimientoFilter";
import {AbastecimientoResult} from "../dto/AbastecimientoResult";

import {LocalFilter} from "../dto/LocalFilter";
import {LocalResult} from "../dto/LocalResult";
/**
 * Created by javier on 7/16/17.
 */


@Injectable()
export class AppService {

    localhost:  String = environment.backend;
    port: String = environment.port;

    private domainserver:string = 'http://localhost:8080';

    constructor(private http: Http) {};

    public getReservaByCode(code: any){

        let url = 'http://'+this.localhost+':'+ this.port +'/reserva/reservaByCode';
        let header = new Headers({'Content-Type': 'application/json'});

        return this.http.post(url, JSON.stringify(code), {headers: header})
            .map(res => <Reserva> res.json())
            .catch(this.handleError);
    }

    /*J*/
    getLocalesService(filter: LocalFilter){
        let url = 'http://'+this.localhost+':'+ this.port +'/reserva/buscarLocales';
        let header = new Headers({'Content-Type': 'application/json'});

        return this.http.post(url, JSON.stringify(filter), {headers: header})
            .map(res => <LocalResult[]> res.json())
            .catch(this.handleError);
    }

    getAbastecimientoByFiltrosService(code: any) {
        let url = 'http://'+this.localhost+':'+ this.port +'/reserva/buscarPedidoProyectado';
        let header = new Headers({'Content-Type': 'application/json'});

        return this.http.post(url, JSON.stringify(code), {headers: header})
            .map(res => <Abastecimiento[]> res.json())
            .catch(this.handleError);
    }

    getAbastecimientoAgregarService(filter: AbastecimientoFilter){
        let url = 'http://'+this.localhost+':'+ this.port +'/reserva/agregarPedidoProyectado';
        let header = new Headers({'Content-Type': 'application/json'});

        return this.http.post(url, JSON.stringify(filter), {headers: header})
            .map(res => <AbastecimientoResult[]> res.json())
            .catch(this.handleError);        
    }

    getAbastecimientoByFiltrosServiceDistrito(filter: AbastecimientoFilter) {
        let url = 'http://'+this.localhost+':'+ this.port +'/reserva/buscarPedidoProyectadoByDistrito';
        let header = new Headers({'Content-Type': 'application/json'});

        return this.http.post(url, JSON.stringify(filter), {headers: header})
            .map(res => <AbastecimientoResult[]> res.json())
            .catch(this.handleError);
    }
    /*J*/


    public obtenerPedidoDetalleById(code: any){

        let url = 'http://'+this.localhost+':'+ this.port +'/reserva/obtenerPedidoDetalleById';
        let header = new Headers({'Content-Type': 'application/json'});

        return this.http.post(url, JSON.stringify(code), {headers: header})
            .map(res => <PedidoDetalle[]> res.json())
            .catch(this.handleError);
    }

    getReservaConsulta(filter: ReservaFilter) {
        let url = 'http://'+this.localhost+':'+ this.port +'/reserva/buscarReserva';
        let header = new Headers({'Content-Type': 'application/json'});

        return this.http.post(url, JSON.stringify(filter), {headers: header})
            .map(res => <ReservaResult[]> res.json())
            .catch(this.handleError);
    }

    getReparto(filter: RepartoFilter) {
        let url = 'http://'+this.localhost+':'+ this.port +'/reserva/buscarReparto';
        let header = new Headers({'Content-Type': 'application/json'});

        return this.http.post(url, JSON.stringify(filter), {headers: header})
            .map(res => <RepartoResult[]> res.json())
            .catch(this.handleError);
    }

    getTodoPedido(all: any) {
        let url = 'http://'+this.localhost+':'+ this.port +'/reserva/buscarTodoPedido';
        let header = new Headers({'Content-Type': 'application/json'});

        return this.http.post(url, JSON.stringify(all), {headers: header})
            .map(res => <PedidoResult[]> res.json())
            .catch(this.handleError);
    }

    getTodoDelivery(all: any) {
        let url = 'http://'+this.localhost+':'+ this.port +'/reserva/buscarTodoDelivery';
        let header = new Headers({'Content-Type': 'application/json'});

        return this.http.post(url, JSON.stringify(all), {headers: header})
            .map(res => <DeliveryResult[]> res.json())
            .catch(this.handleError);
    }

    getPromocionPago() {
        let url = 'http://'+this.localhost+':'+ this.port +'/reserva/buscarpromocionpago';
        let header = new Headers({'Content-Type': 'application/json'});

        return this.http.post(url, {headers: header})
            .map(res => <PromocionPagoResult[]> res.json())
            .catch(this.handleError);
    }

    getCarta() {
        let url = 'http://'+this.localhost+':'+ this.port +'/reserva/carta';
        let header = new Headers({'Content-Type': 'application/json'});

        return this.http.post(url, {headers: header})
            .map(res => <CartaResult[]> res.json())
            .catch(this.handleError);
    }

    getDisponibilidadMesas(data: any) {
        let url = 'http://'+this.localhost+':'+ this.port +'/reserva/getDisponibilidadMesas';
        let header = new Headers({'Content-Type': 'application/json'});

        return this.http.post(url, JSON.stringify(data), {headers: header})
            .map(res => <Mesa[]> res.json())
            .catch(this.handleError);
    }

    getMesaDisponibleByDateHour(data: Reserva) {
        let url = 'http://'+this.localhost+':'+ this.port +'/reserva/getMesaDisponibleByDateHour';
        let header = new Headers({'Content-Type': 'application/json'});

        return this.http.post(url, JSON.stringify(data), {headers: header})
            .map(res => <Mesa[]> res.json())
            .catch(this.handleError);
    }

    actualizarReserva(reserva: Reserva) {

        let url = 'http://'+this.localhost+':'+ this.port +'/reserva/actualizarReserva';
        let header = new Headers({'Content-Type': 'application/json'});

        return this.http.post(url, JSON.stringify(reserva), {headers: header})
            .map(res => <NotificacionResult> res.json())
            .catch(this.handleError);
    }

    registrarReserva(reserva: Reserva) {

        let url = 'http://'+this.localhost+':'+ this.port +'/reserva/registrarReserva';
        let header = new Headers({'Content-Type': 'application/json'});

        return this.http.post(url, JSON.stringify(reserva), {headers: header})
            .map(res => <NotificacionResult> res.json())
            .catch(this.handleError);
    }

    obtenerInformacionClienteByDNI(dni: number) {

        let url = 'http://'+this.localhost+':'+ this.port +'/reserva/obtenerInformacionClienteByDNI';
        let header = new Headers({'Content-Type': 'application/json'});

        return this.http.post(url, JSON.stringify(dni), {headers: header})
            .map(res => <Cliente> res.json())
            .catch(this.handleError);

    }

    verDisponibilidadMesa(cod_mesa: number) {

        let url = 'http://'+this.localhost+':'+ this.port +'/reserva/verDisponibilidadMesa';
        let header = new Headers({'Content-Type': 'application/json'});

        return this.http.post(url, JSON.stringify(cod_mesa), {headers: header})
            .map(res => <Mesa> res.json())
            .catch(this.handleError);

    }

    obtenerUltimaReservaClienteByDNI(dni: number) {

        let url = 'http://'+this.localhost+':'+ this.port +'/reserva/obtenerUltimaReservaClienteByDNI';
        let header = new Headers({'Content-Type': 'application/json'});

        return this.http.post(url, JSON.stringify(dni), {headers: header})
            .map(res => <Mesa> res.json())
            .catch(this.handleError);

    }


    anularReserva(dataItem: any){
        let url = 'http://'+this.localhost+':'+ this.port +'/reserva/anularReserva';
        let header = new Headers({'Content-Type': 'application/json'});

        return this.http.post(url, JSON.stringify(dataItem), {headers: header})
            .map(res => <NotificacionResult> res.json())
            .catch(this.handleError);
    }

    private handleError(error: any): Observable<string> {
        return Observable.throw(error.json() || 'Server error');
    }


}
