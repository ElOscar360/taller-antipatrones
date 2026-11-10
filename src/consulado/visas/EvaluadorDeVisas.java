package consulado.visas;

import consulado.comun.Mensajes;
import java.util.Optional;

public class EvaluadorDeVisas {

    public ResultadoEvaluacion evaluar(int codigo, int edad) {
        Optional<TipoVisa> tipo = TipoVisa.desdeCodigo(codigo);
        if (tipo.isEmpty()) {
            return ResultadoEvaluacion.rechazada(
                    Mensajes.TIPO_DESCONOCIDO.formatted(codigo, TipoVisa.validos()));
        }
        return evaluar(tipo.get(), edad);
    }

    public ResultadoEvaluacion evaluar(TipoVisa tipo, int edad) {
        if (tipo.admite(edad)) {
            return ResultadoEvaluacion.aprobada(Mensajes.VISA_APROBADA.formatted(tipo));
        }
        return ResultadoEvaluacion.rechazada(
                Mensajes.EDAD_FUERA_DE_RANGO.formatted(edad, tipo));
    }
}
