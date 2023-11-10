/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "tipo_tarifa")
@NamedQueries({
    @NamedQuery(name = "TipoTarifa.findAll", query = "SELECT t FROM TipoTarifa t"),
    @NamedQuery(name = "TipoTarifa.findByTtacod", query = "SELECT t FROM TipoTarifa t WHERE t.ttacod = :ttacod"),
    @NamedQuery(name = "TipoTarifa.findByTtades", query = "SELECT t FROM TipoTarifa t WHERE t.ttades = :ttades"),
    @NamedQuery(name = "TipoTarifa.findByEstado", query = "SELECT t FROM TipoTarifa t WHERE t.estado = :estado"),
    @NamedQuery(name = "TipoTarifa.findByFeccre", query = "SELECT t FROM TipoTarifa t WHERE t.feccre = :feccre"),
    @NamedQuery(name = "TipoTarifa.findByFecumv", query = "SELECT t FROM TipoTarifa t WHERE t.fecumv = :fecumv"),
    @NamedQuery(name = "TipoTarifa.findByUsecod", query = "SELECT t FROM TipoTarifa t WHERE t.usecod = :usecod"),
    @NamedQuery(name = "TipoTarifa.findByUsenam", query = "SELECT t FROM TipoTarifa t WHERE t.usenam = :usenam"),
    @NamedQuery(name = "TipoTarifa.findByHostname", query = "SELECT t FROM TipoTarifa t WHERE t.hostname = :hostname")})
public class TipoTarifa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "ttacod")
    private String ttacod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "ttades")
    private String ttades;
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

    public TipoTarifa() {
    }

    public TipoTarifa(String ttacod) {
        this.ttacod = ttacod;
    }

    public TipoTarifa(String ttacod, String ttades, String estado, Date feccre, Date fecumv, int usecod, String usenam, String hostname) {
        this.ttacod = ttacod;
        this.ttades = ttades;
        this.estado = estado;
        this.feccre = feccre;
        this.fecumv = fecumv;
        this.usecod = usecod;
        this.usenam = usenam;
        this.hostname = hostname;
    }

    public String getTtacod() {
        return ttacod;
    }

    public void setTtacod(String ttacod) {
        this.ttacod = ttacod;
    }

    public String getTtades() {
        return ttades;
    }

    public void setTtades(String ttades) {
        this.ttades = ttades;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ttacod != null ? ttacod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoTarifa)) {
            return false;
        }
        TipoTarifa other = (TipoTarifa) object;
        if ((this.ttacod == null && other.ttacod != null) || (this.ttacod != null && !this.ttacod.equals(other.ttacod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.clinicasb.dto.TipoTarifa[ ttacod=" + ttacod + " ]";
    }
    
}
