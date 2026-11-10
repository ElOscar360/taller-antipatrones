package consulado.tramite;

import consulado.comun.Mensajes;

public class ValidadorDePasaporte {
    private static final int LONGITUD_MINIMA = 6;

    public boolean esValido(String pasaporte) {
        boolean valido = pasaporte != null && pasaporte.length() >= LONGITUD_MINIMA;
        if (!valido) {
            System.out.println("[ValidadorDePasaporte] " + Mensajes.PASAPORTE_INVALIDO);
        }
        return valido;
    }
}
