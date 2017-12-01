import {Component, OnInit} from "@angular/core";
import {AppService} from "../service/app.service";
import {Router} from "@angular/router";

@Component({
    selector: 'app-recepinmediata',
    templateUrl: './recepinmediata.component.html',
    styleUrls: ['./recepinmediata.component.scss'],
    providers: [AppService]
})
export class RecepcionInmediataComponent implements OnInit{

    constructor(private appService: AppService,
                private router: Router){

    }

    ngOnInit(): void {

    }

}