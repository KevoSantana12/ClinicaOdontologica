package logica;

import java.util.ArrayList;
import persistencia.ControladorPersistencia;

public class ControladoraLogica {
    ControladorPersistencia ControlPersis = new ControladorPersistencia();
    //Cita Crud
//    public void crearCita(Cita cita){
//        ControlPersis.crearCita(cita);
//    }
//    public void eliminarCita(int id){
//        ControlPersis.eliminarCita(id);
//    }
//    public Cita findCita(int id){
//        return ControlPersis.findCita(id);
//    }
//    public ArrayList<Cita> findCitas(){
//        return ControlPersis.findCitas();
//   }
   //----------------------------------------------------------------------//

    //Horario Crud
    public void crearHorario(Horario horario){
        ControlPersis.crearHorario(horario);
    }
    public void eliminarHorario(int id){
        ControlPersis.eliminarHorario(id);
    }
    public Horario findHorario(int id){
        return ControlPersis.findHorario(id);
    }
    public ArrayList<Horario> findHorarios(){
        return ControlPersis.findHorarios();
   }
   //----------------------------------------------------------------------//
    
   //Odontologo CRUD
    public void crearOdontologo(Odontologo odonto){
        ControlPersis.crearOdontologo(odonto);
    }
    public void eliminarOdontologo(int id){
        ControlPersis.eliminarOdonto(id);
    }
    public Odontologo find(int id){
        return ControlPersis.findOdonto(id);
    }
    public ArrayList<Odontologo> findOdontologos(){
        return ControlPersis.findOdontologos();
   }
   //----------------------------------------------------------------------//

   //Paciente CRUD
//    public void crearPaciente(Paciente paciente){
//        ControlPersis.crearPaciente(paciente);
//    }
//    public void eliminarPaciente(int id){
//        ControlPersis.eliminarPaciente(id);
//    }
//    public Paciente findPaciente(int id){
//        return ControlPersis.findPaciente(id);
//    }
//    public ArrayList<Paciente> findPaciente(){
//        return ControlPersis.findPacientes();
//   }
   //----------------------------------------------------------------------//
    
   //Responsable CRUD
//    public void crearResponsable(Responsable responsable){
//        ControlPersis.crearResponsable(responsable);
//    }
//    public void eliminarResponsable(int id){
//        ControlPersis.eliminarResponsable(id);
//    }
//    public Responsable findResponsable(int id){
//        return ControlPersis.findResponsable(id);
//    }
//    public ArrayList<Responsable> findResponsables(){
//        return ControlPersis.findResponsables();
//   }
   //----------------------------------------------------------------------//

   //Secretario CRUD
//    public void crearSecretario(Secretario secretario){
//        ControlPersis.crearSecretario(secretario);
//    }
//    public void eliminarSecretario(int id){
//        ControlPersis.eliminarSecretario(id);
//    }
//    public Secretario findSecretario(int id){
//        return ControlPersis.findSecretario(id);
//    }
//    public ArrayList<Secretario> findSecretarios(){
//        return ControlPersis.findSecretarios();
//   }
   //----------------------------------------------------------------------//  
    
    
   //Usuario CRUD
    public void crearUsuarios(Usuario usu){
        ControlPersis.crearUsuario(usu);
    }
    public void eliminarUsuario(int id){
        ControlPersis.eliminarUsuario(id);
    }
    public void editarUsuario(Usuario usu){
        ControlPersis.editUsuario(usu);
    }
            
    public Usuario findUsuario(int id){
        return ControlPersis.findUsuario(id);
    }
    public ArrayList<Usuario> findUsuarios(){
        return ControlPersis.findUsuarios();
   }
   //----------------------------------------------------------------------//     
}
