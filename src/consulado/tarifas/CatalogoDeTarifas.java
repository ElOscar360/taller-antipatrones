package consulado.tarifas;

import consulado.visas.TipoVisa;
import java.util.EnumMap;
import java.util.Map;

/** Asocia cada TipoVisa con su estrategia. Nueva visa = una línea aquí + una clase. */
public class CatalogoDeTarifas {
    private final Map<TipoVisa, Tarifa> tarifas = new EnumMap<>(TipoVisa.class);

    public CatalogoDeTarifas(TarifaBase base) {
        tarifas.put(TipoVisa.TURISTA, new TarifaTurista(base));
        tarifas.put(TipoVisa.ESTUDIANTE, new TarifaEstudiante(base));
        tarifas.put(TipoVisa.TRABAJO, new TarifaTrabajo(base));
    }

    public double precio(TipoVisa tipo, int meses) {
        return tarifas.get(tipo).calcular(meses);
    }
}
