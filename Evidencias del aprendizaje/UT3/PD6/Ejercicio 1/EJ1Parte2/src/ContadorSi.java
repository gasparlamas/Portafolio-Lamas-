import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class ContadorSi {
    public static void main(String[] args) throws Exception {
        Contador("C:/Users/Gaspar/OneDrive - Universidad Católica del Uruguay/Escritorio/JAVA/UTA 3/Ejercicio 1/numeros.txt");
    }

    public static void Contador(String nombreArchivo){
        try {
            FileReader fr = new FileReader(nombreArchivo); //Abre el archivo
            BufferedReader br = new BufferedReader(fr); //Buffereader lee cada linea del archivo
            
            int N = Integer.parseInt(br.readLine()); // Leo el valor de la primera linea y obtengo mi cantidad de numeros en el archivo
            int[] arreglo = new int[N]; //Creo un arreglo de N tamaño para almacenar los valores

            for (int i = 0; i < N ; i++){
                arreglo[i] = Integer.parseInt(br.readLine()); //Leo los numeros y los almaceno en el arreglo
            } 

            int contadorSi = 0;

            // Implemento el algoritmo del ejercicio
            for (int i = 0; i < N - 1; i++) {
                for (int j = N - 1; j > i; j--) {
                    if (arreglo[j] < arreglo[j - 1]) {
                        intercambiar(arreglo, j, j - 1);
                        contadorSi++; // Incrementa el contador
                    }
                }
            }
            // Muestra el largo N, el contenido del contador y los números en la primera y última posición del arreglo
            System.out.println("Largo N: " + N);
            System.out.println("Contador de si: " + contadorSi);
            System.out.println("Número en la primera posición: " + arreglo[0]);
            System.out.println("Número en la última posición: " + arreglo[N - 1]);

    }  catch (IOException e) {
        e.printStackTrace();
    }
 }
 // Método para intercambiar elementos en un arreglo
 public static void intercambiar(int[] arreglo, int i, int j) {
    int temp = arreglo[i];
    arreglo[i] = arreglo[j];
    arreglo[j] = temp;
}

}


