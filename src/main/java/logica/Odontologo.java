package logica;

import java.util.Date;

public class Odontologo extends Persona {
    private int id_Odontologo;
    private String especialidad;

    public Odontologo() {
    }

    public Odontologo(int id_Odontologo, String especialidad, int id_Persona, String nombre, String apellido, String telefono, String direccion, Date fechaNacim) {
        super(id_Persona, nombre, apellido, telefono, direccion, fechaNacim);
        this.id_Odontologo = id_Odontologo;
        this.especialidad = especialidad;
    }

    public int getId_Odontologo() {
        return id_Odontologo;
    }

    public void setId_Odontologo(int id_Odontologo) {
        this.id_Odontologo = id_Odontologo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    
}
