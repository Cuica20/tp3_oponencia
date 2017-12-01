import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {ConfirmDialogModule, GrowlModule} from "primeng/primeng";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {AppService} from "../service/app.service";
import {RepartoComponent} from "./reparto.component";
import {repartoRouting} from "./reparto.routing";
import {DirectionsMapDirective} from "../map/googlr-map.directive";
import {AgmCoreModule} from "angular2-google-maps/core";
import {BrowserModule} from "@angular/platform-browser";

@NgModule({
    imports: [
        CommonModule,
        GrowlModule,
        ConfirmDialogModule,
        FormsModule,
        ReactiveFormsModule,
        repartoRouting
    ],
    declarations: [RepartoComponent],
    providers: [AppService]
})
export class RepartoModule { }