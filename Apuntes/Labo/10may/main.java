package aed;

import java.util.*;
import java.io.*;

class ListaDeInts {
    private Nodo primero;

    private class Nodo {
        int valor;
        Nodo siguiente;

        public void Nodo(int valor) {
            this.valor = valor;
            this.siguiente = null;
        }

        public Object value() {
            return this.value;
        }

        public void asignar(int n) {
            this.valor = n;
        }

        public void redireccionar(Nodo d) {
            siguiente = d;
        }

        public Nodo siguiente() {
            return siguiente;
        }
    }

    public ListaDeInts() {
        primero = null;
        size = 0;
    }

    public void agregarAdelante(int elem) {
        Nodo nuevo = new Nodo(elem);
        nuevo.siguiente = primero;
        this.primero = nuevo;
        this.size++;
    }

    public void agregarAtras(int elem) {
        Nodo nuevo = new Nodo(elem);
        Nodo actual = primero;
        while (actual.siguiente() == null) {
            actual = actual.siguiente();
        }
        actual.siguiente = nuevo;
    }

    public static void main() {
        ListaDeInts l = new ListaDeInts();
        System.out.println(l);
        l.agregarAdelante(7);
        System.out.println(l);
    }
}