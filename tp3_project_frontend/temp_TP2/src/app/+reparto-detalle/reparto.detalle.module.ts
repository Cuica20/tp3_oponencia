import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {
    ConfirmationService, ConfirmDialogModule, DialogModule, GMapModule, GrowlModule,
    InputMaskModule
} from "primeng/primeng";
import {repartoDetalleRouting} from "./reparto.detalle.routing";
import {RepartoDetalleComponent} from "./reparto.detalle.component";
import {DirectionsMapDirective} from "../map/googlr-map.directive";
import {AgmCoreModule} from "angular2-google-maps/core";

@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        GrowlModule,
        DialogModule,
        ConfirmDialogModule,
        InputMaskModule,
        GMapModule,
        repartoDetalleRouting
    ],
    declarations: [RepartoDetalleComponent,DirectionsMapDirective],
    providers: [ConfirmationService]
})
export class RepartoDetalleModule { }