package consulado.legado;

/**
 * ANTIPATRÓN: Acoplamiento fuerte. La solicitud crea y conoce a cada servicio,
 * y alguien olvidó llamar a pagos.
 */
public class SolicitudAcoplada {
    private String estado = "ACTIVA";
    private CorreoServicio correo = new CorreoServicio();
    private CitasServicio citas = new CitasServicio();
    private PagosServicio pagos = new PagosServicio();

    public void cancelar() {
        estado = "CANCELADA";
        correo.avisarCancelacion();
        citas.liberarCupo();
        // ¡Se olvidó pagos.reembolsar()!
    }

    public String getEstado() {
        return estado;
    }

    public PagosServicio getPagos() {
        return pagos;
    }
}
