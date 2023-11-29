/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "ea_grupos")
@NamedQueries({
    @NamedQuery(name = "EaGrupos.findAll", query = "SELECT e FROM EaGrupos e"),
    @NamedQuery(name = "EaGrupos.findByExagrp", query = "SELECT e FROM EaGrupos e WHERE e.exagrp = :exagrp"),
    @NamedQuery(name = "EaGrupos.findByDesgrp", query = "SELECT e FROM EaGrupos e WHERE e.desgrp = :desgrp"),
    @NamedQuery(name = "EaGrupos.findByEstado", query = "SELECT e FROM EaGrupos e WHERE e.estado = :estado"),
    @NamedQuery(name = "EaGrupos.findByFeccre", query = "SELECT e FROM EaGrupos e WHERE e.feccre = :feccre"),
    @NamedQuery(name = "EaGrupos.findByFecumv", query = "SELECT e FROM EaGrupos e WHERE e.fecumv = :fecumv"),
    @NamedQuery(name = "EaGrupos.findByUsecod", query = "SELECT e FROM EaGrupos e WHERE e.usecod = :usecod"),
    @NamedQuery(name = "EaGrupos.findByUsenam", query = "SELECT e FROM EaGrupos e WHERE e.usenam = :usenam"),
    @NamedQuery(name = "EaGrupos.findByHostname", query = "SELECT e FROM EaGrupos e WHERE e.hostname = :hostname"),
    @NamedQuery(name = "EaGrupos.findByGruref", query = "SELECT e FROM EaGrupos e WHERE e.gruref = :gruref")})
public class EaGrupos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "exagrp")
    private String exagrp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "desgrp")
    private String desgrp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "feccre")
    @Temporal(TemporalType.TIMESTAMP)
    private Date feccre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecumv")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecumv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usecod")
    private int usecod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "usenam")
    private String usenam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "hostname")
    private String hostname;
    @Size(max = 50)
    @Column(name = "gruref")
    private String gruref;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "exagrp")
    private List<EaExamenes> eaExamenesList;

    public EaGrupos() {
    }

    public EaGrupos(String exagrp) {
        this.exagrp = exagrp;
    }

    public EaGrupos(String exagrp, String desgrp, String estado, Date feccre, Date fecumv, int usecod, String usenam, String hostname) {
        this.exagrp = exagrp;
        this.desgrp = desgrp;
        this.estado = estado;
        this.feccre = feccre;
        this.fecumv = fecumv;
        this.usecod = usecod;
        this.usenam = usenam;
        this.hostname = hostname;
    }

    public String getExagrp() {
        return exagrp;
    }

    public void setExagrp(String exagrp) {
        this.exagrp = exagrp;
    }

    public String getDesgrp() {
        return desgrp;
    }

    public void setDesgrp(String desgrp) {
        this.desgrp = desgrp;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFeccre() {
        return feccre;
    }

    public void setFeccre(Date feccre) {
        this.feccre = feccre;
    }

    public Date getFecumv() {
        return fecumv;
    }

    public void setFecumv(Date fecumv) {
        this.fecumv = fecumv;
    }

    public int getUsecod() {
        return usecod;
    }

    public void setUsecod(int usecod) {
        this.usecod = usecod;
    }

    public String getUsenam() {
        return usenam;
    }

    public void setUsenam(String usenam) {
        this.usenam = usenam;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getGruref() {
        return gruref;
    }

    public void setGruref(String gruref) {
        this.gruref = gruref;
    }

    public List<EaExamenes> getEaExamenesList() {
        return eaExamenesList;
    }

    public void setEaExamenesList(List<EaExamenes> eaExamenesList) {
        this.eaExamenesList = eaExamenesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (exagrp != null ? exagrp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EaGrupos)) {
            return false;
        }
        EaGrupos other = (EaGrupos) object;
        if ((this.exagrp == null && other.exagrp != null) || (this.exagrp != null && !this.exagrp.equals(other.exagrp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.clinicasb.dto.EaGrupos[ exagrp=" + exagrp + " ]";
    }
    
}
