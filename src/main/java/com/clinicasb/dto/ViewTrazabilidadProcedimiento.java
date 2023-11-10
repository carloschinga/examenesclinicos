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
@Table(name = "view_trazabilidad_procedimiento")
@NamedQueries({
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findAll", query = "SELECT v FROM ViewTrazabilidadProcedimiento v"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByFechaFiltroBeetwen", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.fechaFiltro BETWEEN :startDate and :endDate ORDER BY v.secuencia"), 
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findBySecuencia", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.secuencia = :secuencia"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByNumitm", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.numitm = :numitm"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByHistoria", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.historia = :historia"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByPaciente", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.paciente = :paciente"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByTipoPlan", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.tipoPlan = :tipoPlan"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByExamen", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.examen = :examen"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByFechaOrden", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.fechaOrden = :fechaOrden"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByFechaCreacion", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByFechaFiltro", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.fechaFiltro = :fechaFiltro"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByTieneCreacion", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.tieneCreacion = :tieneCreacion"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByFechaPago", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.fechaPago = :fechaPago"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByTienePago", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.tienePago = :tienePago"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByDiasDemoraPago", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.diasDemoraPago = :diasDemoraPago"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByFechaTomaExamen", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.fechaTomaExamen = :fechaTomaExamen"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByTieneTomaExamen", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.tieneTomaExamen = :tieneTomaExamen"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByFechaResultado", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.fechaResultado = :fechaResultado"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByTieneResultado", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.tieneResultado = :tieneResultado"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByFechaAprobado", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.fechaAprobado = :fechaAprobado"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByTieneAprobado", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.tieneAprobado = :tieneAprobado"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByMedcod", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.medcod = :medcod"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByExaapr", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.exaapr = :exaapr"),
    @NamedQuery(name = "ViewTrazabilidadProcedimiento.findByPactel", query = "SELECT v FROM ViewTrazabilidadProcedimiento v WHERE v.pactel = :pactel")})
public class ViewTrazabilidadProcedimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Secuencia")
    private int secuencia;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numitm")
    private int numitm;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "Historia")
    private String historia;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Paciente")
    private String paciente;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "TipoPlan")
    private String tipoPlan;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "Examen")
    private String examen;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaOrden")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaOrden;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaCreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "FechaFiltro")
    @Temporal(TemporalType.DATE)
    private Date fechaFiltro;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TieneCreacion")
    private int tieneCreacion;
    @Column(name = "FechaPago")
    private Integer fechaPago;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TienePago")
    private int tienePago;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "diasDemoraPago")
    private int diasDemoraPago;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaTomaExamen")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTomaExamen;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TieneTomaExamen")
    private int tieneTomaExamen;
    @Column(name = "FechaResultado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaResultado;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TieneResultado")
    private int tieneResultado;
    @Column(name = "FechaAprobado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAprobado;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TieneAprobado")
    private int tieneAprobado;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "medcod")
    private String medcod;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "exaapr")
    private String exaapr;
    @Size(max = 25)
    @Column(name = "pactel")
    private String pactel;

    public ViewTrazabilidadProcedimiento() {
    }

    public int getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(int secuencia) {
        this.secuencia = secuencia;
    }

    public int getNumitm() {
        return numitm;
    }

    public void setNumitm(int numitm) {
        this.numitm = numitm;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
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

    public String getExamen() {
        return examen;
    }

    public void setExamen(String examen) {
        this.examen = examen;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaFiltro() {
        return fechaFiltro;
    }

    public void setFechaFiltro(Date fechaFiltro) {
        this.fechaFiltro = fechaFiltro;
    }

    public int getTieneCreacion() {
        return tieneCreacion;
    }

    public void setTieneCreacion(int tieneCreacion) {
        this.tieneCreacion = tieneCreacion;
    }

    public Integer getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Integer fechaPago) {
        this.fechaPago = fechaPago;
    }

    public int getTienePago() {
        return tienePago;
    }

    public void setTienePago(int tienePago) {
        this.tienePago = tienePago;
    }

    public int getDiasDemoraPago() {
        return diasDemoraPago;
    }

    public void setDiasDemoraPago(int diasDemoraPago) {
        this.diasDemoraPago = diasDemoraPago;
    }

    public Date getFechaTomaExamen() {
        return fechaTomaExamen;
    }

    public void setFechaTomaExamen(Date fechaTomaExamen) {
        this.fechaTomaExamen = fechaTomaExamen;
    }

    public int getTieneTomaExamen() {
        return tieneTomaExamen;
    }

    public void setTieneTomaExamen(int tieneTomaExamen) {
        this.tieneTomaExamen = tieneTomaExamen;
    }

    public Date getFechaResultado() {
        return fechaResultado;
    }

    public void setFechaResultado(Date fechaResultado) {
        this.fechaResultado = fechaResultado;
    }

    public int getTieneResultado() {
        return tieneResultado;
    }

    public void setTieneResultado(int tieneResultado) {
        this.tieneResultado = tieneResultado;
    }

    public Date getFechaAprobado() {
        return fechaAprobado;
    }

    public void setFechaAprobado(Date fechaAprobado) {
        this.fechaAprobado = fechaAprobado;
    }

    public int getTieneAprobado() {
        return tieneAprobado;
    }

    public void setTieneAprobado(int tieneAprobado) {
        this.tieneAprobado = tieneAprobado;
    }

    public String getMedcod() {
        return medcod;
    }

    public void setMedcod(String medcod) {
        this.medcod = medcod;
    }

    public String getExaapr() {
        return exaapr;
    }

    public void setExaapr(String exaapr) {
        this.exaapr = exaapr;
    }

    public String getPactel() {
        return pactel;
    }

    public void setPactel(String pactel) {
        this.pactel = pactel;
    }
    
}
