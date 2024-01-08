package logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Odontologo extends Persona implements Serializable {
    @Column
    private String especialidad;
    
    //Relacion Horarios
    //1 to 1
    @OneToOne
    private Horario horario;
    
    
    //Relacion Cita
    //1 to n
    @OneToMany(mappedBy="odontologo")
    private List <Cita> citas;

    
    //Relacion Usuario;
    //1 to 1
    @OneToOne
    private Usuario usuario;
    
    public Odontologo() {
    }

    public Odontologo(String especialidad, Horario horario, ArrayList<Cita> citas, Usuario usuario, String nombre, int id, String apellido, String telefono, String direccion, Date fechaNacim) {
        super(nombre, id, apellido, telefono, direccion, fechaNacim);
        this.especialidad = especialidad;
        this.horario = horario;
        this.citas = citas;
        this.usuario = usuario;
    }

//    public int getId_Odontologo() {
//        return id_Odontologo;
//    }
//
//    public void setId_Odontologo(int id_Odontologo) {
//        this.id_Odontologo = id_Odontologo;
//    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(ArrayList<Cita> citas) {
        this.citas = citas;
    }

    

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
