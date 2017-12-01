
import {Component, OnInit} from "@angular/core";
import {AppService} from "../service/app.service";

declare var google: any;

@Component({
    selector: 'app-streetview',
    templateUrl: './streetview.component.html',
    providers: [AppService]
})
export class StreetViewComponent implements OnInit {

    constructor(){}

    ngOnInit(): void {

            var fenway = {lat: 42.345573, lng: -71.098326};
            var map = new google.maps.Map(document.getElementById('streetview'), {
                center: fenway,
                zoom: 14
            });
            var panorama = new google.maps.StreetViewPanorama(
                document.getElementById('pano'), {
                    position: fenway,
                    pov: {
                        heading: 34,
                        pitch: 10
                    }
                });
            map.setStreetView(panorama);
        }

}