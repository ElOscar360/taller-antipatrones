package consulado.tramite;

/** Solo orquesta: no valida, no cobra, no guarda ni envía correos por su cuenta. */
public class TramitadorDeVisa {
    private final ValidadorDePasaporte validador;
    private final CobradorDeTarifa cobrador;
    private final RepositorioDeExpedientes repositorio;
    private final NotificadorDeCorreo notificador;

    public TramitadorDeVisa(ValidadorDePasaporte validador, CobradorDeTarifa cobrador,
                            RepositorioDeExpedientes repositorio, NotificadorDeCorreo notificador) {
        this.validador = validador;
        this.cobrador = cobrador;
        this.repositorio = repositorio;
        this.notificador = notificador;
    }

    public boolean tramitar(String nombre, String pasaporte, double precio) {
        if (!validador.esValido(pasaporte)) {
            return false;
        }
        cobrador.cobrar(nombre, precio);
        repositorio.guardar(nombre);
        notificador.avisarVisaEnCamino(nombre);
        return true;
    }
}
