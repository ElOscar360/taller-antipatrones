package consulado.legado;

/** ANTIPATRÓN: Magic Numbers. ¿Qué es tipo 3? ¿Por qué 17 y 66? */
public class EvaluadorMagico {
    public String evaluar(int tipo, int edad) {
        if (tipo == 1 && edad > 17) return "APROBADA";
        if (tipo == 2 && edad > 15 && edad < 31) return "APROBADA";
        if (tipo == 3 && edad > 17 && edad < 66) return "APROBADA";
        return "RECHAZADA";
    }
}
