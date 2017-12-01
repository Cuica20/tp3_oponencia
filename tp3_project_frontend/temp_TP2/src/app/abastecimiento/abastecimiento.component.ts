import { Component, OnInit ,TemplateRef } from '@angular/core';
import {AppService} from "../service/app.service";
import {ReservaResult} from "../dto/reservaResult";
import {PedidoResult} from "../dto/PedidoResult";
import {DeliveryResult} from "../dto/DeliveryResult";
import {Router} from "@angular/router";
import {AbastecimientoResult} from "../dto/AbastecimientoResult";
import {AbastecimientoFilter} from "../dto/AbastecimientoFilter";
import {CalendarModule} from 'primeng/primeng';
// import {CalendarModule} from "../primeng";
// import {DatePickerModule} from 'ng2-datepicker-bootstrap';
//import { BsModalService } from 'ngx-bootstrap/modal';
import { BsModalRef, BsModalService } from 'ngx-bootstrap/modal';
import {Observable} from 'rxjs/Rx';
import {de} from "ngx-bootstrap/locale";
import {ConfirmationService, Message} from "primeng/primeng";
import {LocalFilter} from "../dto/LocalFilter";
import {LocalResult} from "../dto/LocalResult";
import { Input } from '@angular/core/src/metadata/directives';

@Component({
  selector: 'app-abastecimiento',
  templateUrl: './abastecimiento.component.html',
  styleUrls: ['./abastecimiento.component.scss'],
  providers: [AppService]
})


export class AbastecimientoComponent implements OnInit {

  abastecimientoFilter: AbastecimientoFilter = new AbastecimientoFilter();
  public abastecimientoResult: AbastecimientoResult[] = [];
  public localglobal : String;
  public localglobal2 : String;

  localfilter: LocalFilter = new LocalFilter();
  public localresult: LocalFilter[] = [];
  public localresult2: LocalFilter[] = [];
  //@Input() dataFromParent: string;

  public modalRef: BsModalRef; // {1}
  msgs: Message[] = [];
  constructor(private appService: AppService,private modalService: BsModalService, private router: Router) { }
    
