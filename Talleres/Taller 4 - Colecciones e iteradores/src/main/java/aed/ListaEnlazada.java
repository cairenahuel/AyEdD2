package aed;

public class ListaEnlazada<T> implements Secuencia<T> {
    Nodo primero = null;
    Nodo ultimo = null;

    private class Nodo {
        private Nodo anterior;
        private Nodo siguiente;
        private T valor;

        public Nodo(T valor) {
            this.valor = valor;
        }

        public T obtener() {
            return valor;
        }

        public void cambiarSiguiente(Nodo nodo) {
            siguiente = nodo;
        }

        public void cambiarAnterior(Nodo nodo) {
            anterior = nodo;
        }

        public Nodo siguiente() {
            return siguiente;
        }

        public Nodo anterior() {
            return anterior;
        }
    }

    public ListaEnlazada() {
        primero = null;
        ultimo = null;
    }

    public int longitud() {
        Nodo actual = primero;
        int i = 0;
        while (actual != null) {
            i++;
            actual = actual.siguiente();
        }
        return i;
    }

    public void agregarAdelante(T elem) {
        Nodo nuevo = new Nodo(elem);
        // caso de un solo elemento
        if (primero == null) {
            primero = nuevo;
            ultimo = nuevo;
            return;
        } else {
            // el otro
            nuevo.cambiarSiguiente(primero);
            primero.cambiarAnterior(nuevo);
            nuevo.cambiarAnterior(null);
            primero = nuevo;
        }
    }

    public void agregarAtras(T elem) {
        Nodo nuevo = new Nodo(elem);
        if (ultimo == null) {
            ultimo = nuevo;
            if (primero == null) {
                primero = nuevo;
            }
            return;
        }
        nuevo.cambiarAnterior(ultimo);
        nuevo.cambiarSiguiente(null);
        ultimo.cambiarSiguiente(nuevo);
        ultimo = nuevo;
    }

    public T obtener(int i) {
        int j = 0;
        Nodo actual = primero;
        while (j < i) {
            actual = actual.siguiente();
            j++;
        }
        return actual.obtener();
    }

    public void eliminar(int i) {
        int k = 0;
        Nodo actual = primero;

        if (i == 0) {
            primero = primero.siguiente();
            if (primero != null) {
                primero.cambiarAnterior(null);
            } else {
                ultimo = null;
            }
        } else if (i == this.longitud() - 1) {
            ultimo = ultimo.anterior();
            ultimo.cambiarSiguiente(null);
        } else {
            while (k < i && actual != null) {
                actual = actual.siguiente();
                k++;
            }

            if (actual != null && actual.siguiente() != null) {
                actual.siguiente().cambiarAnterior(actual.anterior());
            }
            if (actual != null && actual.anterior() != null) {
                actual.anterior().cambiarSiguiente(actual.siguiente());
            }
        }
    }

    public void modificarPosicion(int indice, T elem) {
        int i = 0;
        Nodo actual = primero;
        while (i < indice && actual != null) {
            actual = actual.siguiente();
            i++;
        }
        actual.valor = elem;
    }

    public ListaEnlazada<T> copiar() {
        ListaEnlazada<T> copia = new ListaEnlazada<T>();
        int i = 0;
        while (i < this.longitud()) {
            copia.agregarAtras(this.obtener(i));
            i++;
        }
        return copia;
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        ListaEnlazada<T> nueva = new ListaEnlazada<T>();
        int i = 0;
        while (i < lista.longitud()) {
            nueva.agregarAtras(lista.obtener(i));
            i++;
        }
        this.primero=nueva.primero;
        this.ultimo=nueva.ultimo;
    }

    @Override
    public String toString() {
        String result="[";
        for (int i = 0; i < this.longitud()-1; i++) {
            result=result+this.obtener(i).toString()+", ";
        }
        result=result+ultimo.valor.toString()+"]";
        return result;
    }

private class ListaIterador implements Iterador<T> {
    Nodo actual = null;
    int dedito = 0;

    public boolean haySiguiente() {
        return dedito!=longitud();
    }

    public boolean hayAnterior() {
        return dedito!=0;
    }

    public T siguiente() {
        int i =dedito;
        dedito=dedito+1;
        return obtener(i);
    }

    public T anterior() {
        dedito=dedito-1;
        int i = dedito;
        return obtener(i);
    }
}

public Iterador<T> iterador() {
    ListaIterador iterador = new ListaIterador();
    return iterador;
}
}
