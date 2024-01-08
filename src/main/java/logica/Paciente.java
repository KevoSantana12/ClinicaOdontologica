package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Paciente extends Persona {
    @Column
    private boolean tiene_OS;
    private String tipo_Sangre;
    
    //Relacion cita
    //1 to N
    @OneToMany(mappedBy="paciente")
    private List<Cita> cita;
    
    //Relacion Responsable
    //1 to 1
    @OneToOne
    private Responsable responsable;

    public Paciente() {
    }

    public Paciente(boolean tiene_OS, String tipo_Sangre, ArrayList<Cita> cita, Responsable responsable, String nombre, int id, String apellido, String telefono, String direccion, Date fechaNacim) {
        super(nombre, id, apellido, telefono, direccion, fechaNacim);
        this.tiene_OS = tiene_OS;
        this.tipo_Sangre = tipo_Sangre;
        this.cita = cita;
        this.responsable = responsable;
    }

//    public int getId_paciente() {
//        return id_paciente;
//    }
//
//    public void setId_paciente(int id_paciente) {
//        this.id_paciente = id_paciente;
//    }

    public boolean isTiene_OS() {
        return tiene_OS;
    }

    public void setTiene_OS(boolean tiene_OS) {
        this.tiene_OS = tiene_OS;
    }

    public String getTipo_Sangre() {
        return tipo_Sangre;
    }

    public void setTipo_Sangre(String tipo_Sangre) {
        this.tipo_Sangre = tipo_Sangre;
    }

    public List<Cita> getCita() {
        return cita;
    }

    public void setCita(ArrayList<Cita> cita) {
        this.cita = cita;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }
    
    
}
