import {RouterModule, Routes} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";
import {RepartoComponent} from "./reparto.component";

export const repartoRoutes: Routes = [
    {
        path: '',
        component: RepartoComponent,
        data: {
            pageTitle: 'Reparto'
        }
    }
];

export const repartoRouting: ModuleWithProviders = RouterModule.forChild(repartoRoutes);
