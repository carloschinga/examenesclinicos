/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "ea_examenes")
@NamedQueries({
    @NamedQuery(name = "EaExamenes.findAll", query = "SELECT e FROM EaExamenes e"),
    @NamedQuery(name = "EaExamenes.findByExacod", query = "SELECT e FROM EaExamenes e WHERE e.exacod = :exacod"),
    @NamedQuery(name = "EaExamenes.findByExades", query = "SELECT e FROM EaExamenes e WHERE e.exades = :exades"),
    @NamedQuery(name = "EaExamenes.findByExaest", query = "SELECT e FROM EaExamenes e WHERE e.exaest = :exaest"),
    @NamedQuery(name = "EaExamenes.findByExadto", query = "SELECT e FROM EaExamenes e WHERE e.exadto = :exadto"),
    @NamedQuery(name = "EaExamenes.findByTarund", query = "SELECT e FROM EaExamenes e WHERE e.tarund = :tarund"),
    @NamedQuery(name = "EaExamenes.findByExatif", query = "SELECT e FROM EaExamenes e WHERE e.exatif = :exatif"),
    @NamedQuery(name = "EaExamenes.findByTaruni", query = "SELECT e FROM EaExamenes e WHERE e.taruni = :taruni"),
    @NamedQuery(name = "EaExamenes.findByTarsta", query = "SELECT e FROM EaExamenes e WHERE e.tarsta = :tarsta"),
    @NamedQuery(name = "EaExamenes.findByIgvexa", query = "SELECT e FROM EaExamenes e WHERE e.igvexa = :igvexa"),
    @NamedQuery(name = "EaExamenes.findByCoscom", query = "SELECT e FROM EaExamenes e WHERE e.coscom = :coscom"),
    @NamedQuery(name = "EaExamenes.findByCospro", query = "SELECT e FROM EaExamenes e WHERE e.cospro = :cospro"),
    @NamedQuery(name = "EaExamenes.findByMoncod", query = "SELECT e FROM EaExamenes e WHERE e.moncod = :moncod"),
    @NamedQuery(name = "EaExamenes.findByEstado", query = "SELECT e FROM EaExamenes e WHERE e.estado = :estado"),
    @NamedQuery(name = "EaExamenes.findByFeccre", query = "SELECT e FROM EaExamenes e WHERE e.feccre = :feccre"),
    @NamedQuery(name = "EaExamenes.findByFecumv", query = "SELECT e FROM EaExamenes e WHERE e.fecumv = :fecumv"),
    @NamedQuery(name = "EaExamenes.findByUsecod", query = "SELECT e FROM EaExamenes e WHERE e.usecod = :usecod"),
    @NamedQuery(name = "EaExamenes.findByUsenam", query = "SELECT e FROM EaExamenes e WHERE e.usenam = :usenam"),
    @NamedQuery(name = "EaExamenes.findByHostname", query = "SELECT e FROM EaExamenes e WHERE e.hostname = :hostname"),
    @NamedQuery(name = "EaExamenes.findByTarcos", query = "SELECT e FROM EaExamenes e WHERE e.tarcos = :tarcos"),
    @NamedQuery(name = "EaExamenes.findByTarcosD", query = "SELECT e FROM EaExamenes e WHERE e.tarcosD = :tarcosD"),
    @NamedQuery(name = "EaExamenes.findByExaref", query = "SELECT e FROM EaExamenes e WHERE e.exaref = :exaref"),
    @NamedQuery(name = "EaExamenes.findByExaobs", query = "SELECT e FROM EaExamenes e WHERE e.exaobs = :exaobs"),
    @NamedQuery(name = "EaExamenes.findByExadoc", query = "SELECT e FROM EaExamenes e WHERE e.exadoc = :exadoc"),
    @NamedQuery(name = "EaExamenes.findByExagraph", query = "SELECT e FROM EaExamenes e WHERE e.exagraph = :exagraph"),
    @NamedQuery(name = "EaExamenes.findByExadesL", query = "SELECT e FROM EaExamenes e WHERE e.exadesL = :exadesL"),
    @NamedQuery(name = "EaExamenes.findByExampri", query = "SELECT e FROM EaExamenes e WHERE e.exampri = :exampri"),
    @NamedQuery(name = "EaExamenes.findByExaabrv", query = "SELECT e FROM EaExamenes e WHERE e.exaabrv = :exaabrv"),
    @NamedQuery(name = "EaExamenes.findByStasgl", query = "SELECT e FROM EaExamenes e WHERE e.stasgl = :stasgl"),
    @NamedQuery(name = "EaExamenes.findByTartipPln", query = "SELECT e FROM EaExamenes e WHERE e.tartipPln = :tartipPln"),
    @NamedQuery(name = "EaExamenes.findByCencos", query = "SELECT e FROM EaExamenes e WHERE e.cencos = :cencos"),
    @NamedQuery(name = "EaExamenes.findByCodcue", query = "SELECT e FROM EaExamenes e WHERE e.codcue = :codcue"),
    @NamedQuery(name = "EaExamenes.findByModalCod", query = "SELECT e FROM EaExamenes e WHERE e.modalCod = :modalCod"),
    @NamedQuery(name = "EaExamenes.findByOrdtcod", query = "SELECT e FROM EaExamenes e WHERE e.ordtcod = :ordtcod"),
    @NamedQuery(name = "EaExamenes.findByTipccod", query = "SELECT e FROM EaExamenes e WHERE e.tipccod = :tipccod")})
