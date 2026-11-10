package consulado.notificaciones;

import consulado.comun.Mensajes;
import consulado.solicitud.ObservadorDeSolicitud;
import consulado.solicitud.Solicitud;

public class CitasObservador implements ObservadorDeSolicitud {
    @Override
    public void alCancelar(Solicitud s) {
        System.out.println("  [CitasObservador] " + Mensajes.CITAS_CANCELACION.formatted(s.getViajero()));
    }
}
