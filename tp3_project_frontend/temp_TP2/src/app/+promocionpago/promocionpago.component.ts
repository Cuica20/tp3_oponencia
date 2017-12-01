import {Component, OnInit} from "@angular/core";
import {AppService} from "../service/app.service";
import {Router} from "@angular/router";
import {Observable} from "rxjs/Observable";
import {PromocionPagoResult} from "../dto/PromocionPagoResult";
import {CartaResult} from "../dto/CartaResult";
import {Message} from "primeng/primeng";

@Component({
    selector: 'app-promocionpago',
    templateUrl: './promocionpago.component.html',
    styleUrls: ['./promocionpago.component.scss'],
    providers: [AppService]
})
export class PromocionPago implements OnInit{

    promocionpagoResult: PromocionPagoResult[] =[];
    cartaResult: CartaResult[] =[];
    msgs: Message[] = [];

    constructor(private appService: AppService, private router: Router){}

    ngOnInit(): void {
        this.getPromocionPago();
        this.getCarta();
        Observable.interval(30000).subscribe(x => {
            console.log('Ejecutandose cada 30 segundos');
            this.getPromocionPago();
        });
    }

    getPromocionPago(){
        this.appService.getPromocionPago().subscribe(
            (data:any) => {
                this.promocionpagoResult = data;
                this.msgs.push({
                    severity:'info',
                    summary:'Mensaje',
                    detail:'Existe la Promocion: '
                    +this.promocionpagoResult[0].detalle_promocion+' para la mesa: '
                    + this.promocionpagoResult[0].mesa_promocionpago+','
                    + this.promocionpagoResult[1].mesa_promocionpago+','
                    + this.promocionpagoResult[2].mesa_promocionpago
                });
            },
            error => {
                /*this.msgs.push({severity:'error', summary:'Error Message', detail:error.error});*/
            }
        );
    }
    getCarta(){
        this.appService.getCarta().subscribe(
            (data:any) => {
                this.cartaResult = data;
            },
            error => {
                /*this.msgs.push({severity:'error', summary:'Error Message', detail:error.error});*/
            }
        );
    }


}