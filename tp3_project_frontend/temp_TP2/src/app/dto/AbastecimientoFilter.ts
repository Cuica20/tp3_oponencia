/**
 * J.
 */
export class AbastecimientoFilter {
    constructor(

        public fechainicio?: Date,/*Fecha Inicio*/
        public fechafinal?: Date,/*Fecha Fin*/
        public idLocal?: number,
        public descripcionlocal?: String,

        //Agregar Proyecto
        public fecha?: String,
        public estado?: String,
        public nombre?: String,
        public descripcion?: String,
        public cantidad?: number,
        public precio?: number,
        public costo?: number,
        public flat?: number,
        public idlocal?: number,
        public color?: String,
        


    ) {
    }
}