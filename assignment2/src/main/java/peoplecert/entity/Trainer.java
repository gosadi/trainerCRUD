/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peoplecert.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alkinoos
 */
@Entity
@Table(name = "trainer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trainer.findAll", query = "SELECT t FROM Trainer t")
    , @NamedQuery(name = "Trainer.findByTcode", query = "SELECT t FROM Trainer t WHERE t.tcode = :tcode")
    , @NamedQuery(name = "Trainer.findByTfirstname", query = "SELECT t FROM Trainer t WHERE t.tfirstname = :tfirstname")
    , @NamedQuery(name = "Trainer.findByTlastname", query = "SELECT t FROM Trainer t WHERE t.tlastname = :tlastname")
    , @NamedQuery(name = "Trainer.findByTsubject", query = "SELECT t FROM Trainer t WHERE t.tsubject = :tsubject")
    , @NamedQuery(name = "Trainer.findByTage", query = "SELECT t FROM Trainer t WHERE t.tage = :tage")})
public class Trainer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tcode")
    private Integer tcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tfirstname")
    private String tfirstname;
    @Basic(optional = false)
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 20)
    @Column(name = "tlastname")
    private String tlastname;
    @Basic(optional = false)
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 12)
    @Column(name = "tsubject")
    private String tsubject;
    @Basic(optional = false)
    @NotNull
    @Min(0)
    @Column(name = "tage")
    private int tage;

    public Trainer() {
    }

    public Trainer(Integer tcode) {
        this.tcode = tcode;
    }

    public Trainer(Integer tcode, String tfirstname, String tlastname, String tsubject, int tage) {
        this.tcode = tcode;
        this.tfirstname = tfirstname;
        this.tlastname = tlastname;
        this.tsubject = tsubject;
        this.tage = tage;
    }

    public Integer getTcode() {
        return tcode;
    }

    public void setTcode(Integer tcode) {
        this.tcode = tcode;
    }

    public String getTfirstname() {
        return tfirstname;
    }

    public void setTfirstname(String tfirstname) {
        this.tfirstname = tfirstname;
    }

    public String getTlastname() {
        return tlastname;
    }

    public void setTlastname(String tlastname) {
        this.tlastname = tlastname;
    }

    public String getTsubject() {
        return tsubject;
    }

    public void setTsubject(String tsubject) {
        this.tsubject = tsubject;
    }

    public int getTage() {
        return tage;
    }

    public void setTage(int tage) {
        this.tage = tage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tcode != null ? tcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trainer)) {
            return false;
        }
        Trainer other = (Trainer) object;
        if ((this.tcode == null && other.tcode != null) || (this.tcode != null && !this.tcode.equals(other.tcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "peoplecert.entity.Trainer[ tcode=" + tcode + " ]";
    }
    
}
