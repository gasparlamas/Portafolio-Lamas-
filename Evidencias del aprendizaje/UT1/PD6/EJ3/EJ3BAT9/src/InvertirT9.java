import java.io.*;


public class InvertirT9 {
    public static void main(String[] args) throws Exception {
        transformarT9Texto("C://Users//Gaspar//OneDrive - Universidad Católica del Uruguay//Escritorio//JAVA//UTA 1//PD6//EJ3//EJ3BAT9//src//entrada.txt");
    }

    public static void transformarT9Texto(String rutaArchivo){

        try {
            FileReader fr = new FileReader(rutaArchivo); // Inicializo un filreader que va a abrir el archivo de entrada que recibe
            BufferedReader lector = new BufferedReader(fr); // va a leer el contenido del archivo 
            FileWriter fw = new FileWriter("src/salida.txt"); // va a abrir el archivo de salida
            BufferedWriter escritor = new BufferedWriter(fw); // escribe sobre el archivo de salida.

            String linea;
            String invertida = ""; //inicializo la cadena vacia donde voy a reescribir la cadena original invertida
            while ((linea = lector.readLine()) != null){ // Se establece el bucle para que funcione hasta que no haya lineas por leer
                for (int indice = linea.length() - 1; indice >= 0; indice--) { // recorro la cadena desde la ultima hasta la primera posicion y concateno los caracteres en ese orden.
                    invertida += linea.charAt(indice);
                }
                String textoT9 = convertirAT9(invertida);
                escritor.write(textoT9); // Se escribe en el archivo de salida
                escritor.newLine();
            }
            lector.close();
            escritor.close();
            System.out.println("El texto se pudo transformar a T9 y se guardo en salida.txt.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String convertirAT9(String texto){
        StringBuilder resultado = new StringBuilder(); // declaro el stringbuilder donde voy a almacenar el resultado de la conversion
        for (char i : texto.toCharArray()){ // Recorro la cadena y separo cada caracter dentro de un array para iterar sobre cada uno facilmente
            if (Character.isLetter(i)){ 
                i = Character.toUpperCase(i); // antes de analizar transformo el caracter a mayuscula para que no haya inconvenientes
                switch (i) { // Switch que evalua cada letra y la convierte al numero correspondiente del formato T9
                    case 'A':
                    case 'B':
                    case 'C':
                        resultado.append("2");
                        break;
                    case 'D':
                    case 'E':
                    case 'F':
                        resultado.append("3");
                        break;
                    case 'G':
                    case 'H':
                    case 'I':
                        resultado.append("4");
                        break;
                    case 'J':
                    case 'K':
                    case 'L':
                        resultado.append("5");
                        break;
                    case 'M':
                    case 'N':
                    case 'O':
                        resultado.append("6");
                        break;
                    case 'P':
                    case 'Q':
                    case 'R':
                        resultado.append("7");
                        break;
                    case 'S':
                    case 'T':
                    case 'V':
                        resultado.append("8");
                        break;
                    case 'W':
                    case 'X':
                    case 'Y':
                    case 'Z':
                        resultado.append("9");
                        break; 
                }       
        } else if (Character.isWhitespace(i)) {
            resultado.append("0"); // A los espacios que encuentre les va a asignar el 0
        } else if (i == '.') {
            resultado.append("1"); // a los puntos les asigna 1
        }
           
    } 
    return resultado.toString(); // devuelvo la cadena
}

}

