package consulado.legado;

public class PagosServicio {
    private boolean reembolsoProcesado = false;

    public void reembolsar() {
        reembolsoProcesado = true;
        System.out.println("  [Pagos] Reembolso procesado");
    }

    public boolean isReembolsoProcesado() {
        return reembolsoProcesado;
    }
}
