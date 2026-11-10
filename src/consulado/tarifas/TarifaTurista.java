package consulado.tarifas;

public class TarifaTurista extends TarifaConFactor {
    public TarifaTurista(TarifaBase base) { super(base); }

    @Override
    protected double factor() { return ConstantesTarifa.FACTOR_TURISTA; }
}
