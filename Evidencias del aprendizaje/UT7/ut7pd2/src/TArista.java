

public class TArista {
    private Comparable etiquetaOrigen;
    private Comparable etiquetaDestino;
    private int costo;

    public TArista(Comparable etiquetaOrigen, Comparable etiquetaDestino, int costo) {
        this.etiquetaOrigen = etiquetaOrigen;
        this.etiquetaDestino = etiquetaDestino;
        this.costo = costo;
    }

    public Comparable getEtiquetaOrigen() {
        return etiquetaOrigen;
    }

    public Comparable getEtiquetaDestino() {
        return etiquetaDestino;
    }

    public int getCosto() {
        return costo;
    }
}

