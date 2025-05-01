import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class EntradaDatos {
    public static void main(String[] args) throws Exception {
        leerArchivo("C://Users//Gaspar//OneDrive - Universidad Católica del Uruguay//Escritorio//JAVA//UTA 1//PD6//entrada.txt");
    }

    public static void leerArchivo(String nombreArchivo){
        
        try {
            FileReader fr = new FileReader(nombreArchivo); //Abre el archivo
            BufferedReader br = new BufferedReader(fr); //Buffereader lee cada linea del archivo
            String lineaActual = br.readLine();

         int entero = 0;
         double flotante = 0;
         String cadena = ""; // Inicializo las variables en las que voy a almacenar los datos de las lineas.

         while (lineaActual != null){ //Mientras hayan lineas por leer en el archivo se ejecuta el bucle
            if (entero == 0){
                entero = Integer.parseInt(lineaActual); // Convierto el string a entero
                }
                else if (flotante == 0) {
                    flotante = Double.parseDouble(lineaActual); // Convierto el string a double
                } 
                else {
                    cadena = lineaActual; //Se almacena el nombre en la variable.
                }
                lineaActual = br.readLine();

            }
            System.out.println("El entero leido es: " + entero);
            System.out.println("El numero de punto flotante leido es: " + flotante);
            System.out.println("La cadena leida es: " + cadena); // Se imprimen las condiciones del ejercicio
            System.out.println("¡Hola " + cadena + "!" + " La suma de " + entero + " y " + flotante + " es " + (entero+flotante));
            System.out.println("La división entera de " + flotante + " y " + entero + " es " + ((int)flotante/entero) + " y su resto es " + (int)flotante%entero);
            // se convierte tanto la operación de división y la del resto a (int) porque sino los resultados seran numeros con muchos digitos.

        }
        
         
        catch (FileNotFoundException e) {
         System.out.println("Error al leer el archivo "+nombreArchivo);
         e.printStackTrace();
         } catch (IOException e)
        {
        System.out.println("Error al leer el archivo "+nombreArchivo);
         e.printStackTrace();
         }
         System.out.println("Archivo leido satisfactoriamente"); // Esta sección se encarga de enviar mensajes para informar que se leyó o no con exito el archivo.
        }
        
}
