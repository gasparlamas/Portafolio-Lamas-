
import java.util.Collection;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ocamp
 */
public class TGrafoRedElectrica extends TGrafoNoDirigido implements IGrafoRedElectrica{
    
    public TGrafoRedElectrica(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
    }

    @Override
    public TAristas mejorRedElectrica() {
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
            aristasAAM.insertarAmbosSentidos(java.util.Collections.singletonList(tmpArista));
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
        return aristasAAM;
    }
    

}