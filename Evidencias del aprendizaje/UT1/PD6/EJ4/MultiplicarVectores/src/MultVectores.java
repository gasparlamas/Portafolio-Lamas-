

public class MultVectores {


    // Las condiciones para poder multiplicar dos vectores son:
    // Que tengan la misma cantidad de elementos, ya que todo elemento de un vector A debe tener un elemento en B asignado para multiplicarse.
    // Los elementos deben ser enteros int o no se pueden multiplicar.
    
    public static void main(String[] args) throws Exception {

        int[] vectorA = {1,2,3};
        int[] vectorB = {2,4,2}; // declaro los vectores 
        int resultado = multiplicarVectores(vectorA, vectorB);
        System.out.println("El resultado de multiplicar los dos vectores es: " + resultado);
   
    }

    public static int multiplicarVectores(int [] vectorA, int[] vectorB){

        if (vectorA.length != vectorB.length){ // verifico que la longitud de los vectores sea igual
            System.out.println("No se puede realizar la multiplicación ya que las longitudes de los vectores no son iguales.");
        }

        int resultado = 0; // variable donde voy a almacenar el resultado
        for (int i = 0; i < vectorA.length; i++) { // bucle para recorrer los vectores, termina cuando recorra la longitud de A (misma que b)
            resultado += vectorA[i] * vectorB[i]; // multiplica los elementos de la posicion correspondiente de los vectores y los almacena en resultado, y asi los va sumando.
        }
        
        return resultado;


    }
}
