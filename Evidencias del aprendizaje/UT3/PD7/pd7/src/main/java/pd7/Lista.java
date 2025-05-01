package pd7;

public class Lista<T> implements ILista<T>{

    private Nodo <T> primero;

    public Lista() {
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


}


