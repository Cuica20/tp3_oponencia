import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {ConfirmationService, ConfirmDialogModule, DialogModule, GrowlModule, InputMaskModule} from "primeng/primeng";
import {streetViewRouting} from "./streetview.routing";
import {StreetViewComponent} from "./streetview.component";

@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        GrowlModule,
        DialogModule,
        ConfirmDialogModule,
        InputMaskModule,
        streetViewRouting
    ],
    declarations: [StreetViewComponent],
    providers: [ConfirmationService]
})
export class StreetViewModule { }