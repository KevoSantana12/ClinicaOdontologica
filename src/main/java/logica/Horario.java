package logica;

import java.util.Date;

public class Horario {
    private int id_horario;
    private Date hora_entrada;
    private Date hora_salidad;

    public Horario() {
    }

    public Horario(int id_horario, Date hora_entrada, Date hora_salidad) {
        this.id_horario = id_horario;
        this.hora_entrada = hora_entrada;
        this.hora_salidad = hora_salidad;
    }

    public int getId_horario() {
        return id_horario;
    }

    public void setId_horario(int id_horario) {
        this.id_horario = id_horario;
    }

    public Date getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(Date hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public Date getHora_salidad() {
        return hora_salidad;
    }

    public void setHora_salidad(Date hora_salidad) {
        this.hora_salidad = hora_salidad;
    }
    
    
}
