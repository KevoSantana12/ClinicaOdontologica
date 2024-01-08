package logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
public class Responsable extends Persona implements Serializable {
    @Column
    private String Tipo;
    

    public Responsable() {
    }

    public Responsable(String Tipo, String nombre, int id, String apellido, String telefono, String direccion, Date fechaNacim) {
        super(nombre, id, apellido, telefono, direccion, fechaNacim);
        this.Tipo = Tipo;
    }
    
//
//    public int getId_Responsable() {
//        return id_Responsable;
//    }
//
//    public void setId_Responsable(int id_Responsable) {
//        this.id_Responsable = id_Responsable;
//    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
}
