package uy.edu.ucu.aed.tdas;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoNoDirigido {
    protected TAristas lasAristas = new TAristas();

    /**
     * @param vertices
     * @param aristas
     */
    public TGrafoNoDirigido(Collection<IVertice> vertices, Collection<IArista> aristas) {
        super(vertices, aristas);

        Collection<TArista> aristasT = new LinkedList<>();
        for (IArista arista : aristas) {
            aristasT.add((TArista) arista);
        }
        lasAristas.insertarAmbosSentidos(aristasT);

    }

    @Override
    public boolean insertarArista(IArista arista) {
        boolean tempbool = false;
        TArista arInv = new TArista(arista.getEtiquetaDestino(), arista.getEtiquetaOrigen(), arista.getCosto());
        tempbool = (super.insertarArista(arista) && super.insertarArista(arInv));
        return tempbool;
    }

    public TAristas getLasAristas() {
        return lasAristas;
    }

    @Override
    public TGrafoNoDirigido Prim() {
        double costoPrim = 0;
        LinkedList<Comparable> U = new LinkedList<>();
        LinkedList<Comparable> V = new LinkedList<>(getVertices().keySet());
        TAristas aristasAAM = new TAristas();
        Comparable tmp = V.getFirst();
        U.add(tmp);
        V.remove(tmp);
        TArista tmpArista = null;
        while (!V.isEmpty()) {
            tmpArista = this.lasAristas.buscarMin(U, V);
            aristasAAM.insertarAmbosSentidos(tmpArista);
            V.remove(tmpArista.etiquetaDestino);
            U.add(tmpArista.etiquetaDestino);
            costoPrim = costoPrim + tmpArista.getCosto();
        }
        Collection<IArista> aristasI = new LinkedList<>();
        for (IArista arista : aristasAAM) {
            aristasI.add((TArista) arista);
        }
        Collection<IVertice> UNuevo = new LinkedList<>();
        for (Comparable k : U) {
            UNuevo.add(getVertices().get(k));
        }
        return new TGrafoNoDirigido(UNuevo, aristasI);

    }

    @Override
    public TGrafoNoDirigido Kruskal() {
        Collection<IArista> aristasAAM = new LinkedList<>();
        LinkedList<TArista> aristasOrdenadas = new LinkedList<>();
        for (IArista arista : lasAristas) {
            aristasOrdenadas.add((TArista) arista);
        }
        aristasOrdenadas.sort((a, b) -> Double.compare(a.getCosto(), b.getCosto())); //ordenar por costo

        // inicializar cada vértice en su propia lista / ocomponente
        LinkedList<LinkedList<Comparable>> componentes = new LinkedList<>();
        for (IVertice v : getVertices().values()) {
            LinkedList<Comparable> comp = new LinkedList<>();
            comp.add(v.getEtiqueta());
            componentes.add(comp);
        }

        for (TArista arista : aristasOrdenadas) {
            LinkedList<Comparable> compU = null;
            LinkedList<Comparable> compV = null;
            // buscar a qué componente pertenece cada extremo
            for (LinkedList<Comparable> comp : componentes) {
                if (comp.contains(arista.getEtiquetaOrigen())) compU = comp;
                if (comp.contains(arista.getEtiquetaDestino())) compV = comp;
            }
            // unir componentes y agregar la arista
            if (compU != null && compV != null && compU != compV) {
                aristasAAM.add(arista);
                compU.addAll(compV);
                componentes.remove(compV);
            }
            // cuando queda un solo componente se termina
            if (componentes.size() == 1) break;
        }
        return new TGrafoNoDirigido(getVertices().values(), aristasAAM);
    }

    
    @Override
    public Collection<IVertice> bea(Comparable etiquetaOrigen) {
        for (IVertice v : getVertices().values()) {
            v.setVisitado(false);
        }
        LinkedList<IVertice> resultado = new LinkedList<>();
        Queue<IVertice> cola = new LinkedList<>();
        IVertice origen = getVertices().get(etiquetaOrigen);
        if (origen == null) return resultado;
        origen.setVisitado(true);
        cola.add(origen);
        resultado.add(origen);
        while (!cola.isEmpty()) {
            IVertice x = cola.poll();
            for (Object obj : x.getAdyacentes()) {
                IAdyacencia ady = (IAdyacencia) obj;
                IVertice y = (IVertice) ady.getDestino();
                if (!y.getVisitado()) {
                    y.setVisitado(true);
                    cola.add(y);
                    resultado.add(y);
                }
            }
        }
        return resultado;
    }

    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Aristas del árbol generado por Kruskal/Prim:\n");
        for (IArista arista : lasAristas) {
            sb.append(arista.getEtiquetaOrigen())
              .append(" - ")
              .append(arista.getEtiquetaDestino())
              .append(" (costo: ")
              .append(arista.getCosto())
              .append(")\n");
        }
        return sb.toString();
    }
}
