import {RouterModule, Routes} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";
import {StreetViewComponent} from "./streetview.component";

export const streetViewRoutes: Routes = [
    {
        path: '',
        component: StreetViewComponent,
        data: {
            pageTitle: 'StreetView'
        }
    }
];

export const streetViewRouting: ModuleWithProviders = RouterModule.forChild(streetViewRoutes);