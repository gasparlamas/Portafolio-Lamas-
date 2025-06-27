import java.util.Collection;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      // cargar grafo con casas y distancias
        TGrafoRedElectrica laRed =  (TGrafoRedElectrica) UtilGrafos.cargarGrafo(
                "src\\barrio.txt",
                "src\\distancias.txt",
                false, TGrafoRedElectrica.class);
       
        /*
           
        calcular la mejor red electrica\
        listar en el archivo "redelectrica.txt" el costo total del cableado
        y las conexiones establecidas, una por linea (origen, destino, costo)
        
        */
        
        // Calcular la mejor red electrica
        TAristas aristasRed = laRed.mejorRedElectrica();
        double costoTotal = 0;
        LinkedList<String> lineasSalida = new LinkedList<>();
        // a) Indicación del algoritmo
        lineasSalida.add("Algoritmo utilizado: Prim");
        // b) Calcular costo total y armar líneas de conexiones
        for (IArista arista : aristasRed) {
            TArista tArista = (TArista) arista;
            costoTotal += tArista.getCosto();
            lineasSalida.add(tArista.getEtiquetaOrigen() + "," + tArista.getEtiquetaDestino() + "," + tArista.getCosto());
        }
        // b) Agregar el costo total al principio
        lineasSalida.add(1, "Costo total del cableado: " + costoTotal);
        // c) Escribir el archivo de salida
        ManejadorArchivosGenerico.escribirArchivo("redelectrica.txt", lineasSalida.toArray(new String[0]));
    }
}
