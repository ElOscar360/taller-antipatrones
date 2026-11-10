package consulado.visas;

public record ResultadoEvaluacion(boolean aprobada, String mensaje) {
    public static ResultadoEvaluacion aprobada(String mensaje) {
        return new ResultadoEvaluacion(true, mensaje);
    }

    public static ResultadoEvaluacion rechazada(String mensaje) {
        return new ResultadoEvaluacion(false, mensaje);
    }

    public String etiqueta() {
        return aprobada ? "APROBADA" : "RECHAZADA";
    }
}
