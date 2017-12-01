
import {Component, OnInit} from "@angular/core";
import {AppService} from "../service/app.service";
import {Router} from "@angular/router";
import {RepartoResult} from "../dto/RepartoResult";
import {RepartoFilter} from "../dto/RepartoFilter";
import {DeliveryResult, Destination, Origin} from "../dto/DeliveryResult";
import {Location} from "@angular/common";

declare var google: any;

@Component({
    selector: 'app-reparto',
    templateUrl: './reparto.detalle.component.html',
    styleUrls: ['./reparto.detalle.component.scss'],
    providers: [AppService]
})
export class RepartoDetalleComponent implements OnInit {

    repartoResult: RepartoResult[]=[];
    repartofilter: RepartoFilter = new RepartoFilter();
    detalleReparto: RepartoResult = new RepartoResult();
    repartidorLocal: String;

    options: any;
    overlays: any[];
    dialogVisible: boolean;
    markerTitle: string;
    selectedPosition: any;
    infoWindow: any;
    draggable: boolean;
    isDelivery: boolean;
    //deliveryResult: DeliveryResult = new DeliveryResult();

    constructor(private appService: AppService, private location: Location,
                private router: Router) {


    }

    ngOnInit(): void {

        this.detalleReparto = JSON.parse(sessionStorage.getItem('idReparto'));

        this.repartofilter.cod_reparto = this.detalleReparto.cod_reparto;
        this.getReparto();
        debugger;


        if(this.detalleReparto.dest_latitude_reparto !=null){

            var x1 = Number(this.detalleReparto.dest_latitude_reparto);
            var y2 = Number(this.detalleReparto.dest_longitud_reparto);
            this.options = {
                center: {lat: x1, lng: y2},
                zoom: 17
            };

            this.initOverlays();

            this.infoWindow = new google.maps.InfoWindow();
        }

    }

    getReparto(){
        this.appService.getReparto(this.repartofilter).subscribe(
            (data:any) => {
                this.repartoResult = data;
                this.repartidorLocal = this.repartoResult[0].nombres_repartidor;
            },
            error => {
                /*this.msgs.push({severity:'error', summary:'Error Message', detail:error.error});*/
            }
        );
    }

    //---------------------
    handleMapClick(event) {
        this.dialogVisible = true;
        this.selectedPosition = event.latLng;
    }

    handleOverlayClick(event) {

        let isMarker = event.overlay.getTitle != undefined;

        if(isMarker) {
            let title = event.overlay.getTitle();
            this.infoWindow.setContent('' + title + '');
            this.infoWindow.open(event.map, event.overlay);
            event.map.setCenter(event.overlay.getPosition());


        }
        else {

        }
    }

    addMarker() {
        this.overlays.push(new google.maps.Marker({position:{lat: this.selectedPosition.lat(), lng: this.selectedPosition.lng()}, title:this.markerTitle, draggable: this.draggable}));
        this.markerTitle = null;
        this.dialogVisible = false;
    }

    handleDragEnd(event) {

    }

    initOverlays() {
        if(!this.overlays||!this.overlays.length) {
            var x1 = Number(this.detalleReparto.dest_latitude_reparto);
            var y2 = Number(this.detalleReparto.dest_longitud_reparto);

            this.overlays = [
                new google.maps.Marker({position: {lat: x1, lng: y2}, title:"Lima1"}),
                /*new google.maps.Polygon({paths: [
                    {lat: 36.9177, lng: 30.7854},{lat: 36.8851, lng: 30.7802},{lat: 36.8829, lng: 30.8111},{lat: 36.9177, lng: 30.8159}
                ], strokeOpacity: 0.5, strokeWeight: 1,fillColor: '#1976D2', fillOpacity: 0.35
                }),*/
                new google.maps.Circle({center: {lat: x1, lng: y2}, fillColor: '#1976D2', fillOpacity: 0.35, strokeWeight: 1, radius: 1500}),
                new google.maps.Polyline({path: [{lat: x1, lng: y2},{lat: x1, lng: y2}], geodesic: true, strokeColor: '#FF0000', strokeOpacity: 0.5, strokeWeight: 2})
            ];
        }
    }

    zoomIn(map) {
        map.setZoom(map.getZoom()+1);
    }

    zoomOut(map) {
        map.setZoom(map.getZoom()-1);
    }

    clear() {
        this.overlays = [];
    }

    streetView(){
        sessionStorage.setItem('isNew',JSON.stringify(false));
        sessionStorage.setItem('detalleReparto',JSON.stringify(this.detalleReparto));
        this.router.navigate(['/streetview']);
    }

    verruta(){
        sessionStorage.setItem('isNew',JSON.stringify(false));
        sessionStorage.setItem('detalleReparto',JSON.stringify(this.detalleReparto));
        this.router.navigate(['/ruta']);
    }
}