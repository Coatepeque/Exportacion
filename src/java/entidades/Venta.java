/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author josue
 */
@Entity
@Table(name = "venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v")
    , @NamedQuery(name = "Venta.findByFactura", query = "SELECT v FROM Venta v WHERE v.factura = :factura")
    , @NamedQuery(name = "Venta.findByFecha", query = "SELECT v FROM Venta v WHERE v.fecha = :fecha")
    , @NamedQuery(name = "Venta.findByNoEnvio", query = "SELECT v FROM Venta v WHERE v.noEnvio = :noEnvio")
    , @NamedQuery(name = "Venta.findByCantidad", query = "SELECT v FROM Venta v WHERE v.cantidad = :cantidad")
    , @NamedQuery(name = "Venta.findByTipoVenta", query = "SELECT v FROM Venta v WHERE v.tipoVenta = :tipoVenta")
    , @NamedQuery(name = "Venta.findByPrecio", query = "SELECT v FROM Venta v WHERE v.precio = :precio")})
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Factura")
    private String factura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "No_Envio")
    private String noEnvio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Cantidad")
    private String cantidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Tipo_Venta")
    private String tipoVenta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "Precio")
    private BigDecimal precio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factura")
    private List<HistorialFacturas> historialFacturasList;
    @JoinColumn(name = "Centro", referencedColumnName = "id_Centro")
    @ManyToOne(optional = false)
    private Centro centro;
    @JoinColumn(name = "Nit", referencedColumnName = "Nit")
    @ManyToOne(optional = false)
    private Cliente nit;
    @JoinColumn(name = "Producto", referencedColumnName = "id_Producto")
    @ManyToOne(optional = false)
    private Producto producto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factura")
    private List<EstatusFacturaPagos> estatusFacturaPagosList;

    public Venta() {
    }

    public Venta(String factura) {
        this.factura = factura;
    }

    public Venta(String factura, Date fecha, String noEnvio, String cantidad, String tipoVenta, BigDecimal precio) {
        this.factura = factura;
        this.fecha = fecha;
        this.noEnvio = noEnvio;
        this.cantidad = cantidad;
        this.tipoVenta = tipoVenta;
        this.precio = precio;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNoEnvio() {
        return noEnvio;
    }

    public void setNoEnvio(String noEnvio) {
        this.noEnvio = noEnvio;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(String tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    @XmlTransient
    public List<HistorialFacturas> getHistorialFacturasList() {
        return historialFacturasList;
    }

    public void setHistorialFacturasList(List<HistorialFacturas> historialFacturasList) {
        this.historialFacturasList = historialFacturasList;
    }

    public Centro getCentro() {
        return centro;
    }

    public void setCentro(Centro centro) {
        this.centro = centro;
    }

    public Cliente getNit() {
        return nit;
    }

    public void setNit(Cliente nit) {
        this.nit = nit;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @XmlTransient
    public List<EstatusFacturaPagos> getEstatusFacturaPagosList() {
        return estatusFacturaPagosList;
    }

    public void setEstatusFacturaPagosList(List<EstatusFacturaPagos> estatusFacturaPagosList) {
        this.estatusFacturaPagosList = estatusFacturaPagosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (factura != null ? factura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.factura == null && other.factura != null) || (this.factura != null && !this.factura.equals(other.factura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return factura;
    }
    
}
