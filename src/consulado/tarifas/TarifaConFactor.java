package consulado.tarifas;

/** Plantilla común: base * factor. Las subclases solo aportan el factor. */
public abstract class TarifaConFactor implements Tarifa {
    private final TarifaBase base;

    protected TarifaConFactor(TarifaBase base) {
        this.base = base;
    }

    protected abstract double factor();

    @Override
    public double calcular(int meses) {
        return base.calcular(meses) * factor();
    }
}
