import {RouterModule, Routes} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";
import {VerRutaComponent} from "./ver.ruta.component";

export const verrutaRoutes: Routes = [
    {
        path: '',
        component: VerRutaComponent,
        data: {
            pageTitle: 'Ruta'
        }
    }
];

export const verrutasRouting: ModuleWithProviders = RouterModule.forChild(verrutaRoutes);