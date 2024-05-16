package aed;

public class Fecha {
    private int dia;
    private int mes;
    public Fecha(int dia, int mes) {
        this.dia=dia;
        this.mes=mes;
    }

    public Fecha(Fecha fecha) {
        dia=fecha.dia();
        mes=fecha.mes();
    }

    public Integer dia() {
        return dia;
    }

    public Integer mes() {
        return mes;
    }

    public String toString() {
        return String.format("%d/%d", dia,mes);
    }

    @Override
    public boolean equals(Object otra) {
        boolean oen = otra==null;
        boolean oc = otra.getClass()!=this.getClass();
        if (oen || oc) {
            return false;
        }else{
            Fecha otraFecha = (Fecha) otra;
            return this.dia==otraFecha.dia() && this.mes==otraFecha.mes;
        }
        
    }

    public void incrementarDia() {
        if (dia!=diasEnMes(mes)){
            dia++;
        }else if(dia==diasEnMes(mes)&&mes!=12){
            dia=1;
            mes++;
        }else{
            dia=1;
            mes=1;
        }
    }

    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes - 1];
    }

}
