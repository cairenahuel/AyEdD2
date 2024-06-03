public class Main {
    public class ABB<T extends Comperable<T>> implements Conjunto<T>{
        Nodo raiz;
        //private int _cardinal;
        //private int _altura;
        public ABB(){
            raiz=null;
            //  cardinal  
            //  altura
        }
    }
    private class Nodo<T extends Comparable<T>>{
        T valor;
        Nodo izq;
        Nodo der;
        Nodo padre;
        Nodo(T v){
            valor= v;
            izq = null;
            der = null;
            padre = null;
        }
    }
    public boolean pertenece(T elemento){
        if(this.valor<elemento){
            raiz.der.pertenece(elemento);
        }else if(valor>elemento){
            raiz.izq.pertenece(elemento);
        }
        return this.valor==elemento;
    }
    public void insertar(T elemento){
        if (valor==elemento){
            return;
        }
        if(valor<elemento){
            if(raiz.izquierda!=null){
                raiz.izquierda.insertar(elemento);
            }else{
                Nodo nuevo = new Nodo(elemento);
                nuevo.padre=this;
                raiz.izquierda=nuevo;
            }
        }else if(valor>elemento){
            if(raiz.derecha!=null){
                raiz.derecha.insertar(elemento);
            }else{
                Nodo nuevo = new Nodo(elemento);
                nuevo.padre=this;
                raiz.derecha=nuevo;
        }}
    }
    public static void main(String[] args){
    System.out.println("hola pa");
    }
}
