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
import javax.persistence.Lob;
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
@Table(name = "view_procedimiento")
@NamedQueries({
    @NamedQuery(name = "ViewProcedimiento.findAll", query = "SELECT v FROM ViewProcedimiento v"),
    @NamedQuery(name = "ViewProcedimiento.findBySecuencia", query = "SELECT v FROM ViewProcedimiento v WHERE v.secuencia = :secuencia"),
    @NamedQuery(name = "ViewProcedimiento.findByFechaFiltroBeetwen", query = "SELECT v FROM ViewProcedimiento v WHERE v.fechaFiltro BETWEEN :startDate and :endDate ORDER BY v.secuencia"),
    @NamedQuery(name = "ViewProcedimiento.findByPachis", query = "SELECT v FROM ViewProcedimiento v WHERE v.pachis = :pachis"),
    @NamedQuery(name = "ViewProcedimiento.findByPaciente", query = "SELECT v FROM ViewProcedimiento v WHERE v.paciente = :paciente"),
    @NamedQuery(name = "ViewProcedimiento.findByTipoPlan", query = "SELECT v FROM ViewProcedimiento v WHERE v.tipoPlan = :tipoPlan"),
    @NamedQuery(name = "ViewProcedimiento.findByNumitm", query = "SELECT v FROM ViewProcedimiento v WHERE v.numitm = :numitm"),
    @NamedQuery(name = "ViewProcedimiento.findByTarcod", query = "SELECT v FROM ViewProcedimiento v WHERE v.tarcod = :tarcod"),
    @NamedQuery(name = "ViewProcedimiento.findByTardes", query = "SELECT v FROM ViewProcedimiento v WHERE v.tardes = :tardes"),
    @NamedQuery(name = "ViewProcedimiento.findByFechaOrden", query = "SELECT v FROM ViewProcedimiento v WHERE v.fechaOrden = :fechaOrden"),
    @NamedQuery(name = "ViewProcedimiento.findByFechaFiltro", query = "SELECT v FROM ViewProcedimiento v WHERE v.fechaFiltro = :fechaFiltro"),
    @NamedQuery(name = "ViewProcedimiento.findByMedcod", query = "SELECT v FROM ViewProcedimiento v WHERE v.medcod = :medcod"),
    @NamedQuery(name = "ViewProcedimiento.findByUsecodApr", query = "SELECT v FROM ViewProcedimiento v WHERE v.usecodApr = :usecodApr"),
    @NamedQuery(name = "ViewProcedimiento.findByExaapr", query = "SELECT v FROM ViewProcedimiento v WHERE v.exaapr = :exaapr")})
public class ViewProcedimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "secuencia")
    private int secuencia;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "pachis")
    private String pachis;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Paciente")
    private String paciente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "TipoPlan")
    private String tipoPlan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numitm")
    private int numitm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "tarcod")
    private String tarcod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "tardes")
    private String tardes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaOrden")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaOrden;
    @Column(name = "FechaFiltro")
    @Temporal(TemporalType.DATE)
    private Date fechaFiltro;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "resexa")
    private String resexa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "medcod")
    private String medcod;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "resexahml")
    private String resexahml;
    @Column(name = "usecod_apr")
    private Integer usecodApr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "exaapr")
    private String exaapr;

    public ViewProcedimiento() {
    }

    public int getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(int secuencia) {
        this.secuencia = secuencia;
    }

    public String getPachis() {
        return pachis;
    }

    public void setPachis(String pachis) {
        this.pachis = pachis;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getTipoPlan() {
        return tipoPlan;
    }

    public void setTipoPlan(String tipoPlan) {
        this.tipoPlan = tipoPlan;
    }

    public int getNumitm() {
        return numitm;
    }

    public void setNumitm(int numitm) {
        this.numitm = numitm;
    }

    public String getTarcod() {
        return tarcod;
    }

    public void setTarcod(String tarcod) {
        this.tarcod = tarcod;
    }

    public String getTardes() {
        return tardes;
    }

    public void setTardes(String tardes) {
        this.tardes = tardes;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public Date getFechaFiltro() {
        return fechaFiltro;
    }

    public void setFechaFiltro(Date fechaFiltro) {
        this.fechaFiltro = fechaFiltro;
    }

    public String getResexa() {
        return resexa;
    }

    public void setResexa(String resexa) {
        this.resexa = resexa;
    }

    public String getMedcod() {
        return medcod;
    }

    public void setMedcod(String medcod) {
        this.medcod = medcod;
    }

    public String getResexahml() {
        return resexahml;
    }

    public void setResexahml(String resexahml) {
        this.resexahml = resexahml;
    }

    public Integer getUsecodApr() {
        return usecodApr;
    }

    public void setUsecodApr(Integer usecodApr) {
        this.usecodApr = usecodApr;
    }

    public String getExaapr() {
        return exaapr;
    }

    public void setExaapr(String exaapr) {
        this.exaapr = exaapr;
    }
    
}
