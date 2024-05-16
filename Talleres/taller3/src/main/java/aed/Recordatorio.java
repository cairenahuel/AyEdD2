package aed;

public class Recordatorio {
    private String msg;
    private Fecha fecha;
    private Horario horario;
    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        this.msg=new String(mensaje);
        this.fecha=new Fecha(fecha);
        this.horario=horario;
    }

    public Horario horario() {
        return this.horario;
    }

    public Fecha fecha() {
        Fecha nueva = new Fecha(this.fecha);
        return nueva;
    }

    public String mensaje() {
        return this.msg;
    }

    @Override
    public String toString() {
        return String.format("%s @ %s %s", this.mensaje(), this.fecha().toString(), this.horario().toString());
    }

    @Override
    public boolean equals(Object otro) {
        boolean oes=otro==null;
        boolean oc=otro.getClass()!=this.getClass();
        if(oes||oc){
            return false;
        }
        Recordatorio otroR = (Recordatorio)otro;
        return ((this.mensaje().equals(otroR.mensaje()))&&
                (this.fecha().equals(otroR.fecha()))&&
                (this.horario().equals(otroR.horario())));
    }

}
