package uy.edu.ucu.aed.tdas;

import java.util.Collection;

public interface IGrafoNoDirigido {

   

    Collection<IVertice> bea(Comparable etiquetaOrigen);

    TGrafoNoDirigido Prim();

    TGrafoNoDirigido Kruskal();
}
