import {RouterModule, Routes} from "@angular/router";
import {PromocionPago} from "./promocionpago.component";
import {ModuleWithProviders} from "@angular/core";

export const promocionPagoRoutes: Routes = [
    {
        path: '',
        component: PromocionPago,
        data: {
            pageTitle: 'Promoci\u00f3n de Pago'
        }
    }
];

export const promocionPagoRouting: ModuleWithProviders = RouterModule.forChild(promocionPagoRoutes);
