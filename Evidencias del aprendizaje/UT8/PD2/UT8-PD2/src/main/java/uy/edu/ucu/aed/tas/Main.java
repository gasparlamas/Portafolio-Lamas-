package uy.edu.ucu.aed.tas;

import java.util.Collection;
import java.util.LinkedList;

import uy.edu.ucu.aed.tdas.IVertice;
import uy.edu.ucu.aed.tdas.TCamino;
import uy.edu.ucu.aed.tdas.TGrafoNoDirigido;
import uy.edu.ucu.aed.tdas.UtilGrafos;

public class Main {
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		// Prueba kruskal
		TGrafoNoDirigido grafo = UtilGrafos.cargarGrafo("UT8-PD2\\verticesBEA.txt",
				"UT8-PD2\\aristasBEA.txt", false, TGrafoNoDirigido.class);

		
		Object resultadokruskal = grafo.Kruskal();
		System.out.println("Kruskal: " + resultadokruskal);
		
	}
}
