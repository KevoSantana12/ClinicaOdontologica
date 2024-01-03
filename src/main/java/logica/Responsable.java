package logica;

import java.util.Date;

public class Responsable extends Persona {
    private int id_Responsable;
    private String Tipo;

    public Responsable(int id_Responsable, String Tipo) {
        this.id_Responsable = id_Responsable;
        this.Tipo = Tipo;
    }

    public Responsable(int id_Responsable, String Tipo, int id_Persona, String nombre, String apellido, String telefono, String direccion, Date fechaNacim) {
        super(id_Persona, nombre, apellido, telefono, direccion, fechaNacim);
        this.id_Responsable = id_Responsable;
        this.Tipo = Tipo;
    }

    public int getId_Responsable() {
        return id_Responsable;
    }

    public void setId_Responsable(int id_Responsable) {
        this.id_Responsable = id_Responsable;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    
    
}
