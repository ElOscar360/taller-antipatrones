package consulado.tarifas;

/** Estrategia: cada tipo de visa decide cómo calcula su precio. */
public interface Tarifa {
    double calcular(int meses);
}
