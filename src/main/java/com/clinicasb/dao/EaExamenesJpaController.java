/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dao;

import com.clinicasb.dao.exceptions.NonexistentEntityException;
import com.clinicasb.dao.exceptions.PreexistingEntityException;
import com.clinicasb.dto.EaExamenes;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.clinicasb.dto.EaGrupos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author USUARIO
 */
public class EaExamenesJpaController implements Serializable {

    public EaExamenesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.clinicasb.persis");

    public EaExamenesJpaController() {
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EaExamenes eaExamenes) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EaGrupos exagrp = eaExamenes.getExagrp();
            if (exagrp != null) {
                exagrp = em.getReference(exagrp.getClass(), exagrp.getExagrp());
                eaExamenes.setExagrp(exagrp);
            }
            em.persist(eaExamenes);
            if (exagrp != null) {
                exagrp.getEaExamenesList().add(eaExamenes);
                exagrp = em.merge(exagrp);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEaExamenes(eaExamenes.getExacod()) != null) {
                throw new PreexistingEntityException("EaExamenes " + eaExamenes + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EaExamenes eaExamenes) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EaExamenes persistentEaExamenes = em.find(EaExamenes.class, eaExamenes.getExacod());
            EaGrupos exagrpOld = persistentEaExamenes.getExagrp();
            EaGrupos exagrpNew = eaExamenes.getExagrp();
            if (exagrpNew != null) {
                exagrpNew = em.getReference(exagrpNew.getClass(), exagrpNew.getExagrp());
                eaExamenes.setExagrp(exagrpNew);
            }
            eaExamenes = em.merge(eaExamenes);
            if (exagrpOld != null && !exagrpOld.equals(exagrpNew)) {
                exagrpOld.getEaExamenesList().remove(eaExamenes);
                exagrpOld = em.merge(exagrpOld);
            }
            if (exagrpNew != null && !exagrpNew.equals(exagrpOld)) {
                exagrpNew.getEaExamenesList().add(eaExamenes);
                exagrpNew = em.merge(exagrpNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = eaExamenes.getExacod();
                if (findEaExamenes(id) == null) {
                    throw new NonexistentEntityException("The eaExamenes with id " + id + " no longer exists.");
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
            EaExamenes eaExamenes;
            try {
                eaExamenes = em.getReference(EaExamenes.class, id);
                eaExamenes.getExacod();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The eaExamenes with id " + id + " no longer exists.", enfe);
            }
            EaGrupos exagrp = eaExamenes.getExagrp();
            if (exagrp != null) {
                exagrp.getEaExamenesList().remove(eaExamenes);
                exagrp = em.merge(exagrp);
            }
            em.remove(eaExamenes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EaExamenes> findEaExamenesEntities() {
        return findEaExamenesEntities(true, -1, -1);
    }

    public List<EaExamenes> findEaExamenesEntities(int maxResults, int firstResult) {
        return findEaExamenesEntities(false, maxResults, firstResult);
    }

    private List<EaExamenes> findEaExamenesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EaExamenes.class));
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

    public EaExamenes findEaExamenes(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EaExamenes.class, id);
        } finally {
            em.close();
        }
    }

    public int getEaExamenesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EaExamenes> rt = cq.from(EaExamenes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<EaExamenes> listarXEaGrupo(String exagrp) {
        EntityManager em = getEntityManager();
        try {
            String jpql = "SELECT e FROM EaExamenes e WHERE e.exagrp= :exagrp";
            TypedQuery<EaExamenes> query = em.createQuery(jpql, EaExamenes.class);
            query.setParameter("exagrp", exagrp);
            return query.getResultList();

        } finally {
            em.close();
        }
    }

    public List<EaExamenes> findByExagrp(EaGrupos exagrp) {
        EntityManager em = getEntityManager();
        try {
            String jpql = "SELECT e FROM EaExamenes e WHERE e.exagrp = :exagrp";
            TypedQuery<EaExamenes> query = em.createQuery(jpql, EaExamenes.class);
            query.setParameter("exagrp", exagrp);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

}
