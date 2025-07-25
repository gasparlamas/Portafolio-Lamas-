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
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
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
}
