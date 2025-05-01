public class Tablero {
    public static void main(String[] args) throws Exception {
        imprimirTablero(7, 7);
    }

    
    public static void imprimirTablero(int largo, int ancho){
        for (int i = 0; i < largo; i++) { // inicializo la variable en 0, indico que el bucle se detenga cuando llegue al numero de col deseado y aumento la variable en 1.
            for (int j = 0; j < ancho; j++) { // se repite el proceso pero para las columnas, quedan 2 for anidados.
                System.out.print("#"); // se imprime el caracter "#" tanto para filas como columnas
            }
            System.out.println(); // imprime un espacio para hacer el salto a la siguiente linea una vez que una columna este completa.
        }
    }
}
