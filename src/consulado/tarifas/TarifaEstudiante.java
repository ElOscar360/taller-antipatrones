package consulado.tarifas;

public class TarifaEstudiante extends TarifaConFactor {
    public TarifaEstudiante(TarifaBase base) { super(base); }

    @Override
    protected double factor() { return ConstantesTarifa.FACTOR_ESTUDIANTE; }
}
