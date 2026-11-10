package consulado.comun;

/** Todos los textos del dominio tienen nombre y viven en un solo lugar. */
public final class Mensajes {
    private Mensajes() { }

    public static final String PASAPORTE_INVALIDO = "Pasaporte invalido";
    public static final String COBRO = "Cobrando $%.2f a %s";
    public static final String EXPEDIENTE = "Guardando expediente de %s";
    public static final String CORREO_VISA = "Correo para %s: su visa va en camino";
    public static final String TIPO_DESCONOCIDO =
            "Tipo de visa desconocido: %d. Tipos validos: %s";
    public static final String EDAD_FUERA_DE_RANGO =
            "Edad %d fuera del rango permitido para la visa %s";
    public static final String VISA_APROBADA = "Visa %s aprobada";
    public static final String CORREO_CANCELACION = "Aviso de cancelación enviado a %s";
    public static final String CITAS_CANCELACION = "Cupo de %s liberado en la agenda";
    public static final String PAGOS_CANCELACION = "Reembolso procesado para %s";
}
