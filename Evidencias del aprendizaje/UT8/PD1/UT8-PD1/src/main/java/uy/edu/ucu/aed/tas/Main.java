package uy.edu.ucu.aed.tas;

import java.util.Collection;
import java.util.LinkedList;

import uy.edu.ucu.aed.tdas.IVertice;
import uy.edu.ucu.aed.tdas.TCamino;
import uy.edu.ucu.aed.tdas.TGrafoDirigido;
import uy.edu.ucu.aed.tdas.UtilGrafos;

public class Main {
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		// TA 3
		TGrafoDirigido grafo = UtilGrafos.cargarGrafo("src/main/java/uy/edu/ucu/aed/utils/aeropuertos_2.txt",
				"src/main/java/uy/edu/ucu/aed/utils/conexiones_2.txt", false, TGrafoDirigido.class);

		UtilGrafos.imprimirMatriz(grafo.floyd(), grafo.getVertices());
		// UtilGrafos.imprimirMatriz(grafo.warshall(), grafo.getVertices()); // No anda

		// TA 4
		Collection bpf = grafo.bpf();
		for (Object elem : bpf) {
			System.out.println(((IVertice) elem).getEtiqueta());
		}

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("CAMINOS");
		System.out.println();
		System.out.println();
		LinkedList<TCamino> caminos = grafo.obtenerCaminos("Asuncion", "Montevideo");
		for (TCamino camino : caminos) {
			System.out.println("Camino: ");

			for (IVertice vert : camino.vertices) {
				System.out.println(vert.getEtiqueta());
			}

			System.out.println();
		}
	}
}
