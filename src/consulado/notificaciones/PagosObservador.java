package consulado.notificaciones;

import consulado.comun.Mensajes;
import consulado.solicitud.ObservadorDeSolicitud;
import consulado.solicitud.Solicitud;

public class PagosObservador implements ObservadorDeSolicitud {
    private int reembolsos = 0;

    @Override
    public void alCancelar(Solicitud s) {
        reembolsos++;
        System.out.println("  [PagosObservador] " + Mensajes.PAGOS_CANCELACION.formatted(s.getViajero()));
    }

    public int getReembolsos() { return reembolsos; }
}
