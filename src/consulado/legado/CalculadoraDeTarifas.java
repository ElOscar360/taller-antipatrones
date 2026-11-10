package consulado.legado;

/**
 * ANTIPATRÓN: Copy-Paste Programming. La fórmula base está clonada 3 veces.
 * Las "copias" de la tarifa base se modelan como tres campos para poder contar
 * cuántos lugares hay que editar cuando sube el precio.
 */
public class CalculadoraDeTarifas {
    private double baseTurista = 50;
    private double baseEstudiante = 50;
    private double baseTrabajo = 50;
    private int ediciones = 0;

    public double visaTurista(int meses) {
        double total = baseTurista * meses;
        total = total + 10;
        return total;
    }

    public double visaEstudiante(int meses) {
        double total = baseEstudiante * meses;
        total = total + 10;
        return total * 0.5;
    }

    public double visaTrabajo(int meses) {
        double total = baseTrabajo * meses;
        total = total + 10;
        return total * 1.5;
    }

    /** Subir la tarifa obliga a editar cada copia a mano. */
    public void subirTarifaBase(double nueva) {
        baseTurista = nueva;     ediciones++;
        baseEstudiante = nueva;  ediciones++;
        baseTrabajo = nueva;     ediciones++;
    }

    public int getEdiciones() {
        return ediciones;
    }
}
