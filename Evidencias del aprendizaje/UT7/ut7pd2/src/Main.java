import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // Crear el grafo dirigido
        TGrafoDirigido grafo = new TGrafoDirigido();

        // Insertar los vértices
        grafo.insertarVertice(new TVertice("Artigas"));
        grafo.insertarVertice(new TVertice("Canelones"));
        grafo.insertarVertice(new TVertice("Durazno"));
        grafo.insertarVertice(new TVertice("Florida"));
        grafo.insertarVertice(new TVertice("Montevideo"));
        grafo.insertarVertice(new TVertice("Punta del Este"));
        grafo.insertarVertice(new TVertice("Rocha"));

        // Insertar las aristas
        grafo.insertarArista(new TArista("Artigas", "Rocha", 400));
        grafo.insertarArista(new TArista("Canelones", "Artigas", 500));
        grafo.insertarArista(new TArista("Canelones", "Colonia", 200));
        grafo.insertarArista(new TArista("Canelones", "Durazno", 170));
        grafo.insertarArista(new TArista("Canelones", "Punta del Este", 90));
        grafo.insertarArista(new TArista("Colonia", "Montevideo", 180));
        grafo.insertarArista(new TArista("Florida", "Durazno", 60));
        grafo.insertarArista(new TArista("Montevideo", "Artigas", 700));
        grafo.insertarArista(new TArista("Montevideo", "Canelones", 30));
        grafo.insertarArista(new TArista("Montevideo", "Punta del Este", 130));
        grafo.insertarArista(new TArista("Punta del Este", "Rocha", 90));
        grafo.insertarArista(new TArista("Rocha", "Montevideo", 270));
        grafo.insertarArista(new TArista("Florida", "Durazno", 60));

        // Obtener la matriz de costos
        Double[][] matrizCostos = UtilGrafos.obtenerMatrizCostos(grafo.getVertices());

        // Convertir la matriz de costos en matriz de adyacencias (boolean[][])
        boolean[][] matrizAdyacencias = new boolean[matrizCostos.length][matrizCostos.length];

        for (int i = 0; i < matrizCostos.length; i++) {
            for (int j = 0; j < matrizCostos.length; j++) {
                if (matrizCostos[i][j] != Double.MAX_VALUE) {
                    matrizAdyacencias[i][j] = true;
                } else {
                    matrizAdyacencias[i][j] = false;
                }
            }
        }

        // Imprimir la matriz de adyacencias
        System.out.println("Matriz de Adyacencias:");
        imprimirMatrizAdyacencias(matrizAdyacencias, grafo.getVertices());

        // Aplicar el algoritmo de Floyd
        Double[][] matrizFloyd = grafo.floyd();

        // Imprimir la matriz de Floyd
        System.out.println("Matriz de Floyd - Caminos Mínimos:");
        imprimirMatriz(matrizFloyd);
    }

    public static void imprimirMatrizAdyacencias(boolean[][] matrizAdyacencias, Map<Comparable, TVertice> vertices) {
        Object[] etiquetas = vertices.keySet().toArray();
        System.out.print("  ");
        for (int i = 0; i < matrizAdyacencias.length; i++) {
            System.out.print(etiquetas[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < matrizAdyacencias.length; i++) {
            System.out.print(etiquetas[i] + " ");
            for (int j = 0; j < matrizAdyacencias.length; j++) {
                System.out.print((matrizAdyacencias[i][j] ? 1 : 0) + " ");
            }
            System.out.println();
        }
    }

    // Método para imprimir la matriz
    public static void imprimirMatriz(Double[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == Double.MAX_VALUE) {
                    System.out.print("INF ");
                } else {
                    System.out.print(matriz[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}


