package consulado.visas;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

/** Reemplaza el "tipo == 3": cada tipo conoce su código y su rango de edad (inclusive). */
public enum TipoVisa {
    TURISTA(1, LimitesEdad.MAYORIA_EDAD, LimitesEdad.SIN_LIMITE),
    ESTUDIANTE(2, LimitesEdad.MIN_ESTUDIANTE, LimitesEdad.MAX_ESTUDIANTE),
    TRABAJO(3, LimitesEdad.MAYORIA_EDAD, LimitesEdad.MAX_TRABAJO);

    private final int codigo;
    private final int edadMinima;
    private final int edadMaxima;

    TipoVisa(int codigo, int edadMinima, int edadMaxima) {
        this.codigo = codigo;
        this.edadMinima = edadMinima;
        this.edadMaxima = edadMaxima;
    }

    public boolean admite(int edad) {
        return edad >= edadMinima && edad <= edadMaxima;
    }

    public static Optional<TipoVisa> desdeCodigo(int codigo) {
        return Arrays.stream(values()).filter(t -> t.codigo == codigo).findFirst();
    }

    public static String validos() {
        return Arrays.stream(values())
                .map(t -> t.codigo + "=" + t.name())
                .collect(Collectors.joining(", "));
    }
}
