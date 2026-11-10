package consulado.tramite;

import consulado.comun.Mensajes;

public class NotificadorDeCorreo {
    public void avisarVisaEnCamino(String nombre) {
        System.out.println("[NotificadorDeCorreo] " + Mensajes.CORREO_VISA.formatted(nombre));
    }
}
