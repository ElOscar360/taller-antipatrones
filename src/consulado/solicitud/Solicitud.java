package consulado.solicitud;

import consulado.visas.TipoVisa;
import java.util.ArrayList;
import java.util.List;

/** Sujeto del Observer: cancela y avisa a quien esté suscrito, sin conocer a nadie. */
public class Solicitud {
    private final String viajero;
    private final TipoVisa tipo;
    private EstadoSolicitud estado = EstadoSolicitud.ACTIVA;
    private final List<ObservadorDeSolicitud> observadores = new ArrayList<>();

    public Solicitud(String viajero, TipoVisa tipo) {
        this.viajero = viajero;
        this.tipo = tipo;
    }

    public void agregarObservador(ObservadorDeSolicitud observador) {
        observadores.add(observador);
    }

    public void cancelar() {
        if (estado == EstadoSolicitud.CANCELADA) {
            return;
        }
        estado = EstadoSolicitud.CANCELADA;
        observadores.forEach(o -> o.alCancelar(this));
    }

    public String getViajero() { return viajero; }
    public TipoVisa getTipo() { return tipo; }
    public EstadoSolicitud getEstado() { return estado; }
}
