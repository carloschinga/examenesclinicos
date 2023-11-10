/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dao;

import com.clinicasb.dao.exceptions.IllegalOrphanException;
import com.clinicasb.dao.exceptions.NonexistentEntityException;
import com.clinicasb.dao.exceptions.PreexistingEntityException;
import com.clinicasb.dto.EaOrdenesDetalle;
import com.clinicasb.dto.EaOrdenesDetallePK;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.clinicasb.dto.EaResultados;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author USUARIO
 */
public class EaOrdenesDetalleJpaController implements Serializable {

    public EaOrdenesDetalleJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.clinicasb.persis");

    public EaOrdenesDetalleJpaController() {
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EaOrdenesDetalle eaOrdenesDetalle) throws PreexistingEntityException, Exception {
        if (eaOrdenesDetalle.getEaOrdenesDetallePK() == null) {
            eaOrdenesDetalle.setEaOrdenesDetallePK(new EaOrdenesDetallePK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EaResultados eaResultados = eaOrdenesDetalle.getEaResultados();
            if (eaResultados != null) {
                eaResultados = em.getReference(eaResultados.getClass(), eaResultados.getEaResultadosPK());
                eaOrdenesDetalle.setEaResultados(eaResultados);
            }
            em.persist(eaOrdenesDetalle);
            if (eaResultados != null) {
                EaOrdenesDetalle oldEaOrdenesDetalleOfEaResultados = eaResultados.getEaOrdenesDetalle();
                if (oldEaOrdenesDetalleOfEaResultados != null) {
                    oldEaOrdenesDetalleOfEaResultados.setEaResultados(null);
                    oldEaOrdenesDetalleOfEaResultados = em.merge(oldEaOrdenesDetalleOfEaResultados);
                }
                eaResultados.setEaOrdenesDetalle(eaOrdenesDetalle);
                eaResultados = em.merge(eaResultados);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEaOrdenesDetalle(eaOrdenesDetalle.getEaOrdenesDetallePK()) != null) {
                throw new PreexistingEntityException("EaOrdenesDetalle " + eaOrdenesDetalle + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EaOrdenesDetalle eaOrdenesDetalle) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EaOrdenesDetalle persistentEaOrdenesDetalle = em.find(EaOrdenesDetalle.class, eaOrdenesDetalle.getEaOrdenesDetallePK());
            EaResultados eaResultadosOld = persistentEaOrdenesDetalle.getEaResultados();
            EaResultados eaResultadosNew = eaOrdenesDetalle.getEaResultados();
            List<String> illegalOrphanMessages = null;
            if (eaResultadosOld != null && !eaResultadosOld.equals(eaResultadosNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain EaResultados " + eaResultadosOld + " since its eaOrdenesDetalle field is not nullable.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (eaResultadosNew != null) {
                eaResultadosNew = em.getReference(eaResultadosNew.getClass(), eaResultadosNew.getEaResultadosPK());
                eaOrdenesDetalle.setEaResultados(eaResultadosNew);
            }
            eaOrdenesDetalle = em.merge(eaOrdenesDetalle);
            if (eaResultadosNew != null && !eaResultadosNew.equals(eaResultadosOld)) {
                EaOrdenesDetalle oldEaOrdenesDetalleOfEaResultados = eaResultadosNew.getEaOrdenesDetalle();
                if (oldEaOrdenesDetalleOfEaResultados != null) {
                    oldEaOrdenesDetalleOfEaResultados.setEaResultados(null);
                    oldEaOrdenesDetalleOfEaResultados = em.merge(oldEaOrdenesDetalleOfEaResultados);
                }
                eaResultadosNew.setEaOrdenesDetalle(eaOrdenesDetalle);
                eaResultadosNew = em.merge(eaResultadosNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                EaOrdenesDetallePK id = eaOrdenesDetalle.getEaOrdenesDetallePK();
                if (findEaOrdenesDetalle(id) == null) {
                    throw new NonexistentEntityException("The eaOrdenesDetalle with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(EaOrdenesDetallePK id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EaOrdenesDetalle eaOrdenesDetalle;
            try {
                eaOrdenesDetalle = em.getReference(EaOrdenesDetalle.class, id);
                eaOrdenesDetalle.getEaOrdenesDetallePK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The eaOrdenesDetalle with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            EaResultados eaResultadosOrphanCheck = eaOrdenesDetalle.getEaResultados();
            if (eaResultadosOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This EaOrdenesDetalle (" + eaOrdenesDetalle + ") cannot be destroyed since the EaResultados " + eaResultadosOrphanCheck + " in its eaResultados field has a non-nullable eaOrdenesDetalle field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(eaOrdenesDetalle);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EaOrdenesDetalle> findEaOrdenesDetalleEntities() {
        return findEaOrdenesDetalleEntities(true, -1, -1);
    }

    public List<EaOrdenesDetalle> findEaOrdenesDetalleEntities(int maxResults, int firstResult) {
        return findEaOrdenesDetalleEntities(false, maxResults, firstResult);
    }

    private List<EaOrdenesDetalle> findEaOrdenesDetalleEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EaOrdenesDetalle.class));
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

    public EaOrdenesDetalle findEaOrdenesDetalle(EaOrdenesDetallePK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EaOrdenesDetalle.class, id);
        } finally {
            em.close();
        }
    }

    public int getEaOrdenesDetalleCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EaOrdenesDetalle> rt = cq.from(EaOrdenesDetalle.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
