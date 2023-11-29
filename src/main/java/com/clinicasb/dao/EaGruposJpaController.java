/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dao;

import com.clinicasb.dao.exceptions.IllegalOrphanException;
import com.clinicasb.dao.exceptions.NonexistentEntityException;
import com.clinicasb.dao.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.clinicasb.dto.EaExamenes;
import com.clinicasb.dto.EaGrupos;
import com.clinicasb.dto.Grupo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author USUARIO
 */
public class EaGruposJpaController implements Serializable {

    public EaGruposJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.clinicasb.persis");    

    public EaGruposJpaController() {
    }

    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EaGrupos eaGrupos) throws PreexistingEntityException, Exception {
        if (eaGrupos.getEaExamenesList() == null) {
            eaGrupos.setEaExamenesList(new ArrayList<EaExamenes>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<EaExamenes> attachedEaExamenesList = new ArrayList<EaExamenes>();
            for (EaExamenes eaExamenesListEaExamenesToAttach : eaGrupos.getEaExamenesList()) {
                eaExamenesListEaExamenesToAttach = em.getReference(eaExamenesListEaExamenesToAttach.getClass(), eaExamenesListEaExamenesToAttach.getExacod());
                attachedEaExamenesList.add(eaExamenesListEaExamenesToAttach);
            }
            eaGrupos.setEaExamenesList(attachedEaExamenesList);
            em.persist(eaGrupos);
            for (EaExamenes eaExamenesListEaExamenes : eaGrupos.getEaExamenesList()) {
                EaGrupos oldExagrpOfEaExamenesListEaExamenes = eaExamenesListEaExamenes.getExagrp();
                eaExamenesListEaExamenes.setExagrp(eaGrupos);
                eaExamenesListEaExamenes = em.merge(eaExamenesListEaExamenes);
                if (oldExagrpOfEaExamenesListEaExamenes != null) {
                    oldExagrpOfEaExamenesListEaExamenes.getEaExamenesList().remove(eaExamenesListEaExamenes);
                    oldExagrpOfEaExamenesListEaExamenes = em.merge(oldExagrpOfEaExamenesListEaExamenes);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEaGrupos(eaGrupos.getExagrp()) != null) {
                throw new PreexistingEntityException("EaGrupos " + eaGrupos + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EaGrupos eaGrupos) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EaGrupos persistentEaGrupos = em.find(EaGrupos.class, eaGrupos.getExagrp());
            List<EaExamenes> eaExamenesListOld = persistentEaGrupos.getEaExamenesList();
            List<EaExamenes> eaExamenesListNew = eaGrupos.getEaExamenesList();
            List<String> illegalOrphanMessages = null;
            for (EaExamenes eaExamenesListOldEaExamenes : eaExamenesListOld) {
                if (!eaExamenesListNew.contains(eaExamenesListOldEaExamenes)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain EaExamenes " + eaExamenesListOldEaExamenes + " since its exagrp field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<EaExamenes> attachedEaExamenesListNew = new ArrayList<EaExamenes>();
            for (EaExamenes eaExamenesListNewEaExamenesToAttach : eaExamenesListNew) {
                eaExamenesListNewEaExamenesToAttach = em.getReference(eaExamenesListNewEaExamenesToAttach.getClass(), eaExamenesListNewEaExamenesToAttach.getExacod());
                attachedEaExamenesListNew.add(eaExamenesListNewEaExamenesToAttach);
            }
            eaExamenesListNew = attachedEaExamenesListNew;
            eaGrupos.setEaExamenesList(eaExamenesListNew);
            eaGrupos = em.merge(eaGrupos);
            for (EaExamenes eaExamenesListNewEaExamenes : eaExamenesListNew) {
                if (!eaExamenesListOld.contains(eaExamenesListNewEaExamenes)) {
                    EaGrupos oldExagrpOfEaExamenesListNewEaExamenes = eaExamenesListNewEaExamenes.getExagrp();
                    eaExamenesListNewEaExamenes.setExagrp(eaGrupos);
                    eaExamenesListNewEaExamenes = em.merge(eaExamenesListNewEaExamenes);
                    if (oldExagrpOfEaExamenesListNewEaExamenes != null && !oldExagrpOfEaExamenesListNewEaExamenes.equals(eaGrupos)) {
                        oldExagrpOfEaExamenesListNewEaExamenes.getEaExamenesList().remove(eaExamenesListNewEaExamenes);
                        oldExagrpOfEaExamenesListNewEaExamenes = em.merge(oldExagrpOfEaExamenesListNewEaExamenes);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = eaGrupos.getExagrp();
                if (findEaGrupos(id) == null) {
                    throw new NonexistentEntityException("The eaGrupos with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EaGrupos eaGrupos;
            try {
                eaGrupos = em.getReference(EaGrupos.class, id);
                eaGrupos.getExagrp();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The eaGrupos with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<EaExamenes> eaExamenesListOrphanCheck = eaGrupos.getEaExamenesList();
            for (EaExamenes eaExamenesListOrphanCheckEaExamenes : eaExamenesListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This EaGrupos (" + eaGrupos + ") cannot be destroyed since the EaExamenes " + eaExamenesListOrphanCheckEaExamenes + " in its eaExamenesList field has a non-nullable exagrp field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(eaGrupos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EaGrupos> findEaGruposEntities() {
        return findEaGruposEntities(true, -1, -1);
    }

    public List<EaGrupos> findEaGruposEntities(int maxResults, int firstResult) {
        return findEaGruposEntities(false, maxResults, firstResult);
    }

    private List<EaGrupos> findEaGruposEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EaGrupos.class));
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

    public EaGrupos findEaGrupos(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EaGrupos.class, id);
        } finally {
            em.close();
        }
    }

    public int getEaGruposCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EaGrupos> rt = cq.from(EaGrupos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
     public List<Grupo> listar() {
        EntityManager em = getEntityManager();
        try {
            Query nativeQuery = em.createNativeQuery("select exagrp,desgrp from ea_grupos where estado='S'");
            List<Grupo> lista = nativeQuery.getResultList();
            return lista;
        } 
        catch(Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
        finally {
            em.close();
        }
    }
    
    
}
