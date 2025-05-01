import java.io.*;
import java.util.ArrayList;

public class ContadorPalabras {
    public static void main(String[] args) throws Exception {
        ContadorPalabras contador = new ContadorPalabras();
        String[] ar1 = {"Hola", "mundo", "de", "los", "algoritmos"};
        String[] ar2 = {"Hola", "mundo", "de", "la", "informática"};

        String[] resultado = contador.palabrasComunes(ar1, ar2);
        System.out.println("Palabras comunes: " + String.join(", ", resultado));
    }

    public static String[] palabrasComunes(String[] palabras1, String[] palabras2){
        ArrayList<String> palabrasComunes = new ArrayList<>();

        for (String palabra : palabras1) { //itero sobre el array 1
            if (contiene(palabras2, palabra)) { // verifico si la palabra está en el segundo array
                palabrasComunes.add(palabra); // si se cumple la condición almaceno la palabra en el array nuevo.
            }
        }
    
    return palabrasComunes.toArray(new String[0]);
    }

    public static boolean contiene(String[] array, String palabra) {
        for (String elemento : array) {
            if (elemento.equals(palabra)) { // Este metodo verifica si un array contiene una palabra a la que se la compara.
                return true;
            }
        }
        return false;
    }
}
