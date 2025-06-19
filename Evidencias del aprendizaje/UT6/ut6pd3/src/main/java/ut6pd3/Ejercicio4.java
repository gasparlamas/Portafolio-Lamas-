package ut6pd3;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Ejercicio4 {
    public class LineasRandom {
        public static void main(String[] args) {

            if (args.length < 2) {
                System.err.println("Uso: java RandomLinesFromFile <archivo> <num_lineas>");
                return;
            }

            String archivo = args[0];
            int numLineas = Integer.parseInt(args[1]);

            List<String> lineas = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    lineas.add(linea);
                }
            } catch (IOException e) {
                System.err.println("Error al leer el archivo: " + e.getMessage());
                return;
            }
            
            Random random = new Random(); // imprimir líneas de forma aleatoria
            int numLineasArchivo = lineas.size();

            System.out.println("Leyendo " + numLineas + " líneas aleatorias del archivo " + archivo + ":");
            for (int i = 0; i < numLineas; i++) {
                int indiceAleatorio = random.nextInt(numLineasArchivo);
                System.out.println(lineas.get(indiceAleatorio));
            }
        }
    }
}
