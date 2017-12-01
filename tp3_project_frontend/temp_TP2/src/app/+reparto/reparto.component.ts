
import {AppService} from "../service/app.service";
import {Component, ElementRef, NgZone, OnInit, ViewChild} from "@angular/core";
import {Router} from "@angular/router";
import {Observable} from "rxjs/Observable";
import {RepartoResult} from "../dto/RepartoResult";
import {} from '@types/googlemaps';
import {RepartoFilter} from "../dto/RepartoFilter";
import {Location} from "@angular/common";

declare var google: any;

@Component({
    selector: 'app-reparto',
    templateUrl: './reparto.component.html',
    styleUrls: ['./reparto.component.scss'],
    providers: [AppService]
})
export class RepartoComponent implements OnInit{

    repartoResult: RepartoResult[] =[];
    repartofilter: RepartoFilter = new RepartoFilter();

    constructor(private appService: AppService, private location: Location,
                private router: Router){

    }

    ngOnInit(): void {
        this.getReparto();
        Observable.interval(30000).subscribe(x => {
            console.log('Ejecutandose cada 5 minutos');
            this.getReparto();
        });

    }

    getReparto(){
        this.appService.getReparto(this.repartofilter).subscribe(
            (data:any) => {
                debugger;
                this.repartoResult = data;
            },
            error => {
                /*this.msgs.push({severity:'error', summary:'Error Message', detail:error.error});*/
            }
        );
    }

    irDetalle(data: RepartoResult){

        sessionStorage.setItem('isNew',JSON.stringify(false));
        sessionStorage.setItem('idReparto',JSON.stringify(data));
        this.router.navigate(['/repartodetalle']);
    }


}