package org.example;

public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable etiqueta;
    private TElementoAB<T> hijoIzq;
    private TElementoAB<T> hijoDer;
    private T datos;

    public TElementoAB(Comparable etiqueta, T datos) {
        this.etiqueta = etiqueta;
        this.datos = datos;
        this.hijoIzq = null;
        this.hijoDer = null;
    }

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(Comparable etiqueta) {
        this.etiqueta = etiqueta;
    }

    @Override
    public TElementoAB<T> getHijoIzq() {
        return hijoIzq;
    }

    @Override
    public TElementoAB<T> getHijoDer() {
        return hijoDer;
    }

    @Override
    public void setHijoIzq(TElementoAB<T> elemento) {
        this.hijoIzq = elemento;
    }

    @Override
    public void setHijoDer(TElementoAB<T> elemento) {
        this.hijoDer = elemento;
    }

    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(etiqueta) == 0){
            return this;
        } else if (unaEtiqueta.compareTo(etiqueta) < 0 && hijoIzq != null) {
            return hijoIzq.buscar(unaEtiqueta);
        } else if (hijoDer != null) {
            return hijoDer.buscar(unaEtiqueta);
        }
        return null;
    }
//    @Override
//    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
//        if (unaEtiqueta.compareTo(etiqueta) == 0){
//            return this;
//        } else{
//            if (unaEtiqueta.compareTo(etiqueta) < 0){
//                if (hijoIzq != null){
//                    return hijoIzq.buscar(unaEtiqueta);
//                }else{
//                    return null;
//                }
//            }else{
//                if (unaEtiqueta.compareTo(etiqueta) > 0){
//                    if (hijoDer != null){
//                        return hijoDer.buscar(unaEtiqueta);
//                    }else{
//                        return null;
//                    }
//                }else{
//                    return null;
//                }
//            }
//        }
//    } este es el de las diapositivas de clase



    @Override
    public boolean insertar(TElementoAB<T> elemento) {
        if (elemento.getEtiqueta().compareTo(etiqueta) < 0){
            if (hijoIzq == null){
                hijoIzq = elemento;
                return true;
            }else {
                return hijoIzq.insertar(elemento);
            }
        } else if (elemento.getEtiqueta().compareTo(etiqueta) > 0) {
            if (hijoDer == null){
                hijoDer = elemento;
                return true;
            }else {
                return hijoDer.insertar(elemento);
            }

        }
        return false;
    }

    @Override
    public String preOrden() {
        StringBuilder sb = new StringBuilder();
        sb.append(etiqueta).append("-");
        if (hijoIzq != null){
            sb.append(hijoIzq.preOrden());
        }
        if (hijoDer != null){
            sb.append(hijoDer.preOrden());
        }
        return sb.toString();
    }

    @Override
    public String inOrden() {
        StringBuilder sb = new StringBuilder();
        if (hijoIzq != null){
            sb.append(hijoIzq.inOrden());
        }
        sb.append(etiqueta).append("-");
        if (hijoDer != null){
            sb.append(hijoDer.inOrden());
        }
        return sb.toString();
    }

    @Override
    public String postOrden() {
        StringBuilder sb = new StringBuilder();
        if(hijoIzq != null){
            sb.append(hijoIzq.postOrden());
        }
        if (hijoDer != null){
            sb.append(hijoDer.postOrden());
        }
        sb.append(etiqueta).append("-");
        return sb.toString();
    }

    @Override
    public T getDatos() {
        return datos;
    }

    @Override
    public TElementoAB<T> eliminar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                hijoIzq = hijoIzq.eliminar(unaEtiqueta);
            }
            return this;
        } else if (unaEtiqueta.compareTo(etiqueta) > 0) {
            if (hijoDer != null) {
                hijoDer = hijoDer.eliminar(unaEtiqueta);
            }
            return this;
        } else {
            return eliminarNodo();
        }
    }

    private TElementoAB<T> eliminarNodo() {
        if (hijoIzq == null) {
            return hijoDer;
        } else if (hijoDer == null) {
            return hijoIzq;
        } else {
            TElementoAB<T> elHijo = hijoIzq;
            TElementoAB<T> elPadre = this;
            while (elHijo.hijoDer != null) {
                elPadre = elHijo;
                elHijo = elHijo.hijoDer;
            }
            if (elPadre != this) {
                elPadre.hijoDer = elHijo.hijoIzq;
                elHijo.hijoIzq = hijoIzq;
            }
            elHijo.hijoDer = hijoDer;
            return elHijo;
        }
    }
}

