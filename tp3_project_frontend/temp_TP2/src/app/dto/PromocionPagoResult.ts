/**
 * Created by javier on 7/13/17.
 */

export class PromocionPagoResult {

    constructor(
        public id_promocionpago?: number,
        public estado_promocionpago?: string,
        public mesa_promocionpago?: string,
        public detalle_promocion?: string,
        public platos_promocion?: string

    ) {
    }

}