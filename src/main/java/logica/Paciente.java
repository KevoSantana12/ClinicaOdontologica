package logica;

import java.util.Date;

public class Paciente extends Persona {
    private int id_paciente;
    private boolean tiene_OS;
    private String tipo_Sangre;

    public Paciente() {
    }

    public Paciente(int id_paciente, boolean tiene_OS, String tipo_Sangre, int id_Persona, String nombre, String apellido, String telefono, String direccion, Date fechaNacim) {
        super(id_Persona, nombre, apellido, telefono, direccion, fechaNacim);
        this.id_paciente = id_paciente;
        this.tiene_OS = tiene_OS;
        this.tipo_Sangre = tipo_Sangre;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

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
    
    
}
