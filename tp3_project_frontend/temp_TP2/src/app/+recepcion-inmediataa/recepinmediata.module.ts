import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {ConfirmDialogModule, GrowlModule} from "primeng/primeng";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {AppService} from "../service/app.service";
import {recepcionInmediataRouting} from "./recepinmediata.routing";
import {RecepcionInmediataComponent} from "./recepinmediata.component";

@NgModule({
    imports: [
        CommonModule,
        GrowlModule,
        ConfirmDialogModule,
        FormsModule,
        ReactiveFormsModule,
        recepcionInmediataRouting
    ],
    declarations: [RecepcionInmediataComponent],
    providers: [AppService]
})
export class RecepcionInmediataModule { }