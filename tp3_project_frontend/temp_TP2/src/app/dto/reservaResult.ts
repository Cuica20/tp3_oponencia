/**
 * Created by javier on 7/13/17.
 */

export class ReservaResult {

    constructor(
        public cod_reserva?: string,
        public dni?: string,
        public nombre?: string,
        public apellido?: string,
        public correo?: string,
        public fecha_reserva?: string,
        public nombre_local?: string,
        public hora?: string,
        public telefono?: string,
        public cantidad_personas?: string,
        public mesa?: string,
        public nombre_cliente?: string,
        public comentario?: string,
        public tipo_reserva?: string,
        public estado?: string
    ) {
    }

}