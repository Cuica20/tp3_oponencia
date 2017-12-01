

import {Component, OnInit} from "@angular/core";
import {AppService} from "../service/app.service";
import {RepartoResult} from "../dto/RepartoResult";

declare var google: any;

@Component({
    selector: 'app-verruta',
    templateUrl: './ver.ruta.component.html',
    providers: [AppService]
})
export class VerRutaComponent implements OnInit {

    km_label: String;
    minutes_label: String;

    detalleReparto: RepartoResult = new RepartoResult();

    constructor(){}

    ngOnInit(): void {

        this.detalleReparto = JSON.parse(sessionStorage.getItem('detalleReparto'));

        var x1 = Number(this.detalleReparto.dest_latitude_reparto);
        var y2 = Number(this.detalleReparto.dest_longitud_reparto);
        debugger;

        var directionsService = new google.maps.DirectionsService;
        var directionsDisplay = new google.maps.DirectionsRenderer;
        var map = new google.maps.Map(document.getElementById('map'), {
            zoom: 15,
            center: {lat: x1, lng: y2}
        });
        directionsDisplay.setMap(map);
        directionsDisplay.setPanel(document.getElementById('right-panel'));
        directionsDisplay.setOptions({
            polylineOptions: {
                strokeWeight: 8,
                strokeOpacity: 0.7,
                strokeColor:  '#00468c'
            }
        });

        var trafficLayer = new google.maps.TrafficLayer();
        trafficLayer.setMap(map);

        calculateAndDisplayRoute(directionsService, directionsDisplay);
        document.getElementById('mode').addEventListener('change', function() {
            calculateAndDisplayRoute(directionsService, directionsDisplay);
        });

        function calculateAndDisplayRoute(directionsService, directionsDisplay) {

            var selectedMode = (<HTMLInputElement>document.getElementById('mode')).value;



            directionsService.route({
                origin: {lat: -12.100417, lng: -77.001944},
                destination: {lat: x1, lng: y2},
                travelMode: google.maps.TravelMode[selectedMode]
            }, function(response, status) {

                let km = response.routes[0].legs[0].distance.text;
                let minutes = response.routes[0].legs[0].duration.text;

                var km_outputDiv = document.getElementById('km_outputDiv');
                var minutes_outputDiv = document.getElementById('minutes_outputDiv');
                km_outputDiv.innerHTML = 'Kilómetros: '+km;
                minutes_outputDiv.innerHTML = 'Minutos: '+minutes;

                if (status === 'OK') {
                    directionsDisplay.setDirections(response);
                } else {
                    window.alert('Directions request failed due to ' + status);
                }
            });
        }

    }

}