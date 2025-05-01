public class Marcapasos {
    public static void main(String[] args) throws Exception {
        short presionSanguinea; // En lugar de int puedo usar short ya que es un rango pequeño el que necesito cubrir, y me ahorro memoria, ocupa 2 bytes
        short frecuenciaCardiaca; // 2 bytes
        short nivelAzucarSangre; // 2 bytes
        long maximaFuerza; // Como int no llega a cubrir el rango especificado, voy a tener que usar una variable long, aunque ocupe más espacio. Ocupa 8 bytes
        float minimoTiempo; // Ocupa 4 bytes
        double bateriaRestante; // Uso double en vez de float ya que se pide la máxima precisión posible, aunque double ocupe más espacio. 8 bytes
        String codigoFabricante; // Almacena el codigo del fabricante en una cadena. Ocupa 2 bytes
    }
}

// Para calcular la memoria que consumiria un objeto de la clase Marcapasos hay que sumar lo que ocupan todas sus variables.
// short(2)*3 + long(8) + float(4) + double(8) + String(2) = 28 bytes de memoria. 