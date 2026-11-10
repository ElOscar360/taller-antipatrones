package consulado.tramite;

import consulado.comun.Mensajes;

public class RepositorioDeExpedientes {
    public void guardar(String nombre) {
        System.out.println("[RepositorioDeExpedientes] " + Mensajes.EXPEDIENTE.formatted(nombre));
    }
}
