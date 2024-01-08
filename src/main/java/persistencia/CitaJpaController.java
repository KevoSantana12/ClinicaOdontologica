/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Cita;
import logica.Odontologo;
import logica.Paciente;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Klins
 */
public class CitaJpaController implements Serializable {

    public CitaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public CitaJpaController(){
        emf = Persistence.createEntityManagerFactory("com.santanaPro_consultorioODontologico_war_1PU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cita cita) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Odontologo odontologo = cita.getOdontologo();
            if (odontologo != null) {
                odontologo = em.getReference(odontologo.getClass(), odontologo.getId());
                cita.setOdontologo(odontologo);
            }
            Paciente paciente = cita.getPaciente();
            if (paciente != null) {
                paciente = em.getReference(paciente.getClass(), paciente.getId());
                cita.setPaciente(paciente);
            }
            em.persist(cita);
            if (odontologo != null) {
                odontologo.getCitas().add(cita);
                odontologo = em.merge(odontologo);
            }
            if (paciente != null) {
                paciente.getCita().add(cita);
                paciente = em.merge(paciente);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cita cita) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cita persistentCita = em.find(Cita.class, cita.getId_cita());
            Odontologo odontologoOld = persistentCita.getOdontologo();
            Odontologo odontologoNew = cita.getOdontologo();
            Paciente pacienteOld = persistentCita.getPaciente();
            Paciente pacienteNew = cita.getPaciente();
            if (odontologoNew != null) {
                odontologoNew = em.getReference(odontologoNew.getClass(), odontologoNew.getId());
                cita.setOdontologo(odontologoNew);
            }
            if (pacienteNew != null) {
                pacienteNew = em.getReference(pacienteNew.getClass(), pacienteNew.getId());
                cita.setPaciente(pacienteNew);
            }
            cita = em.merge(cita);
            if (odontologoOld != null && !odontologoOld.equals(odontologoNew)) {
                odontologoOld.getCitas().remove(cita);
                odontologoOld = em.merge(odontologoOld);
            }
            if (odontologoNew != null && !odontologoNew.equals(odontologoOld)) {
                odontologoNew.getCitas().add(cita);
                odontologoNew = em.merge(odontologoNew);
            }
            if (pacienteOld != null && !pacienteOld.equals(pacienteNew)) {
                pacienteOld.getCita().remove(cita);
                pacienteOld = em.merge(pacienteOld);
            }
            if (pacienteNew != null && !pacienteNew.equals(pacienteOld)) {
                pacienteNew.getCita().add(cita);
                pacienteNew = em.merge(pacienteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = cita.getId_cita();
                if (findCita(id) == null) {
                    throw new NonexistentEntityException("The cita with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cita cita;
            try {
                cita = em.getReference(Cita.class, id);
                cita.getId_cita();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cita with id " + id + " no longer exists.", enfe);
            }
            Odontologo odontologo = cita.getOdontologo();
            if (odontologo != null) {
                odontologo.getCitas().remove(cita);
                odontologo = em.merge(odontologo);
            }
            Paciente paciente = cita.getPaciente();
            if (paciente != null) {
                paciente.getCita().remove(cita);
                paciente = em.merge(paciente);
            }
            em.remove(cita);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cita> findCitaEntities() {
        return findCitaEntities(true, -1, -1);
    }

    public List<Cita> findCitaEntities(int maxResults, int firstResult) {
        return findCitaEntities(false, maxResults, firstResult);
    }

    private List<Cita> findCitaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cita.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Cita findCita(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cita.class, id);
        } finally {
            em.close();
        }
    }

    public int getCitaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cita> rt = cq.from(Cita.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
