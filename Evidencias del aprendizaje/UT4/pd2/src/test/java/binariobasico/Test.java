package binariobasico;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TElementoABTest {

    @Test
    void tamaño() {

    }

    @Test
    public void testBuscar() {
        // Crear el árbol
        TElementoAB<Integer> raiz = new TElementoAB<>(10, 10);
        raiz.insertar(new TElementoAB<>(5, 5));
        raiz.insertar(new TElementoAB<>(15, 15));
        raiz.insertar(new TElementoAB<>(3, 3));
        raiz.insertar(new TElementoAB<>(8, 8));

        // Probar el método buscar
        int[] contador = new int[1];
        TElementoAB<Integer> nodoEncontrado = raiz.buscar(10, contador);
        assertEquals(raiz, nodoEncontrado); // Debe encontrar la raíz

        contador = new int[1];
        nodoEncontrado = raiz.buscar(15, contador);
        assertEquals(raiz.getHijoDer(), nodoEncontrado); // Debe encontrar el hijo derecho de la raíz

        contador = new int[1];
        nodoEncontrado = raiz.buscar(100, contador);
        assertNull(nodoEncontrado); // No debe encontrar un elemento que no existe
    }


    @Test
    void test_altura_arbolVacio(){
        //Given
        TArbolBB<Integer> arbol = new TArbolBB<>();

        //When: acciones que estamos testeando

        int resultado = arbol.altura();

        //Then: verificaciones
        assertEquals(1, resultado);
    }

    @Test
    void test_altura_arbolConUnSoloNodo(){
        //Given
        TArbolBB<Integer> arbol = new TArbolBB<>();
        arbol.insertar(1 , 1);

        //When: acciones que estamos testeando
        int resultado = arbol.altura();

        //Then: verificaciones
        assertEquals(1, resultado);
    }

    @Test
    void test_altura_arbolConMultiplesNodos(){
        //Given
        TArbolBB<Integer> arbol = new TArbolBB<>();
        arbol.insertar(3, 3);
        arbol.insertar(2, 2);
        arbol.insertar(4, 4);
        arbol.insertar(5, 5);
        arbol.insertar(6 , 6);


        //When: acciones que estamos testeando
        int resultado = arbol.altura();

        //Then: verificaciones
        assertEquals(4, resultado);
    }



    @Test
    void test_Arbol_Completo_Tamanio() {
        //Given
        TArbolBB<Integer> arbol = new TArbolBB<>();
        arbol.insertar(1 , 1);
        arbol.insertar(2, 2);
        arbol.insertar(6, 6);
        arbol.insertar(5, 5);

        //When: acciones que estamos testeando
        int resultado = arbol.tamanio();

        //Then: verificaciones
        assertEquals(4, resultado);
    }

    @Test
    void test_Arbol_Vacio_Tamanio(){
        //Given
        TArbolBB<Integer> arbol = new TArbolBB<>();

        //When

        int resultado = 1;
        if (arbol.tamanio() == 0){
            resultado = 0;
        }
        //Then
        assertEquals(0, resultado);
    }

    @Test
    void test_Arbol_Un_Elemento(){
        //Given
        TArbolBB<Integer> arbol = new TArbolBB<>();
        arbol.insertar(2, 2);

        //When
        int resultado = arbol.tamanio();

        //Then
        assertEquals(1, resultado);
    }


}