  //Agregar Modal
  public openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template); // {3}
    this.buscarlocalesmodal();
  }
  

  //Eliminar Modal
  public openModal2(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template); // {3}
    console.log(template);
  }

  ngOnInit() {
    this.localglobal = "Pardos Chicken Todos";
    this.buscarlocales();
    this.buscarpedidoproyectado();
  }

  BuscarTodo(newHero: string, newHero2:string){
    console.log(newHero);
    console.log(newHero2);
    console.log(this.localglobal);
    console.log("Buscar Todo");    

    if(this.localglobal == "Pardos Chicken Todos"){
        this.buscarpedidoproyectado();
    }
    else{  
      this.buscarpedidoproyectadobydistrito(this.localglobal,newHero,newHero2 );
    }
  }
  // $event.target.value

  onGetFechaReserva(evento){
      console.log(evento);
  }

  //Evento del Cambio de Local para Filtrar
  headingChanged(evento){
    this.localglobal = evento;
    console.log(evento);
  //   if(evento=="Pardos Chicken Todos"){
  //     this.buscarpedidoproyectado();
  // }
  // else{  
  //   this.buscarpedidoproyectadobydistrito(evento);
  // }
  }

  headingChanged2(evento){
    this.localglobal2 = evento;
  //   if(evento=="Pardos Chicken Todos"){
  //     this.buscarpedidoproyectado();
  // }
  // else{  
  //   this.buscarpedidoproyectadobydistrito(evento);
  // }
  }

  //Función de Buscar Pedidos por Local
  buscarpedidoproyectadobydistrito(descripcion, fecha1, fecha2){    
    console.log("buscar buscarpedidoproyectadobydistrito");
    this.abastecimientoFilter.descripcionlocal=descripcion;
    this.abastecimientoFilter.fechainicio=fecha1;
    this.abastecimientoFilter.fechafinal=fecha2;
    this.appService.getAbastecimientoByFiltrosServiceDistrito(this.abastecimientoFilter).subscribe(
      (data: any) => {
        console.log(data);
        // console.log(data.data);
          this.abastecimientoResult = data;
      },
      error => {
          this.msgs.push({severity:'error', summary:'No existen datos para los filtros ingresados', detail:error.error});
      }
      );
  }

  
  //Función para Eliminar un pedidoproyectado
  eliminarpedidoproyectado(evento){
    
console.log(evento);
  }

  
  //Función de Agregar Pedido
  agregarpedidoproyectado(fecha,nombre,descripcion,cantidad,precio){
    
    console.log("Agregar Pedido Proyectado");
    console.log(fecha);
    console.log(nombre);
    console.log(descripcion);

    // var number1 :number  = cantidad;
    // var number2 : number = precio;

    this.abastecimientoFilter.fecha = fecha;
    this.abastecimientoFilter.estado = "Enviar";
    this.abastecimientoFilter.nombre = nombre;
    this.abastecimientoFilter.descripcion = descripcion;
    this.abastecimientoFilter.cantidad = cantidad;
    this.abastecimientoFilter.precio = precio;

    this.abastecimientoFilter.costo = 24;
    this.abastecimientoFilter.flat = 1;
    this.abastecimientoFilter.idLocal = 1;//this.localglobal2;
    this.abastecimientoFilter.color = "#7dd97d";


    this.appService.getAbastecimientoAgregarService(this.abastecimientoFilter).subscribe(
      (data: any) => {
        console.log(data);
          this.abastecimientoResult = data;
      },
      error => {
          this.msgs.push({severity:'error', summary:'No existen datos para los filtros ingresados', detail:error.error});
      }
    );
  };  

  //Función de Buscar Locales generales al inicio de carga de data del Colmbo Locales
  buscarlocales(){
    console.log("buscar localespedidos");
    this.appService.getLocalesService(this.localfilter).subscribe(
      (data: any) => {
        console.log(data);
          this.localresult = data;
      },
      error => {
          this.msgs.push({severity:'error', summary:'No existen datos para los filtros ingresados', detail:error.error});
      }
    );
  };
  buscarlocalesmodal(){
    console.log("buscar localespedidos");
    this.appService.getLocalesService(this.localfilter).subscribe(
      (data: any) => {
        console.log(data);
          this.localresult2 = data;
      },
      error => {
          this.msgs.push({severity:'error', summary:'No existen datos para los filtros ingresados', detail:error.error});
      }
    );
  };

  //Función para Listar los pedido Proyectados Generl de Todos
  buscarpedidoproyectado(){
    // console.log(thisheading.nombre_local);
    console.log("buscar pedidoproyectado");
    this.appService.getAbastecimientoByFiltrosService(this.abastecimientoFilter).subscribe(
      (data: any) => {
        console.log(data);
        // console.log(data.data);
          this.abastecimientoResult = data;
      },
      error => {
          this.msgs.push({severity:'error', summary:'No existen datos para los filtros ingresados', detail:error.error});
      }
      );
    // this.abastecimientoResult =
    // [
    //   {
    //    "codigo_pedidopro":'PE000001',
    //    "fecha_pedidopro":'a',
    //    "nombre_local":'SantiagodeSurco',
    //    "descripcion_estado":'Enviar',
    //    "nombre_pedidopro":'Col Morada',
    //    "descripcion_pedidopro":'Congelada',
    //    "cantidad_pedidopro":1,
    //    "precio_pedidopro":2,
    //    "costo_pedidopro":2,
    //   },{
    //     "codigo_pedidopro":'PE000001',
    //     "fecha_pedidopro":'a',
    //     "nombre_local":'SantiagodeSurco',
    //     "descripcion_estado":'Enviar',
    //     "nombre_pedidopro":'Col Morada',
    //     "descripcion_pedidopro":'Congelada',
    //     "cantidad_pedidopro":1,
    //     "precio_pedidopro":2,
    //     "costo_pedidopro":2,
    //    }     
    //  ]
    //this.appService.getAbastecimientoByFiltrosService(code).subscribe(
      // (data: Abastecimiento) => {
      //     debugger;
      //     // this.reservaResult = data;
      //     // this.reservaResult.cod_mesa_anterior = data.cod_mesa;
      //     // this.getMesaDisponibleByDateHour(this.reservaResult);
      //     /*this.getMesaDisponibles(this.reservaResult.dni);*/
      // },
      // error => {
      //     /*this.msgs.push({severity:'error', summary:'Error Message', detail:error.error});*/
      // }
}




}
