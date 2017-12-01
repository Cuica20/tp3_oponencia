import {RouterModule, Routes} from "@angular/router";
import {RepartoDetalleComponent} from "./reparto.detalle.component";
import {ModuleWithProviders} from "@angular/core";

export const repartoDetalleRoutes: Routes = [
    {
        path: '',
        component: RepartoDetalleComponent,
        data: {
            pageTitle: 'Reserva'
        }
    }
];

export const repartoDetalleRouting: ModuleWithProviders = RouterModule.forChild(repartoDetalleRoutes);