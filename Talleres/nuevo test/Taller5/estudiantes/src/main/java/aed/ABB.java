package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    Nodo raiz;
    int cardinal=0;

    private class Nodo {
        Nodo padre;
        Nodo izq;
        Nodo der;
        T val;
        int cardinal = 1;

        public Nodo() {
            cardinal = 0;
        }

        public Nodo(T valor, Nodo padre, Nodo izq, Nodo der) {
            val = valor;
            this.padre = padre;
            this.izq = izq;
            this.der = der;
        }

        @Override
        public String toString() {
            return val.toString();
        }

        public Nodo maximo() {
            Nodo actual = this;
            while (actual.der != null) {
                actual = actual.der;
            }
            return actual;
        }

        public Nodo minimo() {
            Nodo actual = this;
            while (actual.izq != null) {
                actual = actual.izq;
            }
            return actual;
        }
    }

    public ABB() {
        raiz = null;
    }

    public int cardinal() {
        return cardinal;
    }

    public T minimo() {
        Nodo actual=raiz;
        while (actual.izq!=null) {
            actual=actual.izq;
        }
        return actual.val;
    }

    public T maximo() {
        Nodo actual=raiz;
        while (actual.der!=null) {
            actual=actual.der;
        }
        return actual.val;
    }

    public Nodo buscarNodo(T elem, Nodo desde) {
        Nodo actual = desde;
        while (actual != null) {
            if (elem.compareTo(actual.val) > 0) {
                if (actual.der == null) {
                    return null;
                } else {
                    actual = actual.der;
                }
            } else if (elem.compareTo(actual.val) < 0) {
                if (actual.izq == null) {
                    return null;
                } else {
                    actual = actual.izq;
                }
            } else if (elem.compareTo(actual.val) == 0) {
                return actual;
            }
        }
        return null;
    }

    public void insertar(T elem) {
        if (raiz == null) {
            raiz= new Nodo(elem,null,null,null);
            cardinal += 1;
        } else {
            Nodo actual = raiz;
            while (actual != null) {
                if (elem.compareTo(actual.val) > 0) {
                    if (actual.der == null) {
                        Nodo nuevo = new Nodo(elem, actual, null, null);
                        cardinal+=1;
                        actual.der = nuevo;
                        return;
                    } else {
                        actual = actual.der;
                    }
                } else if (elem.compareTo(actual.val) < 0) {
                    if (actual.izq == null) {
                        Nodo nuevo = new Nodo(elem, actual, null, null);
                        cardinal+=1;
                        actual.izq = nuevo;
                        return;
                    } else {
                        actual = actual.izq;
                    }
                } else if (elem.compareTo(actual.val) == 0) {
                    return;
                }
            }
        }
    }

    public void sumar_uno_a_todos_los_padres(Nodo nodo) {
        Nodo actual = nodo;
        while (actual != null) {
            if (actual.padre == null) {
                actual.cardinal += 1;
                break;
            }
            actual.cardinal += 1;
            actual = actual.padre;
        }
    }

    public boolean pertenece(T elem) {
        return buscarNodo(elem, raiz) != null;
    }

    public Nodo minimoDesde(Nodo desde) {
        Nodo actual = desde;
        while (actual.izq != null) {
            actual = actual.izq;
        }
        return actual;
    }

    public Nodo maximoDesde(Nodo desde) {
        Nodo actual = desde;
        while (actual.der != null) {
            actual = actual.der;
        }
        return actual;
    }

    public void eliminar(T elem) {
        Nodo nodo = buscarNodo(elem, raiz);
        eliminarNodo(nodo);
        cardinal-=1;
    }

    public void eliminarNodo(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        boolean tengoHijoDerecho = nodo.der != null;
        boolean tengoHijoIzquierda = nodo.izq != null;
        boolean hoja = nodo.der == null && nodo.izq == null;
        boolean dosHijos = nodo.der != null && nodo.izq != null;
        boolean unHijo = !hoja && !dosHijos;
        if (nodo==raiz) {
            if (hoja) {
                raiz=null;
            }else if (unHijo) {
                if (nodo.der!=null) { //si tengo un hijo derecho
                    raiz=nodo.der;
                    raiz.padre=null;
                }else{ //si el hijo es el izquierdo
                    raiz=nodo.izq;
                    raiz.padre=null;
                }
            }else if(dosHijos){
                    Nodo minimo=minimoDesde(nodo.der); //el mas chico de los mas grandes
                    eliminarNodo(minimo);
                    nodo.val=minimo.val;
            }}else{
                if (hoja) {
                    if (nodo.padre.der==nodo) { //si soy el derecho
                        nodo.padre.der=null;
                    }else{ //si soy el izquierdo
                        nodo.padre.izq=null;
                    }
                }else if(unHijo){
                    if (nodo.der!=null) { //si tengo un hijo derecho
                        if (nodo.padre.der==nodo) {
                            nodo.der.padre=nodo.padre;
                            nodo.padre.der=nodo.der;
                        }else{
                            nodo.der.padre=nodo.padre;
                            nodo.padre.izq=nodo.der;
                        }
                    }else{                  //SI TENGO HIJO IZQUIERDO
                        if (nodo.padre.izq==nodo) { //si soy el hijo izquierdo
                            nodo.izq.padre=nodo.padre;
                            nodo.padre.izq=nodo.izq;
                        }else{
                            nodo.padre.der=nodo.izq;
                            nodo.izq.padre=nodo.padre;
                        }
                    }
                }else if (dosHijos) {
                    Nodo minimoMayor=minimoDesde(nodo.der);
                    eliminarNodo(minimoMayor);
                    nodo.val=minimoMayor.val;
                }
            }
        }

    public Nodo sucesor(Nodo nodo){
        Nodo falsoYo=nodo;
        if (nodo.der!=null) {
            return minimoDesde(nodo.der);
        }
        Nodo y=nodo.padre;
        while (y!=null&&falsoYo==y.der) {
            falsoYo=y;
            y=y.padre;
        }
        return y;
    }

    public String toString() {
        String res="{";
        Iterador<T> it=iterador();
        while (it.haySiguiente()) {
            res+=it.siguiente();
            res+=",";
        }
        return res+maximo()+"}";
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo actual=minimoDesde(raiz);
        public boolean haySiguiente() {
            return actual.val!=maximo();
        }

        public T siguiente() {
            T res=actual.val;
            actual=sucesor(actual);
            return res;
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }
}
