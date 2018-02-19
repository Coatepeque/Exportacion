/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author josue
 */
@Entity
@Table(name = "estatus_factura_pagos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstatusFacturaPagos.findAll", query = "SELECT e FROM EstatusFacturaPagos e")
    , @NamedQuery(name = "EstatusFacturaPagos.findByIdEstatusFacturaPagos", query = "SELECT e FROM EstatusFacturaPagos e WHERE e.idEstatusFacturaPagos = :idEstatusFacturaPagos")
    , @NamedQuery(name = "EstatusFacturaPagos.findByNoEnvio", query = "SELECT e FROM EstatusFacturaPagos e WHERE e.noEnvio = :noEnvio")
    , @NamedQuery(name = "EstatusFacturaPagos.findByFechaPago", query = "SELECT e FROM EstatusFacturaPagos e WHERE e.fechaPago = :fechaPago")})
public class EstatusFacturaPagos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Estatus_Factura_Pagos")
    private Integer idEstatusFacturaPagos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "No_Envio")
    private String noEnvio;
    @Column(name = "Fecha_Pago")
    @Temporal(TemporalType.DATE)
    private Date fechaPago;
    @JoinColumn(name = "Factura", referencedColumnName = "Factura")
    @ManyToOne(optional = false)
    private Venta factura;

    public EstatusFacturaPagos() {
    }

    public EstatusFacturaPagos(Integer idEstatusFacturaPagos) {
        this.idEstatusFacturaPagos = idEstatusFacturaPagos;
    }

    public EstatusFacturaPagos(Integer idEstatusFacturaPagos, String noEnvio) {
        this.idEstatusFacturaPagos = idEstatusFacturaPagos;
        this.noEnvio = noEnvio;
    }

    public Integer getIdEstatusFacturaPagos() {
        return idEstatusFacturaPagos;
    }

    public void setIdEstatusFacturaPagos(Integer idEstatusFacturaPagos) {
        this.idEstatusFacturaPagos = idEstatusFacturaPagos;
    }

    public String getNoEnvio() {
        return noEnvio;
    }

    public void setNoEnvio(String noEnvio) {
        this.noEnvio = noEnvio;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Venta getFactura() {
        return factura;
    }

    public void setFactura(Venta factura) {
        this.factura = factura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstatusFacturaPagos != null ? idEstatusFacturaPagos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstatusFacturaPagos)) {
            return false;
        }
        EstatusFacturaPagos other = (EstatusFacturaPagos) object;
        if ((this.idEstatusFacturaPagos == null && other.idEstatusFacturaPagos != null) || (this.idEstatusFacturaPagos != null && !this.idEstatusFacturaPagos.equals(other.idEstatusFacturaPagos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.EstatusFacturaPagos[ idEstatusFacturaPagos=" + idEstatusFacturaPagos + " ]";
    }
    
}
