import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {AppService} from "../service/app.service";
import {abastecimientodRouting} from "./abastecimiento.routing";
import {AbastecimientoComponent} from "./abastecimiento.component";
import {ReservaComponent} from "./reserva.component";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {ConfirmDialogModule, ConfirmationService, GrowlModule, InputMaskModule, AccordionModule} from 'primeng/primeng';
import {DialogModule} from 'primeng/primeng';
import {SmartadminModule} from "../shared/smartadmin.module";
import {ButtonsModule} from "ngx-bootstrap";
import {HttpModule, JsonpModule} from "@angular/http";
import {SmartadminInputModule} from "../shared/forms/input/smartadmin-input.module";
import {SmartadminValidationModule} from "../shared/forms/validation/smartadmin-validation.module";
import {JqueryUiModule} from "../shared/ui/jquery-ui/jquery-ui.module";


@NgModule({
  imports: [
    CommonModule,
    GrowlModule,
    FormsModule,
    ConfirmDialogModule,
    abastecimientodRouting,
    DialogModule,
    InputMaskModule
  ],
  declarations: [AbastecimientoComponent],
  providers: [AppService]
})
export class AbastecimientoModule { }
