/**
 * J.
 */
export class AbastecimientoResult {
    constructor(
        public idPedidoProyectado: string,
        public fecha:              string,
        public estado:             string,
        public nombre:             string,
        public descripcion:        string,
        public cantidad:           number,
        public precio:             number,
        public costo:              number,
        public descripcionlocal:   string,
        public color:              string,
    ) {
    }
}