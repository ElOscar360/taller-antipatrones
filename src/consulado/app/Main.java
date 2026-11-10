package consulado.app;

import consulado.legado.CalculadoraDeTarifas;
import consulado.legado.EvaluadorMagico;
import consulado.legado.OficinaDeTodo;
import consulado.legado.SolicitudAcoplada;
import consulado.notificaciones.CitasObservador;
import consulado.notificaciones.CorreoObservador;
import consulado.notificaciones.PagosObservador;
import consulado.solicitud.Solicitud;
import consulado.tarifas.CatalogoDeTarifas;
import consulado.tarifas.ConstantesTarifa;
import consulado.tarifas.TarifaBase;
import consulado.tramite.CobradorDeTarifa;
import consulado.tramite.NotificadorDeCorreo;
import consulado.tramite.RepositorioDeExpedientes;
import consulado.tramite.TramitadorDeVisa;
import consulado.tramite.ValidadorDePasaporte;
import consulado.visas.EvaluadorDeVisas;
import consulado.visas.ResultadoEvaluacion;
import consulado.visas.TipoVisa;

public class Main {
    private static final int MESES = 3;
    private static final String VIAJERO = "Ana Torres";
    private static final String PASAPORTE = "AB123456";
    private static final double NUEVA_TARIFA_BASE = 60;

    public static void main(String[] args) {
        caso1GodObject();
        caso2CopyPaste();
        caso3MagicNumbers();
        caso4Acoplamiento();
        caso5Integracion();
    }

    private static void titulo(String texto) {
        System.out.println();
        System.out.println("=".repeat(70));
        System.out.println(texto);
        System.out.println("=".repeat(70));
    }

    // ---------------- Caso 1 ----------------
    private static void caso1GodObject() {
        titulo("CASO 1 - God Object");
        double precio = 160;

        System.out.println("--- HEREDADA (Ramiro lo hace todo) ---");
        new OficinaDeTodo().procesar(VIAJERO, PASAPORTE, precio);
        System.out.println("Resultado: trámite aprobado");

        System.out.println("--- RESCATADA (una clase por responsabilidad) ---");
        TramitadorDeVisa tramitador = new TramitadorDeVisa(new ValidadorDePasaporte(),
                new CobradorDeTarifa(), new RepositorioDeExpedientes(), new NotificadorDeCorreo());
        boolean ok = tramitador.tramitar(VIAJERO, PASAPORTE, precio);
        System.out.println("Resultado: trámite " + (ok ? "aprobado" : "rechazado"));
    }

    // ---------------- Caso 2 ----------------
    private static void caso2CopyPaste() {
        titulo("CASO 2 - Copy-Paste Programming (base 50 -> " + (int) NUEVA_TARIFA_BASE + ")");

        CalculadoraDeTarifas clonada = new CalculadoraDeTarifas();
        clonada.subirTarifaBase(NUEVA_TARIFA_BASE);
        System.out.println("Clonada : lugares editados = " + clonada.getEdiciones());

        TarifaBase base = new TarifaBase(ConstantesTarifa.MENSUAL_INICIAL, ConstantesTarifa.CARGO_FIJO);
        CatalogoDeTarifas catalogo = new CatalogoDeTarifas(base);
        base.setMensual(NUEVA_TARIFA_BASE); // un único punto de cambio
        int edicionesStrategy = 1;
        System.out.println("Strategy: lugares editados = " + edicionesStrategy);

        System.out.printf("%-11s %-10s %-10s %-6s%n", "Visa", "Clonada", "Strategy", "Igual");
        imprimirFila("TURISTA", clonada.visaTurista(MESES), catalogo.precio(TipoVisa.TURISTA, MESES));
        imprimirFila("ESTUDIANTE", clonada.visaEstudiante(MESES), catalogo.precio(TipoVisa.ESTUDIANTE, MESES));
        imprimirFila("TRABAJO", clonada.visaTrabajo(MESES), catalogo.precio(TipoVisa.TRABAJO, MESES));
    }

    private static void imprimirFila(String visa, double clonada, double strategy) {
        System.out.printf("%-11s %-10.2f %-10.2f %-6s%n", visa, clonada, strategy, clonada == strategy);
    }

