package aed;

public class Agenda {
    Fecha fecha;
    ArregloRedimensionableDeRecordatorios data;
    public Agenda(Fecha fechaActual) {
        fecha=new Fecha(fechaActual);
        data=new ArregloRedimensionableDeRecordatorios();
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        data.agregarAtras(recordatorio);
    }

    @Override
    public String toString() {
        String agenda="";
        agenda=agenda+String.format("%s\n", fecha);
        agenda=agenda+"=====\n";
        for (int i=0; i<data.longitud();i++){
            if(data.obtener(i).fecha().equals(fecha)){
            agenda=agenda+String.format("%s\n",data.obtener(i).toString());
            }
        }
        return agenda;
    }

    public void incrementarDia() {
        fecha.incrementarDia();
    }

    public Fecha fechaActual() {
        return fecha;
    }

}
