/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Cita;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.Odontologo;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Klins
 */
public class OdontologoJpaController implements Serializable {

    public OdontologoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
        
    public OdontologoJpaController(){
        emf = Persistence.createEntityManagerFactory("com.santanaPro_consultorioODontologico_war_1PU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Odontologo odontologo) {
        if (odontologo.getCitas() == null) {
            odontologo.setCitas(new ArrayList<Cita>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Cita> attachedCitas = new ArrayList<Cita>();
            for (Cita citasCitaToAttach : odontologo.getCitas()) {
                citasCitaToAttach = em.getReference(citasCitaToAttach.getClass(), citasCitaToAttach.getId_cita());
                attachedCitas.add(citasCitaToAttach);
            }
            odontologo.setCitas((ArrayList<Cita>) attachedCitas);
            em.persist(odontologo);
            for (Cita citasCita : odontologo.getCitas()) {
                Odontologo oldOdontologoOfCitasCita = citasCita.getOdontologo();
                citasCita.setOdontologo(odontologo);
                citasCita = em.merge(citasCita);
                if (oldOdontologoOfCitasCita != null) {
                    oldOdontologoOfCitasCita.getCitas().remove(citasCita);
                    oldOdontologoOfCitasCita = em.merge(oldOdontologoOfCitasCita);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Odontologo odontologo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Odontologo persistentOdontologo = em.find(Odontologo.class, odontologo.getId());
            List<Cita> citasOld = persistentOdontologo.getCitas();
            List<Cita> citasNew = odontologo.getCitas();
            List<Cita> attachedCitasNew = new ArrayList<Cita>();
            for (Cita citasNewCitaToAttach : citasNew) {
                citasNewCitaToAttach = em.getReference(citasNewCitaToAttach.getClass(), citasNewCitaToAttach.getId_cita());
                attachedCitasNew.add(citasNewCitaToAttach);
            }
            citasNew = attachedCitasNew;
            odontologo.setCitas((ArrayList<Cita>) citasNew);
            odontologo = em.merge(odontologo);
            for (Cita citasOldCita : citasOld) {
                if (!citasNew.contains(citasOldCita)) {
                    citasOldCita.setOdontologo(null);
                    citasOldCita = em.merge(citasOldCita);
                }
            }
            for (Cita citasNewCita : citasNew) {
                if (!citasOld.contains(citasNewCita)) {
                    Odontologo oldOdontologoOfCitasNewCita = citasNewCita.getOdontologo();
                    citasNewCita.setOdontologo(odontologo);
                    citasNewCita = em.merge(citasNewCita);
                    if (oldOdontologoOfCitasNewCita != null && !oldOdontologoOfCitasNewCita.equals(odontologo)) {
                        oldOdontologoOfCitasNewCita.getCitas().remove(citasNewCita);
                        oldOdontologoOfCitasNewCita = em.merge(oldOdontologoOfCitasNewCita);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = odontologo.getId();
                if (findOdontologo(id) == null) {
                    throw new NonexistentEntityException("The odontologo with id " + id + " no longer exists.");
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
            Odontologo odontologo;
            try {
                odontologo = em.getReference(Odontologo.class, id);
                odontologo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The odontologo with id " + id + " no longer exists.", enfe);
            }
            List<Cita> citas = odontologo.getCitas();
            for (Cita citasCita : citas) {
                citasCita.setOdontologo(null);
                citasCita = em.merge(citasCita);
            }
            em.remove(odontologo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Odontologo> findOdontologoEntities() {
        return findOdontologoEntities(true, -1, -1);
    }

    public List<Odontologo> findOdontologoEntities(int maxResults, int firstResult) {
        return findOdontologoEntities(false, maxResults, firstResult);
    }

    private List<Odontologo> findOdontologoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Odontologo.class));
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

    public Odontologo findOdontologo(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Odontologo.class, id);
        } finally {
            em.close();
        }
    }

    public int getOdontologoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Odontologo> rt = cq.from(Odontologo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
