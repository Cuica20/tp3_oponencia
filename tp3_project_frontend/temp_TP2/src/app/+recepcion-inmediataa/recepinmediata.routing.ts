import {RouterModule, Routes} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";
import {RecepcionInmediataComponent} from "./recepinmediata.component";

export const recepcionInmediataRoutes: Routes = [
    {
        path: '',
        component: RecepcionInmediataComponent,
        data: {
            pageTitle: 'RecepcionInmediata'
        }
    }
];

export const recepcionInmediataRouting: ModuleWithProviders = RouterModule.forChild(recepcionInmediataRoutes);
