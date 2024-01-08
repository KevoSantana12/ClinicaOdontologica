package logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Cita implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_cita;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column
    private String hora;
    private String afeccion;
    
    //n to 1
    @ManyToOne
    @JoinColumn(name="id_odontologo")
    private Odontologo odontologo;
    
    //n to 1
    @ManyToOne
    @JoinColumn(name="id_paciente")
    private Paciente paciente;

    public Cita() {
    }

    public Cita(int id_cita, Date fecha, String hora, String afeccion, Odontologo odontologo, Paciente paciente) {
        this.id_cita = id_cita;
        this.fecha = fecha;
        this.hora = hora;
        this.afeccion = afeccion;
        this.odontologo = odontologo;
        this.paciente = paciente;
    }

    
    
    public int getId_cita() {
        return id_cita;
    }

    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getAfeccion() {
        return afeccion;
    }

    public void setAfeccion(String afeccion) {
        this.afeccion = afeccion;
    }
    
    
    
}
