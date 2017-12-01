import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {ConfirmDialogModule, GrowlModule} from "primeng/primeng";
import {FormsModule} from "@angular/forms";
import {AppService} from "../service/app.service";
import {PromocionPago} from "./promocionpago.component";
import {promocionPagoRouting} from "./promocionpago.routing";

@NgModule({
    imports: [
        CommonModule,
        GrowlModule,
        FormsModule,
        ConfirmDialogModule,
        promocionPagoRouting
    ],
    declarations: [PromocionPago],
    providers: [AppService]
})
export class PromocionPagoModule { }