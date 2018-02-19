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
@Table(name = "historial_facturas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistorialFacturas.findAll", query = "SELECT h FROM HistorialFacturas h")
    , @NamedQuery(name = "HistorialFacturas.findByIdHistorialFacturas", query = "SELECT h FROM HistorialFacturas h WHERE h.idHistorialFacturas = :idHistorialFacturas")
    , @NamedQuery(name = "HistorialFacturas.findByFecha", query = "SELECT h FROM HistorialFacturas h WHERE h.fecha = :fecha")
    , @NamedQuery(name = "HistorialFacturas.findByObservacion", query = "SELECT h FROM HistorialFacturas h WHERE h.observacion = :observacion")})
public class HistorialFacturas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Historial_Facturas")
    private Integer idHistorialFacturas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 200)
    @Column(name = "Observacion")
    private String observacion;
    @JoinColumn(name = "Estatus", referencedColumnName = "id_Estatus")
    @ManyToOne(optional = false)
    private Estatus estatus;
    @JoinColumn(name = "Factura", referencedColumnName = "Factura")
    @ManyToOne(optional = false)
    private Venta factura;

    public HistorialFacturas() {
    }

    public HistorialFacturas(Integer idHistorialFacturas) {
        this.idHistorialFacturas = idHistorialFacturas;
    }

    public HistorialFacturas(Integer idHistorialFacturas, Date fecha) {
        this.idHistorialFacturas = idHistorialFacturas;
        this.fecha = fecha;
    }

    public Integer getIdHistorialFacturas() {
        return idHistorialFacturas;
    }

    public void setIdHistorialFacturas(Integer idHistorialFacturas) {
        this.idHistorialFacturas = idHistorialFacturas;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Estatus getEstatus() {
        return estatus;
    }

    public void setEstatus(Estatus estatus) {
        this.estatus = estatus;
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
        hash += (idHistorialFacturas != null ? idHistorialFacturas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistorialFacturas)) {
            return false;
        }
        HistorialFacturas other = (HistorialFacturas) object;
        if ((this.idHistorialFacturas == null && other.idHistorialFacturas != null) || (this.idHistorialFacturas != null && !this.idHistorialFacturas.equals(other.idHistorialFacturas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.HistorialFacturas[ idHistorialFacturas=" + idHistorialFacturas + " ]";
    }
    
}
