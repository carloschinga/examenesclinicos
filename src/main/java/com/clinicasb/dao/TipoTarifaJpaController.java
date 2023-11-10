/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dao;

import com.clinicasb.dao.exceptions.NonexistentEntityException;
import com.clinicasb.dao.exceptions.PreexistingEntityException;
import com.clinicasb.dto.TipoTarifa;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author USUARIO
 */
public class TipoTarifaJpaController implements Serializable {

    public TipoTarifaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.clinicasb.persis");

    public TipoTarifaJpaController() {
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TipoTarifa tipoTarifa) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipoTarifa);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTipoTarifa(tipoTarifa.getTtacod()) != null) {
                throw new PreexistingEntityException("TipoTarifa " + tipoTarifa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TipoTarifa tipoTarifa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tipoTarifa = em.merge(tipoTarifa);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tipoTarifa.getTtacod();
                if (findTipoTarifa(id) == null) {
                    throw new NonexistentEntityException("The tipoTarifa with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TipoTarifa tipoTarifa;
            try {
                tipoTarifa = em.getReference(TipoTarifa.class, id);
                tipoTarifa.getTtacod();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoTarifa with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipoTarifa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TipoTarifa> findTipoTarifaEntities() {
        return findTipoTarifaEntities(true, -1, -1);
    }

    public List<TipoTarifa> findTipoTarifaEntities(int maxResults, int firstResult) {
        return findTipoTarifaEntities(false, maxResults, firstResult);
    }

    private List<TipoTarifa> findTipoTarifaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TipoTarifa.class));
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

    public TipoTarifa findTipoTarifa(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TipoTarifa.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoTarifaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TipoTarifa> rt = cq.from(TipoTarifa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
