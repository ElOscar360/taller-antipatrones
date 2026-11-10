package consulado.tarifas;

public class TarifaTrabajo extends TarifaConFactor {
    public TarifaTrabajo(TarifaBase base) { super(base); }

    @Override
    protected double factor() { return ConstantesTarifa.FACTOR_TRABAJO; }
}
