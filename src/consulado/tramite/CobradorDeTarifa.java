package consulado.tramite;

import consulado.comun.Mensajes;

public class CobradorDeTarifa {
    public void cobrar(String nombre, double precio) {
        System.out.println("[CobradorDeTarifa] " + Mensajes.COBRO.formatted(precio, nombre));
    }
}
