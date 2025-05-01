package pd7;

public class Conjunto<T> implements IConjunto<T> {

    private Nodo<T> primero;

    public Conjunto() {
        primero = null;
    }

    
    public void insertar(Comparable clave, T dato){
        Nodo nuevoNodo = new Nodo<>(clave, dato);
        if (esVacia()){
            primero = nuevoNodo;
        }else {
            INodo<T> aux = primero;
            while (aux.getSiguiente()!= null){
                aux = aux.getSiguiente(); 
            }
            aux.setSiguiente(nuevoNodo); 
        }
    }
    public T buscar(Comparable clave){
        if (esVacia()){
            return null;
        }else{
            INodo<T> aux = primero;
            while (aux != null){
                aux = aux.getSiguiente();
                if (aux.getEtiqueta().equals(clave)){
                    return aux.getDato();
                }
                aux = aux.getSiguiente();
            }
        }
        return null;
    }

    public boolean eliminar(T dato){
        if (esVacia()){
            return false;
        }
        
        INodo<T> aux = primero;
        if (aux.getDato().equals(dato)){
                primero = aux.getSiguiente();
                return true;
            }

        INodo<T> actual = primero.getSiguiente();
            
        while(actual != null){
            if (actual.getDato().equals(dato)){
                aux.setSiguiente(actual.getSiguiente());
                return true;
            }
            aux = actual;
            actual = actual.getSiguiente();
        }  
        return false;
    }

    public String imprimir(){
        if (esVacia()){
            return "La lista no tiene elementos";
        }
        
        StringBuilder builder = new StringBuilder();
        INodo<T> aux = primero;
        while (aux!= null){
            builder.append(aux.getEtiqueta()).append(" ");
            aux = aux.getSiguiente();
        }
        return builder.toString();
    }

    public String imprimir(String separador){
        StringBuilder builder = new StringBuilder();
        INodo<T> aux = primero;
        while (aux!=null){
            builder.append(aux.getEtiqueta()).append(separador);
            aux = aux.getSiguiente();
        }
        return builder.toString();
    }


    public int cantElementos(){
        int contador = 0; 
        if (esVacia()){
            return 0;
        }else {
            INodo<T> aux = primero;
            while (aux!=null){
                aux = aux.getSiguiente();
                contador += 1;
            }
        }
        return contador;
    }

    public boolean esVacia(){
        return primero == null;
    }

    public void setPrimero( Nodo<T> unNodo){
        INodo<T> aux = primero;
    }

    public void conjImprimir() {
        Nodo temporal = primero;
        while (temporal != null) {
            System.out.println(temporal.getEtiqueta().toString());
            temporal = temporal.getSiguiente();
        }
    }

    public boolean buscarC(Comparable clave){
        Nodo temporal = primero;
        while (temporal!=null){
            if (clave.compareTo(temporal.getEtiqueta()) == 0)
                return true;
            temporal = temporal.getSiguiente();
            }
        return false;
        }
    
    public void insertarC(Nodo<T> nodo) {
        if (primero == null)
            primero = nodo;
        else {
            Nodo temporal = primero;
            while (temporal.getSiguiente() != null) {
                temporal = temporal.getSiguiente();
            }
            temporal.setSiguiente(nodo);
        }
    }

    
   
    public Conjunto<T> opUnion(Conjunto<T> conjunto1, Conjunto<T> conjunto2) {
        Conjunto<T> conjuntoResultado = new Conjunto<>();
        Nodo temporal = conjunto1.primero;
        while (temporal != null) {
            System.out.println();
            Nodo nuevo = new Nodo<>(temporal.getEtiqueta(), temporal.getDato());
            conjuntoResultado.insertarC(nuevo);
            temporal = temporal.getSiguiente();
        }
        Nodo temporal2 = conjunto2.primero;
        while (temporal2 != null) {
            if (!conjuntoResultado.buscarC(temporal2.getEtiqueta())) {
                Nodo nuevo = new Nodo<>(temporal2.getEtiqueta(), temporal2.getDato());
                conjuntoResultado.insertarC(nuevo);
            }
            temporal2 = temporal2.getSiguiente();
        }
        return conjuntoResultado;
    }

    public Conjunto<T> opInterseccion(Conjunto<T> conjunto1, Conjunto<T> conjunto2) {
        Conjunto<T> conjuntoResultado2 = new Conjunto<>();
        Nodo temporal = conjunto1.primero;
        while (temporal != null) {
            if (conjunto2.buscarC(temporal.getEtiqueta())) {
                Nodo nuevo = new Nodo<>(temporal.getEtiqueta(), temporal.getDato());
                conjuntoResultado2.insertarC(nuevo);
            }
            temporal = temporal.getSiguiente();
        }
        return conjuntoResultado2;
    }

}
