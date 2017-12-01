/**
 * Created by griga on 7/11/16.
 */


import {Routes, RouterModule} from '@angular/router';
import {MainLayoutComponent} from "./shared/layout/app-layouts/main-layout.component";
import {AuthLayoutComponent} from "./shared/layout/app-layouts/auth-layout.component";
import {ModuleWithProviders} from "@angular/core";
import {InicioComponent} from "./+inicio/inicio.component";

export const routes: Routes = [
    {path: 'inicio', component: InicioComponent },
    {
        path: '',
        component: MainLayoutComponent,
        children: [
            {
                path: '', redirectTo: 'home', pathMatch: 'full'
            },
            {
                path: 'home',
                loadChildren: 'app/+home/home.module#HomeModule'
            },
            {
                path: 'menu',
                loadChildren: 'app/+menu/menu.module#MenuModule'
            },
            {
                path: 'pedido',
                loadChildren: 'app/+pedidos/pedido.module#PedidoModule'
            },
            {
                path: 'reserva',
                loadChildren: 'app/+reserva/reserva.module#ReservaModule'
            },
            {
                path: 'reservaConsulta',
                loadChildren: 'app/+reserva-consulta/reserva.consulta.module#ReservaConsultaModule'
            },
            {
                path: 'verDisponibilidadMesa',
                loadChildren: 'app/+disponibilidadMesa/verDisponibilidadMesa.module#VerDisponibilidadMesaModule'
            },
            {
                path: 'dashboard',
                loadChildren: 'app/+dashboard/dashboard.module#DashboardModule'
            },
            {
                path: 'dashboardDetalle',
                loadChildren: 'app/+dashboardDetalle/dashboard.detalle.module#DashboardDetalleModule'
            },
            {
                path: 'promocionpago',
                loadChildren: 'app/+promocionpago/promocionpago.module#PromocionPagoModule'
            },
            {
                path: 'reparto',
                loadChildren: 'app/+reparto/reparto.module#RepartoModule'
            },
            {
                path: 'repartodetalle',
                loadChildren: 'app/+reparto-detalle/reparto.detalle.module#RepartoDetalleModule'
            },
            {
                path: 'ruta',
                loadChildren: 'app/+verruta/verruta.module#VerRutaModule'
            },
            {
                path: 'abastecimiento',
                loadChildren: 'app/abastecimiento/abastecimiento.module#AbastecimientoModule'
            },
            {
                path: 'recepcioninmediata',
                loadChildren: 'app/+recepcion-inmediata/recepcion.inmediata.module#RecInmDashboardModule'
            },
            {
                path: 'recepcioninmediataa',
                loadChildren: 'app/+recepcion-inmediataa/recepinmediata.module#RecepcionInmediataModule'
            }
        ]
    },

];

export const routing: ModuleWithProviders = RouterModule.forRoot(routes, {useHash: true});
