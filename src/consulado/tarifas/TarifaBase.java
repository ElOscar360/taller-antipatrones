package consulado.tarifas;

/** ÚNICO lugar donde vive la fórmula base y el precio mensual. */
public class TarifaBase {
    private double mensual;
    private final double cargoFijo;

    public TarifaBase(double mensual, double cargoFijo) {
        this.mensual = mensual;
        this.cargoFijo = cargoFijo;
    }

    public void setMensual(double mensual) {
        this.mensual = mensual;
    }

    public double calcular(int meses) {
        return mensual * meses + cargoFijo;
    }
}
