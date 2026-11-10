package consulado.solicitud;

/** Contrato que la solicitud conoce; no sabe quién lo implementa. */
public interface ObservadorDeSolicitud {
    void alCancelar(Solicitud solicitud);
}
