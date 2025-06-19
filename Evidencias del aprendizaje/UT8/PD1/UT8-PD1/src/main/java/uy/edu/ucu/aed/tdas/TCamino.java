package uy.edu.ucu.aed.tdas;

import java.util.LinkedList;

public class TCamino {
	public LinkedList<IVertice> vertices;

	public TCamino() {
		this.vertices = new LinkedList<>();
	}

	public TCamino(LinkedList<IVertice> vertices) {
		this.vertices = vertices;
	}

	public void add(IVertice vertice) {
		this.vertices.add(vertice);
	}

	public void remove(IVertice vertice) {
		this.vertices.remove(vertice);
	}

	public TCamino clone() {
		LinkedList<IVertice> newVertices = (LinkedList<IVertice>) this.vertices.clone();

		return new TCamino(newVertices);
	}
}
