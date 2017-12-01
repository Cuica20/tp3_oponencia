/**
 * Created by javier on 7/22/17.
 */
import { Routes, RouterModule } from '@angular/router';
import {ModuleWithProviders} from "@angular/core";
import {RecInmDashboard} from "./recepcion.inmediata";

export const RecInmdashboardRoutes: Routes = [
    {
        path: '',
        component: RecInmDashboard,
        data: {
            pageTitle: 'Recepcion Inmediata'
        }
    }
];

export const RecInmdashboardRouting: ModuleWithProviders = RouterModule.forChild(RecInmdashboardRoutes);
