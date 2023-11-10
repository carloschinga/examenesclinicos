/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dao;

import com.clinicasb.dao.exceptions.NonexistentEntityException;
import com.clinicasb.dao.exceptions.PreexistingEntityException;
import com.clinicasb.dto.ViewProcedimiento;

import java.io.Serializable;
import java.util.Date;
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
public class ViewProcedimientoJpaController implements Serializable {

    public ViewProcedimientoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
     private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.clinicasb.persis");    

    public ViewProcedimientoJpaController() {
    }


    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ViewProcedimiento viewProcedimiento) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(viewProcedimiento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findViewProcedimiento(viewProcedimiento.getSecuencia()) != null) {
                throw new PreexistingEntityException("ViewProcedimiento " + viewProcedimiento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ViewProcedimiento viewProcedimiento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            viewProcedimiento = em.merge(viewProcedimiento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = viewProcedimiento.getSecuencia();
                if (findViewProcedimiento(id) == null) {
                    throw new NonexistentEntityException("The viewProcedimiento with id " + id + " no longer exists.");
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
            ViewProcedimiento viewProcedimiento;
            try {
                viewProcedimiento = em.getReference(ViewProcedimiento.class, id);
                viewProcedimiento.getSecuencia();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The viewProcedimiento with id " + id + " no longer exists.", enfe);
            }
            em.remove(viewProcedimiento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ViewProcedimiento> findViewProcedimientoEntities() {
        return findViewProcedimientoEntities(true, -1, -1);
    }

    public List<ViewProcedimiento> findViewProcedimientoEntities(int maxResults, int firstResult) {
        return findViewProcedimientoEntities(false, maxResults, firstResult);
    }

    private List<ViewProcedimiento> findViewProcedimientoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ViewProcedimiento.class));
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

    public ViewProcedimiento findViewProcedimiento(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ViewProcedimiento.class, id);
        } finally {
            em.close();
        }
    }

    public int getViewProcedimientoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ViewProcedimiento> rt = cq.from(ViewProcedimiento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    public List<ViewProcedimiento> listar(Date startDate, Date endDate) {
        EntityManager em = getEntityManager();
        try {
            
            Query q = em.createNamedQuery("ViewProcedimiento.findByFechaFiltroBeetwen");
            q.setParameter("startDate", startDate);
            q.setParameter("endDate", endDate);
            List<ViewProcedimiento> lista = q.getResultList();
            return lista;
        } catch (Exception ex) {
            System.out.println("Errorr en listar");
            return null;
        }finally {
            em.close();
        }
    }
    
}
