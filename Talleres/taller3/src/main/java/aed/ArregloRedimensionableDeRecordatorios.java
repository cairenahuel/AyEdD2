package aed;

class ArregloRedimensionableDeRecordatorios implements SecuenciaDeRecordatorios {
    Recordatorio[] data;
    public ArregloRedimensionableDeRecordatorios() {
    data=new Recordatorio[0];
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        Recordatorio[] nuevo=new Recordatorio[vector.longitud()];
        for (int i = 0; i < nuevo.length; i++) {
            nuevo[i]=vector.obtener(i);    
        }
        data=nuevo;
    }

    public int longitud() {
        return data.length;
    }

    public void agregarAtras(Recordatorio i) {
        Recordatorio[] nuevo;
        nuevo=new Recordatorio[data.length+1];
        for (int j = 0; j < data.length; j++) {
            nuevo[j]=data[j];
        }
        nuevo[nuevo.length-1]=i;
        data=nuevo;
    }

    public Recordatorio obtener(int i) {
        return data[i];
    }

    public void quitarAtras() {
        Recordatorio[] nuevo=new Recordatorio[data.length-1];
        for (int i = 0; i < nuevo.length; i++) {
            nuevo[i]=data[i];
        }
        data=nuevo;
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        data[indice]=valor;
    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        ArregloRedimensionableDeRecordatorios copia = new ArregloRedimensionableDeRecordatorios();
        for (int i = 0; i < data.length; i++) {
            copia.agregarAtras(data[i]);
        }
        return copia;
    }

}
