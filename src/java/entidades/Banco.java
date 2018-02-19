/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author josue
 */
@Entity
@Table(name = "banco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Banco.findAll", query = "SELECT b FROM Banco b")
    , @NamedQuery(name = "Banco.findByNoCuenta", query = "SELECT b FROM Banco b WHERE b.noCuenta = :noCuenta")
    , @NamedQuery(name = "Banco.findByBanco", query = "SELECT b FROM Banco b WHERE b.banco = :banco")
    , @NamedQuery(name = "Banco.findByTipoCuenta", query = "SELECT b FROM Banco b WHERE b.tipoCuenta = :tipoCuenta")})
public class Banco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "No_Cuenta")
    private String noCuenta;
    @Size(max = 75)
    @Column(name = "Banco")
    private String banco;
    @Size(max = 75)
    @Column(name = "Tipo_Cuenta")
    private String tipoCuenta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuenta")
    private List<MovimientoBanco> movimientoBancoList;

    public Banco() {
    }

    public Banco(String noCuenta) {
        this.noCuenta = noCuenta;
    }

    public String getNoCuenta() {
        return noCuenta;
    }

    public void setNoCuenta(String noCuenta) {
        this.noCuenta = noCuenta;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    @XmlTransient
    public List<MovimientoBanco> getMovimientoBancoList() {
        return movimientoBancoList;
    }

    public void setMovimientoBancoList(List<MovimientoBanco> movimientoBancoList) {
        this.movimientoBancoList = movimientoBancoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noCuenta != null ? noCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Banco)) {
            return false;
        }
        Banco other = (Banco) object;
        if ((this.noCuenta == null && other.noCuenta != null) || (this.noCuenta != null && !this.noCuenta.equals(other.noCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Banco[ noCuenta=" + noCuenta + " ]";
    }
    
}