    // ---------------- Caso 3 ----------------
    private static void caso3MagicNumbers() {
        titulo("CASO 3 - Magic Numbers");
        EvaluadorMagico viejo = new EvaluadorMagico();
        EvaluadorDeVisas nuevo = new EvaluadorDeVisas();

        System.out.println("Heredada  evaluar(2, 20)          -> " + viejo.evaluar(2, 20));
        ResultadoEvaluacion r = nuevo.evaluar(TipoVisa.ESTUDIANTE, 20);
        System.out.println("Rescatada evaluar(ESTUDIANTE, 20) -> " + r.etiqueta());

        System.out.println("Heredada  evaluar(9, 20)          -> " + viejo.evaluar(9, 20) + "  (sin explicación)");
        ResultadoEvaluacion invalido = nuevo.evaluar(9, 20);
        System.out.println("Rescatada evaluar(9, 20)          -> " + invalido.etiqueta()
                + ": " + invalido.mensaje());
    }

    // ---------------- Caso 4 ----------------
    private static void caso4Acoplamiento() {
        titulo("CASO 4 - Acoplamiento fuerte");

        System.out.println("--- HEREDADA ---");
        SolicitudAcoplada vieja = new SolicitudAcoplada();
        vieja.cancelar();
        System.out.println("Estado: " + vieja.getEstado()
                + " | ¿Reembolso procesado? " + vieja.getPagos().isReembolsoProcesado()
                + "  <-- ¡SE PERDIÓ EL REEMBOLSO!");

        System.out.println("--- RESCATADA (Observer) ---");
        Solicitud nueva = new Solicitud(VIAJERO, TipoVisa.TURISTA);
        PagosObservador pagos = new PagosObservador();
        nueva.agregarObservador(new CorreoObservador());
        nueva.agregarObservador(new CitasObservador());
        nueva.agregarObservador(pagos);
        nueva.cancelar();
        System.out.println("Estado: " + nueva.getEstado()
                + " | ¿Reembolso procesado? " + (pagos.getReembolsos() > 0));
    }

    // ---------------- Caso 5 ----------------
    private static void caso5Integracion() {
        titulo("CASO 5 - Integración (versión nueva)");
        TarifaBase base = new TarifaBase(ConstantesTarifa.MENSUAL_INICIAL, ConstantesTarifa.CARGO_FIJO);
        CatalogoDeTarifas catalogo = new CatalogoDeTarifas(base);
        EvaluadorDeVisas evaluador = new EvaluadorDeVisas();
        CobradorDeTarifa cobrador = new CobradorDeTarifa();

        System.out.println("1) Solicitar");
        Solicitud solicitud = new Solicitud(VIAJERO, TipoVisa.TRABAJO);
        solicitud.agregarObservador(new CorreoObservador());
        solicitud.agregarObservador(new CitasObservador());
        solicitud.agregarObservador(new PagosObservador());
        System.out.println("  Solicitud de " + solicitud.getViajero() + " tipo " + solicitud.getTipo());

        System.out.println("2) Evaluar");
        ResultadoEvaluacion resultado = evaluador.evaluar(solicitud.getTipo(), 30);
        System.out.println("  " + resultado.etiqueta() + ": " + resultado.mensaje());

        if (resultado.aprobada()) {
            System.out.println("3) Cobrar");
            cobrador.cobrar(solicitud.getViajero(), catalogo.precio(solicitud.getTipo(), MESES));
        }

        System.out.println("4) Cancelar");
        solicitud.cancelar();
        System.out.println("  Estado final: " + solicitud.getEstado());

        imprimirTablaFinal();
    }

    private static void imprimirTablaFinal() {
        String[][] filas = {
            {"God Object", "OficinaDeTodo valida, cobra, guarda y envía correo", "Responsabilidad única: 4 clases + orquestador"},
            {"Copy-Paste", "Fórmula de precio clonada 3 veces (3 ediciones)", "Strategy + TarifaBase (1 edición)"},
            {"Magic Numbers", "tipo == 3, edad > 17, 0.5 sin nombre", "Enum TipoVisa + constantes + mensajes"},
            {"Acoplamiento fuerte", "Solicitud crea servicios y olvidó pagos", "Observer: Solicitud notifica sin conocerlos"},
        };
        System.out.println();
        System.out.println("TABLA FINAL - ANTIPATRONES CAPTURADOS");
        System.out.printf("%-20s | %-50s | %s%n", "Antipatrón", "Síntoma", "Solución");
        System.out.println("-".repeat(125));
        for (String[] f : filas) {
            System.out.printf("%-20s | %-50s | %s%n", f[0], f[1], f[2]);
        }
    }
}
