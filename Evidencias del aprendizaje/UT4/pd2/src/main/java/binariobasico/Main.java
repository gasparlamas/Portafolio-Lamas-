package binariobasico;

public class Main {
    public static void main(String[] args) {
        TArbolBB<Integer> arbol1 = new TArbolBB<>();
        TArbolBB<Integer> arbol2 = new TArbolBB<>();
        String nombreArchivoEntrada1 = "Evidencias del aprendizaje\\UT4\\pd2\\src\\main\\java\\binariobasico\\clavesPrueba.txt"; 
        String nombreArchivoSalida = "salida.txt";
        String nombreArchivoEntrada2 = "Evidencias del aprendizaje\\UT4\\pd2\\src\\main\\java\\binariobasico\\claves.txt"; 

        // Leer el archivo de entrada
        String[] lineasArchivo1  = ManejadorArchivosGenerico.leerArchivo(nombreArchivoEntrada1);
        String[] lineasArchivo2 = ManejadorArchivosGenerico.leerArchivo(nombreArchivoEntrada2);

        // Procesar cada línea del archivo para el primer arbol
        for (String linea1 : lineasArchivo1) {
            try {
                Integer valor = Integer.parseInt(linea1.trim()); // Convertir la línea a un entero
                arbol1.insertar(valor, valor); // Insertar el valor en el árbol
            } catch (NumberFormatException e) {
                System.err.println("Error: La línea '" + linea1 + "' no es un número entero válido.");
            }
        }

        // Procesar cada línea del archivo para el segundo arbol
        for (String linea2 : lineasArchivo2) {
            try {
                Integer valor2 = Integer.parseInt(linea2.trim()); // Convertir la línea a un entero
                arbol2.insertar(valor2, valor2); // Insertar el valor en el árbol
            } catch (NumberFormatException e) {
                System.err.println("Error: La línea '" + linea2 + "' no es un número entero válido.");
            }
        }

        // Muestra recorridos del arbol 1
        System.out.println("Recorrido en preorden:");
        System.out.println(arbol1.preOrden());
        System.out.println("Recorrido inorden");
        System.out.println(arbol1.inOrden());
        System.out.println("Recorrido en postorden:");
        System.out.println(arbol1.postOrden());

        // Buscar claves en el árbol 2
        int[] contador = new int[1];
        Integer[] claves = {10635, 4567, 12, 8978};
        for (Integer clave : claves) {
            contador[0] = 0; // Reinicia el contador para cada clave
            TElementoAB<Integer> elemento = arbol2.buscar(clave, contador);
            if (elemento != null) {
            System.out.println("La clave " + clave + " existe en el árbol. Contador: " + contador[0]);
            } else {
            System.out.println("La clave " + clave + " no existe en el árbol.");
            }
        }


        // Archivo de salida arbol 1
        String[] recorridos = {arbol1.preOrden(), arbol1.inOrden(), arbol1.postOrden()};
        ManejadorArchivosGenerico.escribirArchivo(nombreArchivoSalida, recorridos);
    }
}