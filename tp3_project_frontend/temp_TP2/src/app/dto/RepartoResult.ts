
export class RepartoResult {

    constructor(
        public cod_reparto?: number,
        public direccion_reparto?: string,
        public zona_reparto?: string,
        public horainicio_reparto?: string,
        public horaasignado_reparto?: string,
        public estado_reparto?: string,
        public cod_carta?: string,
        public nombres_repartidor?: string,

        public dest_latitude_reparto?: string,
        public dest_longitud_reparto?: string,
        public orig_latitude_reparto?: string,
        public orig_longitud_reparto?: string

    ) {
    }

}