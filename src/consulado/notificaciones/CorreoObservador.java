package consulado.notificaciones;

import consulado.comun.Mensajes;
import consulado.solicitud.ObservadorDeSolicitud;
import consulado.solicitud.Solicitud;

public class CorreoObservador implements ObservadorDeSolicitud {
    @Override
    public void alCancelar(Solicitud s) {
        System.out.println("  [CorreoObservador] " + Mensajes.CORREO_CANCELACION.formatted(s.getViajero()));
    }
}
