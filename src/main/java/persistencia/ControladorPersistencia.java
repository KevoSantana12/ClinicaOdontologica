package persistencia;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Cita;
import logica.Horario;
import logica.Odontologo;
import logica.Paciente;
import logica.Responsable;
import logica.Secretario;
import logica.Usuario;
import persistencia.exceptions.NonexistentEntityException;

public class ControladorPersistencia {
    //CitaJpaController
    CitaJpaController CitaJPA = new CitaJpaController();
    public void crearCita(Cita cita){
        CitaJPA.create(cita);
    }
    public void eliminarCita(int id){
        try {
            CitaJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void editCita(Cita cita){
        try {
            CitaJPA.edit(cita);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Cita findCita(int id){
        return CitaJPA.findCita(id);
    }
    public ArrayList<Cita> findCitas(){
        List<Cita> Lista = CitaJPA.findCitaEntities();
        ArrayList<Cita> AR = new ArrayList<>(Lista);
        return AR;
    }
    //----------------------------------------------------------------------//
    
    
    //OdontologoJpaController
    OdontologoJpaController OdontoJPA = new OdontologoJpaController();
    public void crearOdontologo(Odontologo odon){
        OdontoJPA.create(odon);
    }
    public void eliminarOdonto(int id){
        try {
            OdontoJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void editOdonto(Odontologo odonto){
        try {
            OdontoJPA.edit(odonto);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Odontologo findOdonto(int id){
        return OdontoJPA.findOdontologo(id);
    }
    public ArrayList<Odontologo> findOdontologos(){
        List<Odontologo> Lista = OdontoJPA.findOdontologoEntities();
        ArrayList<Odontologo> AR = new ArrayList<>(Lista);
        return AR;
    }
    //----------------------------------------------------------------------//
    
    
    //HorarioJpaController
    HorarioJpaController HorarioJPA = new HorarioJpaController();
    public void crearHorario(Horario horario){
        HorarioJPA.create(horario);
    }
    public void eliminarHorario(int id){
        try {
            HorarioJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void editHorario(Horario horario){
        try {
            HorarioJPA.edit(horario);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Horario findHorario(int id){
        return HorarioJPA.findHorario(id);
    }
    public ArrayList<Horario> findHorarios(){
        List<Horario> Lista = HorarioJPA.findHorarioEntities();
        ArrayList<Horario> AR = new ArrayList<>(Lista);
        return AR;
    }
    //----------------------------------------------------------------------//
    
    //PacienteJpaController 
    PacienteJpaController PacienteJPA = new PacienteJpaController();
    public void crearPaciente(Paciente paciente){
        PacienteJPA.create(paciente);
    }
    public void eliminarPaciente(int id){
        try {
            PacienteJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void editPaciente(Paciente paciente){
        try {
            PacienteJPA.edit(paciente);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Paciente findPaciente(int id){
        return PacienteJPA.findPaciente(id);
    }
    public ArrayList<Paciente> findPacientes(){
        List<Paciente> Lista = PacienteJPA.findPacienteEntities();
        ArrayList<Paciente> AR = new ArrayList<>(Lista);
        return AR;
    }
    //----------------------------------------------------------------------//

    
    
    //PersonaJpaController
    PersonaJpaController PersonaJPA = new PersonaJpaController();
    //----------------------------------------------------------------------//
    
    //ResponsableJpaController
    ResponsableJpaController RespoJPA = new ResponsableJpaController();
    public void crearResponsable(Responsable responsable){
        RespoJPA.create(responsable);
    }
    public void eliminarResponsable(int id){
        try {
            RespoJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void editResponsable(Responsable responsable){
        try {
            RespoJPA.edit(responsable);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Responsable findResponsable(int id){
        return RespoJPA.findResponsable(id);
    }
    public ArrayList<Responsable> findResponsables(){
        List<Responsable> Lista = RespoJPA.findResponsableEntities();
        ArrayList<Responsable> AR = new ArrayList<>(Lista);
        return AR;
    }
    //----------------------------------------------------------------------//
    
    //SecretarioJpaController
    SecretarioJpaController SecJPA = new SecretarioJpaController();
    public void crearSecretario(Secretario secre){
        SecJPA.create(secre);
    }
    public void eliminarSecretario(int id){
        try {
            SecJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void editSecretario(Secretario secre){
        try {
            SecJPA.edit(secre);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Secretario findSecretario(int id){
        return SecJPA.findSecretario(id);
    }
    public ArrayList<Secretario> findSecretarios(){
        List<Secretario> Lista = SecJPA.findSecretarioEntities();
        ArrayList<Secretario> AR = new ArrayList<>(Lista);
        return AR;
    }
    //----------------------------------------------------------------------//
    
    
    //UsuarioJpaController 
    UsuarioJpaController UsuarioJPA = new UsuarioJpaController();
    public void crearUsuario(Usuario usu){
        UsuarioJPA.create(usu);
    }
    public void eliminarUsuario(int id){
        try {
            UsuarioJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void editUsuario(Usuario usu){
        try {
            UsuarioJPA.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Usuario findUsuario(int id){
        return UsuarioJPA.findUsuario(id);
    }
    public ArrayList<Usuario> findUsuarios(){
        List<Usuario> Lista = UsuarioJPA.findUsuarioEntities();
        ArrayList<Usuario> AR = new ArrayList<>(Lista);
        return AR;
    }
    //----------------------------------------------------------------------//
}

