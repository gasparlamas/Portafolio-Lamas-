package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TElementoAB<Character> nodo1 = new TElementoAB<>('+', null);
        TElementoAB<Character> nodo2 = new TElementoAB<>('*', null);
        TElementoAB<Character> nodo3 = new TElementoAB<>('2', null);
        TElementoAB<Character> nodo4 = new TElementoAB<>('x', null);
        TElementoAB<Character> nodo5 = new TElementoAB<>('4', null);

        nodo1.setHijoIzq(nodo2);
        nodo1.setHijoDer(nodo5);
        nodo2.setHijoIzq(nodo3);
        nodo2.setHijoDer(nodo4);

        ArbolBB<Character> arbolExpresion = new ArbolBB<>(); 
        arbolExpresion.insertar(nodo1);

        Character etiquetaX = 'x';
        TElementoAB<Character> nodoX = arbolExpresion.buscar(etiquetaX);
        if (nodoX != null) {
            nodoX.setEtiqueta('5');
        } else {
            System.out.println("No se pudo sustituir el valor");
        }

        // Imprimir el árbol en orden, preorden y postorden
        System.out.print("InOrder: ");
        System.out.println(arbolExpresion.inOrden());

        System.out.print("PreOrder: ");
        System.out.println(arbolExpresion.preOrden());

        System.out.print("PostOrder: ");
        System.out.println(arbolExpresion.postOrden());

    }
}
