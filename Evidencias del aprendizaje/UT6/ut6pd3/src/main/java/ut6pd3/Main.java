package ut6pd3;

import java.util.HashMap;
import java.util.Map;

import ut6pd3.Ejercicio2.IntercambiadorMap;
import ut6pd3.Ejercicio3.OrdenarStrings;
import ut6pd3.Ejercicio4.LineasRandom;

public class Main {



    public static void main(String[] args) {

            // Aplicacion ejercicio 2
            System.out.println("Ejercicio 2");
            Map<String, String> originalMap = new HashMap<>();
            originalMap.put("clave1", "valor1");
            originalMap.put("clave2", "valor2");
            originalMap.put("clave3", "valor3");
    
            try {
                Map<String, String> invertedMap = IntercambiadorMap.invertirMap(originalMap);
                System.out.println("Mapa invertido: " + invertedMap);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            // Aplicación ejercicio 3
            System.out.println("");
            System.out.println("Ejercicio 3:");
            OrdenarStrings.main(new String[0]);

            // Aplicación ejercicio 4
            System.out.println("");
            System.out.println("Ejercicio 4");
            String archivo = "src//main//java//ut6pd3//prueba4.txt"; // Nombre del archivo de texto
            int numLineas = 5; // Número de líneas aleatorias a imprimir

            LineasRandom.main(new String[] { archivo, String.valueOf(numLineas) });
        }    
}
