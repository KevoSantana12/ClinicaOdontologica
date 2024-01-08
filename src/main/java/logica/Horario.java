package logica;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Horario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_horario;
    @Column
    private String hora_entrada;
    private String hora_salidad;
    
    public Horario() {
    }

    public Horario(int id_horario, String hora_entrada, String hora_salidad) {
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

    public String getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(String hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public String getHora_salidad() {
        return hora_salidad;
    }

    public void setHora_salidad(String hora_salidad) {
        this.hora_salidad = hora_salidad;
    }  
}