public class EaExamenes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "exacod")
    private String exacod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "exades")
    private String exades;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "exaest")
    private String exaest;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "exadto")
    private BigDecimal exadto;
    @Column(name = "tarund")
    private BigDecimal tarund;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "exatif")
    private String exatif;
    @Column(name = "taruni")
    private BigDecimal taruni;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "tarsta")
    private String tarsta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "igvexa")
    private BigDecimal igvexa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "coscom")
    private BigDecimal coscom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cospro")
    private BigDecimal cospro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "moncod")
    private String moncod;
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
    @Column(name = "tarcos")
    private BigDecimal tarcos;
    @Column(name = "tarcos_d")
    private BigDecimal tarcosD;
    @Basic(optional = false)
    @NotNull
    @Column(name = "exaref")
    private BigDecimal exaref;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "exafor")
    private String exafor;
    @Size(max = 255)
    @Column(name = "exaobs")
    private String exaobs;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "exadoc")
    private String exadoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "exagraph")
    private String exagraph;
    @Size(max = 250)
    @Column(name = "exades_l")
    private String exadesL;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "exampri")
    private String exampri;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "exaabrv")
    private String exaabrv;
    @Size(max = 1)
    @Column(name = "stasgl")
    private String stasgl;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tartip_pln")
    private String tartipPln;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "exahtml")
    private String exahtml;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "CENCOS")
    private String cencos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "codcue")
    private String codcue;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "modal_cod")
    private String modalCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "ordtcod")
    private String ordtcod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "tipccod")
    private String tipccod;
    @JoinColumn(name = "exagrp", referencedColumnName = "exagrp")
    @ManyToOne(optional = false)
    private EaGrupos exagrp;

    public EaExamenes() {
    }

    public EaExamenes(String exacod) {
        this.exacod = exacod;
    }

    public EaExamenes(String exacod, String exades, String exaest, BigDecimal exadto, String exatif, String tarsta, BigDecimal igvexa, BigDecimal coscom, BigDecimal cospro, String moncod, String estado, Date feccre, Date fecumv, int usecod, String usenam, String hostname, BigDecimal exaref, String exadoc, String exagraph, String exampri, String exaabrv, String tartipPln, String cencos, String codcue, String modalCod, String ordtcod, String tipccod) {
        this.exacod = exacod;
        this.exades = exades;
        this.exaest = exaest;
        this.exadto = exadto;
        this.exatif = exatif;
        this.tarsta = tarsta;
        this.igvexa = igvexa;
        this.coscom = coscom;
        this.cospro = cospro;
        this.moncod = moncod;
        this.estado = estado;
        this.feccre = feccre;
        this.fecumv = fecumv;
        this.usecod = usecod;
        this.usenam = usenam;
        this.hostname = hostname;
        this.exaref = exaref;
        this.exadoc = exadoc;
        this.exagraph = exagraph;
        this.exampri = exampri;
        this.exaabrv = exaabrv;
        this.tartipPln = tartipPln;
        this.cencos = cencos;
        this.codcue = codcue;
        this.modalCod = modalCod;
        this.ordtcod = ordtcod;
        this.tipccod = tipccod;
    }

    public String getExacod() {
        return exacod;
    }

    public void setExacod(String exacod) {
        this.exacod = exacod;
    }

    public String getExades() {
        return exades;
    }

    public void setExades(String exades) {
        this.exades = exades;
    }

    public String getExaest() {
        return exaest;
    }

    public void setExaest(String exaest) {
        this.exaest = exaest;
    }

    public BigDecimal getExadto() {
        return exadto;
    }

    public void setExadto(BigDecimal exadto) {
        this.exadto = exadto;
    }

    public BigDecimal getTarund() {
        return tarund;
    }

    public void setTarund(BigDecimal tarund) {
        this.tarund = tarund;
    }

    public String getExatif() {
        return exatif;
    }

    public void setExatif(String exatif) {
        this.exatif = exatif;
    }

    public BigDecimal getTaruni() {
        return taruni;
    }

    public void setTaruni(BigDecimal taruni) {
        this.taruni = taruni;
    }

    public String getTarsta() {
        return tarsta;
    }

    public void setTarsta(String tarsta) {
        this.tarsta = tarsta;
    }

    public BigDecimal getIgvexa() {
        return igvexa;
    }

    public void setIgvexa(BigDecimal igvexa) {
        this.igvexa = igvexa;
    }

    public BigDecimal getCoscom() {
        return coscom;
    }

    public void setCoscom(BigDecimal coscom) {
        this.coscom = coscom;
    }

    public BigDecimal getCospro() {
        return cospro;
    }

    public void setCospro(BigDecimal cospro) {
        this.cospro = cospro;
    }

    public String getMoncod() {
        return moncod;
    }

    public void setMoncod(String moncod) {
        this.moncod = moncod;
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

    public BigDecimal getTarcos() {
        return tarcos;
    }

    public void setTarcos(BigDecimal tarcos) {
        this.tarcos = tarcos;
    }

    public BigDecimal getTarcosD() {
        return tarcosD;
    }

    public void setTarcosD(BigDecimal tarcosD) {
        this.tarcosD = tarcosD;
    }

    public BigDecimal getExaref() {
        return exaref;
    }

    public void setExaref(BigDecimal exaref) {
        this.exaref = exaref;
    }

    public String getExafor() {
        return exafor;
    }

    public void setExafor(String exafor) {
        this.exafor = exafor;
    }

    public String getExaobs() {
        return exaobs;
    }

    public void setExaobs(String exaobs) {
        this.exaobs = exaobs;
    }

    public String getExadoc() {
        return exadoc;
    }

    public void setExadoc(String exadoc) {
        this.exadoc = exadoc;
    }

    public String getExagraph() {
        return exagraph;
    }

    public void setExagraph(String exagraph) {
        this.exagraph = exagraph;
    }

    public String getExadesL() {
        return exadesL;
    }

    public void setExadesL(String exadesL) {
        this.exadesL = exadesL;
    }

    public String getExampri() {
        return exampri;
    }

    public void setExampri(String exampri) {
        this.exampri = exampri;
    }

    public String getExaabrv() {
        return exaabrv;
    }

    public void setExaabrv(String exaabrv) {
        this.exaabrv = exaabrv;
    }

    public String getStasgl() {
        return stasgl;
    }

    public void setStasgl(String stasgl) {
        this.stasgl = stasgl;
    }

    public String getTartipPln() {
        return tartipPln;
    }

    public void setTartipPln(String tartipPln) {
        this.tartipPln = tartipPln;
    }

    public String getExahtml() {
        return exahtml;
    }

    public void setExahtml(String exahtml) {
        this.exahtml = exahtml;
    }

    public String getCencos() {
        return cencos;
    }

    public void setCencos(String cencos) {
        this.cencos = cencos;
    }

    public String getCodcue() {
        return codcue;
    }

    public void setCodcue(String codcue) {
        this.codcue = codcue;
    }

    public String getModalCod() {
        return modalCod;
    }

    public void setModalCod(String modalCod) {
        this.modalCod = modalCod;
    }

    public String getOrdtcod() {
        return ordtcod;
    }

    public void setOrdtcod(String ordtcod) {
        this.ordtcod = ordtcod;
    }

    public String getTipccod() {
        return tipccod;
    }

    public void setTipccod(String tipccod) {
        this.tipccod = tipccod;
    }

    public EaGrupos getExagrp() {
        return exagrp;
    }

    public void setExagrp(EaGrupos exagrp) {
        this.exagrp = exagrp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (exacod != null ? exacod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EaExamenes)) {
            return false;
        }
        EaExamenes other = (EaExamenes) object;
        if ((this.exacod == null && other.exacod != null) || (this.exacod != null && !this.exacod.equals(other.exacod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.clinicasb.dto.EaExamenes[ exacod=" + exacod + " ]";
    }
    
}
