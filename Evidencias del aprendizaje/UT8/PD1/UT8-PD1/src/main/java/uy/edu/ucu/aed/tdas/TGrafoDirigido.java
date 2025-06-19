package uy.edu.ucu.aed.tdas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class TGrafoDirigido implements IGrafoDirigido {

	private Map<Comparable, IVertice> vertices; // vertices del grafo.-

	public TGrafoDirigido(Collection<IVertice> vertices, Collection<IArista> aristas) {
		this.vertices = new HashMap<>();
		for (IVertice vertice : vertices) {
			insertarVertice(vertice.getEtiqueta());
		}
		for (IArista arista : aristas) {
			insertarArista(arista);
		}
	}

	/**
	 * Metodo encargado de eliminar una arista dada por un origen y destino. En
	 * caso de no existir la adyacencia, retorna falso. En caso de que las
	 * etiquetas sean invalidas, retorna falso.
	 *
	 */
	public boolean eliminarArista(Comparable nomVerticeOrigen, Comparable nomVerticeDestino) {
		if ((nomVerticeOrigen != null) && (nomVerticeDestino != null)) {
			IVertice vertOrigen = buscarVertice(nomVerticeOrigen);
			if (vertOrigen != null) {
				return vertOrigen.eliminarAdyacencia(nomVerticeDestino);
			}
		}
		return false;
	}

	/**
	 * Metodo encargado de verificar la existencia de una arista. Las etiquetas
	 * pasadas por par�metro deben ser v�lidas.
	 *
	 * @return True si existe la adyacencia, false en caso contrario
	 */
	public boolean existeArista(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
		IVertice vertOrigen = buscarVertice(etiquetaOrigen);
		IVertice vertDestino = buscarVertice(etiquetaDestino);
		if ((vertOrigen != null) && (vertDestino != null)) {
			return vertOrigen.buscarAdyacencia(vertDestino) != null;
		}
		return false;
	}

	/**
	 * Metodo encargado de verificar la existencia de un vertice dentro del
	 * grafo.-
	 *
	 * La etiqueta especificada como par�metro debe ser v�lida.
	 *
	 * @param unaEtiqueta Etiqueta del vertice a buscar.-
	 * @return True si existe el vertice con la etiqueta indicada, false en caso
	 *         contrario
	 */
	public boolean existeVertice(Comparable unaEtiqueta) {
		return getVertices().get(unaEtiqueta) != null;
	}

	/**
	 * Metodo encargado de verificar buscar un vertice dentro del grafo.-
	 *
	 * La etiqueta especificada como parametro debe ser valida.
	 *
	 * @param unaEtiqueta Etiqueta del vertice a buscar.-
	 * @return El vertice encontrado. En caso de no existir, retorna nulo.
	 */
	private IVertice buscarVertice(Comparable unaEtiqueta) {
		return getVertices().get(unaEtiqueta);
	}

	/**
	 * Metodo encargado de insertar una arista en el grafo (con un cierto
	 * costo), dado su vertice origen y destino.- Para que la arista sea valida,
	 * se deben cumplir los siguientes casos: 1) Las etiquetas pasadas por
	 * parametros son v�lidas.- 2) Los vertices (origen y destino) existen
	 * dentro del grafo.- 3) No es posible ingresar una arista ya existente
	 * (miso origen y mismo destino, aunque el costo sea diferente).- 4) El
	 * costo debe ser mayor que 0.
	 *
	 * @return True si se pudo insertar la adyacencia, false en caso contrario
	 */
	public boolean insertarArista(IArista arista) {
		if ((arista.getEtiquetaOrigen() != null) && (arista.getEtiquetaDestino() != null)) {
			IVertice vertOrigen = buscarVertice(arista.getEtiquetaOrigen());
			IVertice vertDestino = buscarVertice(arista.getEtiquetaDestino());
			if ((vertOrigen != null) && (vertDestino != null)) {
				return vertOrigen.insertarAdyacencia(arista.getCosto(), vertDestino);
			}
		}
		return false;
	}

	/**
	 * Metodo encargado de insertar un vertice en el grafo.
	 *
	 * No pueden ingresarse vertices con la misma etiqueta. La etiqueta
	 * especificada como par�metro debe ser v�lida.
	 *
	 * @param unaEtiqueta Etiqueta del vertice a ingresar.
	 * @return True si se pudo insertar el vertice, false en caso contrario
	 */
	public boolean insertarVertice(Comparable unaEtiqueta) {
		if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
			IVertice vert = new TVertice(unaEtiqueta);
			getVertices().put(unaEtiqueta, vert);
			return getVertices().containsKey(unaEtiqueta);
		}
		return false;
	}

	@Override
	public boolean insertarVertice(IVertice vertice) {
		Comparable unaEtiqueta = vertice.getEtiqueta();
		if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
			getVertices().put(unaEtiqueta, vertice);
			return getVertices().containsKey(unaEtiqueta);
		}
		return false;
	}

	public Object[] getEtiquetasOrdenado() {
		TreeMap<Comparable, IVertice> mapOrdenado = new TreeMap<>(this.getVertices());
		return mapOrdenado.keySet().toArray();
	}

	/**
	 * @return the vertices
	 */
	public Map<Comparable, IVertice> getVertices() {
		return vertices;
	}

	public Comparable centroDelGrafo() {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	public Double[][] floyd() {
		Double[][] costos = UtilGrafos.obtenerMatrizCostos(vertices);
		// Es cuadrada siempre la matriz. Sino la pifeaste mal.
		int dim = costos.length;
		Double[][] elPosta = new Double[dim][dim];

		for (int i = 0; i < dim; ++i) {
			for (int j = 0; j < dim; ++j) {
				elPosta[i][j] = costos[i][j];
			}
		}

		for (int k = 0; k < dim; ++k) {
			for (int i = 0; i < dim; ++i) {
				for (int j = 0; j < dim; ++j) {
					elPosta[i][j] = Math.min(elPosta[i][j], elPosta[i][k] + elPosta[k][j]);
				}
			}
		}

		return elPosta;
	}

	public Comparable obtenerExcentricidad(Comparable etiquetaVertice) {
		Double[][] resFloyd = floyd();
		IVertice elVertice = this.vertices.get(etiquetaVertice);

		return null;
	}

	public Boolean[][] warshall() {
		Double[][] costos = UtilGrafos.obtenerMatrizCostos(vertices);
		// Es cuadrada siempre la matriz. Sino la pifeaste mal.
		int dim = costos.length;
		Boolean[][] elPosta = new Boolean[dim][dim];

		for (int i = 0; i < dim; ++i) {
			for (int j = 0; j < dim; ++j) {
				elPosta[i][j] = costos[i][j] != Double.MAX_VALUE;
			}
		}

		for (int k = 0; k < dim; ++k) {
			for (int i = 0; i < dim; ++i) {
				for (int j = 0; j < dim; ++j) {
					if (elPosta[i][j]) {
						continue;
					}
					elPosta[i][j] = elPosta[i][k] && elPosta[k][j];
				}
			}
		}

		return elPosta;
	}

	@Override
	public boolean eliminarVertice(Comparable nombreVertice) {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose

	}

	@Override
	public void desvisitarVertices() {
		for (IVertice vertice : getVertices().values()) {
			vertice.setVisitado(false);
		}
	}

	public Collection<IVertice> bpf() {
		ArrayList<IVertice> noVisitados = new ArrayList<>(this.vertices.values());
		HashSet<IVertice> visitados = new HashSet<>();

		while (!noVisitados.isEmpty()) {
			IVertice raiz = noVisitados.remove(0);
			HashSet<IVertice> res = new HashSet<>();
			raiz.bpf(res);
			for (IVertice vert : res) {
				visitados.add(vert);
				noVisitados.remove(vert);
			}
		}

		return visitados;
	}

	public Collection<IVertice> bpf(IVertice origen) {
		HashSet<IVertice> visitados = new HashSet<>();
		origen.bpf(visitados);
		return visitados;
	}

	public Collection<IVertice> bpf(Comparable etiqueta) {
		IVertice vert = this.vertices.get(etiqueta);
		if (vert != null) {
			return this.bpf(vert);
		}
		return null;
	}

	public LinkedList<TCamino> obtenerCaminos(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
		IVertice origen = this.vertices.get(etiquetaOrigen);
		IVertice destino = this.vertices.get(etiquetaDestino);

		HashSet<IVertice> visitados = new HashSet<>();
		LinkedList<TCamino> caminos = new LinkedList<>();
		TCamino camino = new TCamino();
		origen.obtenerCaminos(destino, visitados, caminos, camino);

		return caminos;
	}

}
