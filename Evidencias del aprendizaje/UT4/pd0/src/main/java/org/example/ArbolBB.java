package org.example;

public class ArbolBB<T> implements IArbolBB<T> {

    private TElementoAB<T> raiz;

    public ArbolBB() {
        this.raiz = null;
    }

    @Override
    public boolean insertar(TElementoAB<T> unElemento) {
        if (raiz == null) {
            raiz = unElemento;
            return true;
        } else {
            return raiz.insertar(unElemento);
        }
    }

    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (raiz != null) {
            return raiz.buscar(unaEtiqueta);
        }
        return null;
    }

    @Override
    public String preOrden() {
        if (raiz != null) {
            return raiz.preOrden();
        }
        return "";
    }

    @Override
    public String inOrden() {
        if (raiz != null) {
            return raiz.inOrden();
        }
        return "";
    }

    @Override
    public String postOrden() {
        if (raiz != null) {
            return raiz.postOrden();
        }
        return "";
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) { // aun no hace nada, hasta que no lo implemente en la clase elemento
        if (raiz != null) {
            raiz = raiz.eliminar(unaEtiqueta);
        }
    }

    public int sumarClaves(TElementoAB<T> nodo) { // suma las etiquetas de los nodos
        if (nodo == null) {
            return 0;
        }
        int suma = ((Integer) nodo.getEtiqueta());
        suma += sumarClaves(nodo.getHijoIzq());
        suma += sumarClaves(nodo.getHijoDer());
        return suma;
    }
    public int contarHojas(TElementoAB<T> nodo) {
        if (nodo == null) {
            return 0;
        }
        if (nodo.getHijoIzq() == null && nodo.getHijoDer() == null) {
            return 1;
        }
        int hojasIzquierda = contarHojas(nodo.getHijoIzq());
        int hojasDerecha = contarHojas(nodo.getHijoDer());

        return hojasIzquierda + hojasDerecha;
    }
    public Comparable obtenerMenorClave(TElementoAB<T> nodo) {
        if (nodo == null) {
            return null;
        }
        while (nodo.getHijoIzq() != null) {
            nodo = nodo.getHijoIzq();
        }
        return nodo.getEtiqueta();
    }
    public Comparable obtenerMayorClave(TElementoAB<T> nodo) {
        if (nodo == null) {
            return null;
        }
        while (nodo.getHijoDer() != null) {
            nodo = nodo.getHijoDer();
        }
        return nodo.getEtiqueta();
    }

    public Comparable obtenerClaveAnterior(TElementoAB<T> nodo, Comparable unaEtiqueta) {
        Comparable claveAnterior = null;
        if (this.buscar(unaEtiqueta) != null){
            while (nodo != null) {
                if (unaEtiqueta.compareTo(nodo.getEtiqueta()) == 0) {
                    break;
                } else if (unaEtiqueta.compareTo(nodo.getEtiqueta()) > 0) {
                    claveAnterior = nodo.getEtiqueta();
                    nodo = nodo.getHijoDer();
                } else {
                    nodo = nodo.getHijoIzq();
                }
            }
        }
        return claveAnterior;
    }

    public String listarHojasConNivel() {
        StringBuilder sb = new StringBuilder();
        if (raiz != null) {
            listarHojasConNivel(raiz, 0, sb);
        }
        return sb.toString();
    }

    private void listarHojasConNivel(TElementoAB<T> nodo, int nivel, StringBuilder sb) {
        if (nodo == null) {
            return;
        }
        if (nodo.getHijoIzq() == null && nodo.getHijoDer() == null) {
            sb.append("Hoja: ").append(nodo.getEtiqueta()).append(", Nivel: ").append(nivel).append("\n");
        }
        listarHojasConNivel(nodo.getHijoIzq(), nivel + 1, sb);
        listarHojasConNivel(nodo.getHijoDer(), nivel + 1, sb);
    }

    public int contarNodosEnNivel(TElementoAB<T> nodo, int nivelDeseado) {
        if (nodo == null) {
            return 0;
        }
        if (nivelDeseado == 0) {
            return 1; // El nivel deseado es el nivel actual, devolvemos 1 para contar este nodo.
        }
        int nodosIzquierda = contarNodosEnNivel(nodo.getHijoIzq(), nivelDeseado - 1);
        int nodosDerecha = contarNodosEnNivel(nodo.getHijoDer(), nivelDeseado - 1);
        return nodosIzquierda + nodosDerecha;
    }

    public boolean esDeBusquda(String salidaInOrden) { // verifica si el string de salida de imprimir el arbol en orden esta bien, si es true significa que el arbol es de busqueda
        String[] etiquetas = salidaInOrden.split("-");
        for (int i = 1; i < etiquetas.length; i++) {
            if (etiquetas[i].compareTo(etiquetas[i - 1]) < 0) {
                return false;
            }
        }
        return true;
    }



}
