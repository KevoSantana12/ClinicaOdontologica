package logica;

import java.util.Date;

public class Horario {
    private int id_horario;
    private Date hora_entrada;
    private Date hora_salidad;
    
    //Relacion Odontologo
    //1 to 1
    private Odontologo odontologo;
    
    //Relacion secretario
    //1 to 1
    private Secretario secretario;

    public Horario() {
    }

    public Horario(int id_horario, Date hora_entrada, Date hora_salidad, Odontologo odontologo, Secretario secretario) {
        this.id_horario = id_horario;
        this.hora_entrada = hora_entrada;
        this.hora_salidad = hora_salidad;
        this.odontologo = odontologo;
        this.secretario = secretario;
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

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public Secretario getSecretario() {
        return secretario;
    }

    public void setSecretario(Secretario secretario) {
        this.secretario = secretario;
    }
    
    
}
