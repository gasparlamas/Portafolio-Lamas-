import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Calculos {
    public static void main(String[] args) throws Exception {
        leerEntradaStdin("C://Users//Gaspar//OneDrive - Universidad Católica del Uruguay//Documentos//radioC.txt");
    }

    public static void leerEntradaStdin(String nombreArchivo){
        try {
            FileReader fr = new FileReader(nombreArchivo); //Abre el archivo
            BufferedReader br = new BufferedReader(fr); //Buffereader lee cada linea del archivo
            String lineaActual = br.readLine();

            int radio = 0;

            while (lineaActual != null){ //Mientras hayan lineas por leer en el archivo se ejecuta el bucle
                if (radio == 0){
                    radio = Integer.parseInt(lineaActual); // Convierto el string a entero
                    }
                    lineaActual = br.readLine();
            }
            System.out.println("El área de la circunferencia es: " + (radio * 3.14));
            System.out.println("El perimetro de la circunferencia es: " + (radio * 3.14*2));
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