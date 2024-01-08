package logica;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Secretario extends Persona {
    @Column
    private String Sector;
    
    //Relacion Usuario
    //1 to 1
    @OneToOne
    private Usuario usuario;

    public Secretario() {
    }

    public Secretario(String Sector, Usuario usuario, String nombre, int id, String apellido, String telefono, String direccion, Date fechaNacim) {
        super(nombre, id, apellido, telefono, direccion, fechaNacim);
        this.Sector = Sector;
        this.usuario = usuario;
    }

//    public int getId_secretario() {
//        return id_secretario;
//    }
//
//    public void setId_secretario(int id_secretario) {
//        this.id_secretario = id_secretario;
//    }

    public String getSector() {
        return Sector;
    }

    public void setSector(String Sector) {
        this.Sector = Sector;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
