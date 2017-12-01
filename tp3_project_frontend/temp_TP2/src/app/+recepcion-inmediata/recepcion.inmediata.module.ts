/**
 * Created by javier on 7/22/17.
 */
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {GrowlModule} from "primeng/primeng";
import {FormsModule} from "@angular/forms";
import {ConfirmDialogModule} from 'primeng/primeng';
import {AppService} from "../service/app.service";
import {RecInmdashboardRouting} from "./recepcion.inmediata.routing";
import {RecInmDashboard} from "./recepcion.inmediata";
  

@NgModule({
    imports: [
        CommonModule,
        GrowlModule,
        FormsModule,
        ConfirmDialogModule,
        RecInmdashboardRouting 
    ],
    declarations: [RecInmDashboard],
    providers: [AppService]
})
export class RecInmDashboardModule { }