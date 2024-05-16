package aed;
public class Horario {
    private int hora;
    private int min;
    public Horario(int hora, int minutos) {
        this.hora=hora;
        this.min=minutos;
    }

    public int hora() {
        return this.hora;
    }

    public int minutos() {
        return this.min;
    }

    @Override
    public String toString() {
        return String.format("%d:%d",this.hora(),this.minutos());
    }

    @Override
    public boolean equals(Object otro) {
        boolean oen = otro==null;
        boolean oc = otro.getClass()!=this.getClass();
        if (oc || oen){
            return false;
        }
        Horario otroHorario = (Horario) otro;
        // return (this.hora==otroHorario.hora()&&this.min==otroHorario.minutos());
        return (this.hora()==otroHorario.hora()&&this.minutos()==otroHorario.minutos());

    }

}