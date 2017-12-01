import {Component, OnInit} from "@angular/core";
import {AppService} from "../service/app.service";
import {Router} from "@angular/router";
/**
 * Created by javier on 7/19/17.
 */
import {Observable} from 'rxjs/Rx';
import {de} from "ngx-bootstrap/locale";
import {PedidoResult} from "../dto/PedidoResult";

@Component({
    selector: 'app-dashbaord',
    templateUrl: './recepcion.inmediata.html',
    styleUrls: ['./recepcion.inmediata.scss'],
    providers: [AppService]
})
export class RecInmDashboard implements OnInit{

    public promocionResult: PedidoResult[] = [];
  //  public deliveryResult: DeliveryResult[] = [];
    all: string = 'all';

    constructor(private appService: AppService, private router: Router){}

    ngOnInit(){
       /// this.getPedido();
       /// this.getDelivery();
        Observable.interval(30000).subscribe(x => {
            console.log('Ejecutandose cada 30 segundos');
         ///   this.getPedido();
          ///  this.getDelivery();
        });

    }


   /* getPedido(){
        this.appService.getTodoPedido(this.all).subscribe(
            (data:any) => {
                this.pedidoResult = data;
            },
            error => {
                //this.msgs.push({severity:'error', summary:'Error Message', detail:error.error});
            }
        );
    }
    getDelivery(){
        this.appService.getTodoDelivery(this.all).subscribe(
            (data:any) => {
                this.deliveryResult = data;
            },
            error => {
                //this.msgs.push({severity:'error', summary:'Error Message', detail:error.error});
            }
        );
    }

    idDetalleGoodleMap(data: DeliveryResult){
        debugger;
        sessionStorage.setItem('isDelivery',JSON.stringify(true));
        sessionStorage.setItem('idDetalleGoodleMap',JSON.stringify(data));
        this.router.navigate(['/dashboardDetalle']);
    }

    irDetallePedido(data: PedidoResult){
        debugger;
        sessionStorage.setItem('isDelivery',JSON.stringify(false));
        sessionStorage.setItem('idDetallePedido',JSON.stringify(data));
        this.router.navigate(['/dashboardDetalle']);

    }*/

}