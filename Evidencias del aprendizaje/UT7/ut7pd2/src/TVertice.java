
import java.util.HashMap;
import java.util.Map;

public class TVertice {
    private Comparable etiqueta;
    private boolean visitado;
    private Object datos;
    private Map<Comparable, TAdyacencia> adyacencias; // Adyacencias del vértice

    public TVertice(Comparable etiqueta) {
        this.etiqueta = etiqueta;
        this.visitado = false;
        this.datos = null;
        this.adyacencias = new HashMap<>();
    }

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public Object getDatos() {
        return datos;
    }

    public void setDatos(Object datos) {
        this.datos = datos;
    }

    public Map<Comparable, TAdyacencia> getAdyacencias() {
        return adyacencias;
    }

    public boolean insertarAdyacencia(int costo, TVertice destino) {
        if (destino != null) {
            TAdyacencia adyacencia = new TAdyacencia(destino, costo);
            adyacencias.put(destino.getEtiqueta(), adyacencia);
            return true;
        }
        return false;
    }

    public boolean eliminarAdyacencia(Comparable etiquetaDestino) {
        return adyacencias.remove(etiquetaDestino) != null;
    }

    public TAdyacencia buscarAdyacencia(TVertice destino) {
        return adyacencias.get(destino.getEtiqueta());
    }

    public Double obtenerCostoAdyacencia(TVertice destino) {
        TAdyacencia adyacencia = buscarAdyacencia(destino);
        if (adyacencia != null) {
            return (double) adyacencia.getCosto();
        }
        return Double.MAX_VALUE;
    }
}

