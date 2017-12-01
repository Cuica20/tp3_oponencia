import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {ConfirmationService, ConfirmDialogModule, DialogModule, GrowlModule, InputMaskModule} from "primeng/primeng";
import {verrutasRouting} from "./verruta.routing";
import {VerRutaComponent} from "./ver.ruta.component";

@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        GrowlModule,
        DialogModule,
        ConfirmDialogModule,
        InputMaskModule,
        verrutasRouting
    ],
    declarations: [VerRutaComponent],
    providers: [ConfirmationService]
})
export class VerRutaModule { }