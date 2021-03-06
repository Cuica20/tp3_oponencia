/**
 * Created by javier on 7/22/17.
 */
import { Routes, RouterModule } from '@angular/router';
import {ModuleWithProviders} from "@angular/core";
import {AbastecimientoComponent} from "./abastecimiento.component";

export const abastecimientodRoutes: Routes = [
    {
        path: '',
        component: AbastecimientoComponent,
        data: {
            pageTitle: 'Gesti\u00f3n de Atenci\u00f3n al Cliente'
        }
    }
];

export const abastecimientodRouting: ModuleWithProviders = RouterModule.forChild(abastecimientodRoutes);
