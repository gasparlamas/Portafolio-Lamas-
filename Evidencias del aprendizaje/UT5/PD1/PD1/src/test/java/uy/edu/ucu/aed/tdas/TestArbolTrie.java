package uy.edu.ucu.aed.tdas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestArbolTrie {

	private TArbolTrie trie;

	@BeforeEach
	void init() {
		trie = new TArbolTrie();
	}

	@Test
	public void testInsertarYBuscar() {
		trie.insertar("hola");
		trie.insertar("mundo");

		assertEquals(4, trie.buscar("hola"), "La palabra 'hola' debería estar en el trie.");
		assertEquals(5, trie.buscar("mundo"), "La palabra 'mundo' debería estar en el trie.");
		assertEquals(-1, trie.buscar("adios"), "La palabra 'adios' no debería estar en el trie.");
	}

	@Test
	public void testBuscarEnTrieVacio() {
		assertEquals(-1, trie.buscar("hola"), "No debería encontrar palabras en un trie vacío.");
	}

	@Test
	public void testImprimir() {
		trie.insertar("hola");
		trie.insertar("mundo");

		trie.imprimir();
	}

	@Test
	public void testInsertarElementoComoRaiz() {
		TArbolTrie t = new TArbolTrie();
		t.insertar("arbol");
		assertEquals(5, t.buscar("arbol"), "Debe devolver true (comparaciones) al insertar como raíz");
	}

	@Test
	public void testInsertarElementoExistente() {
		TArbolTrie t = new TArbolTrie();
		t.insertar("arbol");
		t.insertar("arbol"); // Insertar repetido
		assertEquals(5, t.buscar("arbol"), "Debe devolver true (comparaciones) aunque se inserte repetido");
	}

	@Test
	public void testInsertarElementoConPadreInexistente() {
		// En Trie, siempre se crean los padres si no existen, así que este caso no aplica igual que en árboles generales
		// Se prueba que insertar una palabra nueva funciona y no lanza error
		TArbolTrie t = new TArbolTrie();
		t.insertar("padre");
		t.insertar("padrehijo");
		assertEquals(9, t.buscar("padrehijo"), "Debe devolver true (comparaciones) al insertar con padre creado");
	}

	@Test
	public void testBuscarEtiquetaExistente() {
		TArbolTrie t = new TArbolTrie();
		t.insertar("perro");
		assertEquals(5, t.buscar("perro"), "Debe devolver el nodo correspondiente (comparaciones)");
	}

	@Test
	public void testBuscarEtiquetaNoExistente() {
		TArbolTrie t = new TArbolTrie();
		t.insertar("gato");
		assertEquals(-1, t.buscar("pato"), "Debe devolver -1 para etiqueta inexistente");
	}

	@Test
	public void testBuscarEnArbolVacio() {
		TArbolTrie t = new TArbolTrie();
		assertEquals(-1, t.buscar("nada"), "Debe devolver -1 en árbol vacío");
	}

	@Test
	public void testListarIndentadoVacio() {
		TArbolTrie t = new TArbolTrie();
		// Captura de consola para verificar salida vacía
		java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
		System.setOut(new java.io.PrintStream(out));
		t.listarIndentado();
		System.setOut(new java.io.PrintStream(new java.io.FileOutputStream(java.io.FileDescriptor.out)));
		assertTrue(out.toString().trim().isEmpty(), "No debe mostrar nada para árbol vacío");
	}

	@Test
	public void testListarIndentadoSoloRaiz() {
		TArbolTrie t = new TArbolTrie();
		t.insertar("a");
		java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
		System.setOut(new java.io.PrintStream(out));
		t.listarIndentado();
		System.setOut(new java.io.PrintStream(new java.io.FileOutputStream(java.io.FileDescriptor.out)));
		String salida = out.toString().trim();
		assertTrue(salida.contains("a"), "Debe mostrar solo la raíz");
	}

	@Test
	public void testListarIndentadoMultiplesNiveles() {
		TArbolTrie t = new TArbolTrie();
		t.insertar("a");
		t.insertar("ab");
		t.insertar("abc");
		java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
		System.setOut(new java.io.PrintStream(out));
		t.listarIndentado();
		System.setOut(new java.io.PrintStream(new java.io.FileOutputStream(java.io.FileDescriptor.out)));
		String salida = out.toString();
		assertTrue(salida.contains("a") && salida.contains("ab") && salida.contains("abc"), "Debe mostrar elementos indentados según nivel");
	}
}