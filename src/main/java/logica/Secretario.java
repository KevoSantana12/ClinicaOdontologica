package logica;

import java.util.Date;

public class Secretario extends Persona {
    private int id_secretario;
    private String Sector;

    public Secretario(int id_secretario, String Sector) {
        this.id_secretario = id_secretario;
        this.Sector = Sector;
    }

    public Secretario(int id_secretario, String Sector, int id_Persona, String nombre, String apellido, String telefono, String direccion, Date fechaNacim) {
        super(id_Persona, nombre, apellido, telefono, direccion, fechaNacim);
        this.id_secretario = id_secretario;
        this.Sector = Sector;
    }

    public int getId_secretario() {
        return id_secretario;
    }

    public void setId_secretario(int id_secretario) {
        this.id_secretario = id_secretario;
    }

    public String getSector() {
        return Sector;
    }

    public void setSector(String Sector) {
        this.Sector = Sector;
    }
    
    
}
