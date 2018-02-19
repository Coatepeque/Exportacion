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
@Table(name = "movimiento_banco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MovimientoBanco.findAll", query = "SELECT m FROM MovimientoBanco m")
    , @NamedQuery(name = "MovimientoBanco.findByIdMovimientoBanco", query = "SELECT m FROM MovimientoBanco m WHERE m.idMovimientoBanco = :idMovimientoBanco")
    , @NamedQuery(name = "MovimientoBanco.findByFecha", query = "SELECT m FROM MovimientoBanco m WHERE m.fecha = :fecha")
    , @NamedQuery(name = "MovimientoBanco.findByNoDocumento", query = "SELECT m FROM MovimientoBanco m WHERE m.noDocumento = :noDocumento")
    , @NamedQuery(name = "MovimientoBanco.findByCantidad", query = "SELECT m FROM MovimientoBanco m WHERE m.cantidad = :cantidad")
    , @NamedQuery(name = "MovimientoBanco.findByTipoMovimineto", query = "SELECT m FROM MovimientoBanco m WHERE m.tipoMovimineto = :tipoMovimineto")
    , @NamedQuery(name = "MovimientoBanco.findByObservacion", query = "SELECT m FROM MovimientoBanco m WHERE m.observacion = :observacion")})
public class MovimientoBanco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Movimiento_Banco")
    private Integer idMovimientoBanco;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "No_Documento")
    private String noDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Cantidad")
    private String cantidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "Tipo_Movimineto")
    private String tipoMovimineto;
    @Size(max = 200)
    @Column(name = "Observacion")
    private String observacion;
    @JoinColumn(name = "Cuenta", referencedColumnName = "No_Cuenta")
    @ManyToOne(optional = false)
    private Banco cuenta;

    public MovimientoBanco() {
    }

    public MovimientoBanco(Integer idMovimientoBanco) {
        this.idMovimientoBanco = idMovimientoBanco;
    }

    public MovimientoBanco(Integer idMovimientoBanco, Date fecha, String noDocumento, String cantidad, String tipoMovimineto) {
        this.idMovimientoBanco = idMovimientoBanco;
        this.fecha = fecha;
        this.noDocumento = noDocumento;
        this.cantidad = cantidad;
        this.tipoMovimineto = tipoMovimineto;
    }

    public Integer getIdMovimientoBanco() {
        return idMovimientoBanco;
    }

    public void setIdMovimientoBanco(Integer idMovimientoBanco) {
        this.idMovimientoBanco = idMovimientoBanco;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNoDocumento() {
        return noDocumento;
    }

    public void setNoDocumento(String noDocumento) {
        this.noDocumento = noDocumento;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipoMovimineto() {
        return tipoMovimineto;
    }

    public void setTipoMovimineto(String tipoMovimineto) {
        this.tipoMovimineto = tipoMovimineto;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Banco getCuenta() {
        return cuenta;
    }

    public void setCuenta(Banco cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMovimientoBanco != null ? idMovimientoBanco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovimientoBanco)) {
            return false;
        }
        MovimientoBanco other = (MovimientoBanco) object;
        if ((this.idMovimientoBanco == null && other.idMovimientoBanco != null) || (this.idMovimientoBanco != null && !this.idMovimientoBanco.equals(other.idMovimientoBanco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.MovimientoBanco[ idMovimientoBanco=" + idMovimientoBanco + " ]";
    }
    
}
