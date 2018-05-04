/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "MOT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mot.findAll", query = "SELECT m FROM Mot m")
    , @NamedQuery(name = "Mot.findById", query = "SELECT m FROM Mot m WHERE m.id = :id")
    , @NamedQuery(name = "Mot.findByAnglais", query = "SELECT m FROM Mot m WHERE m.anglais = :anglais")
    , @NamedQuery(name = "Mot.findByCle", query = "SELECT m FROM Mot m WHERE m.cle = :cle")
    , @NamedQuery(name = "Mot.findByFrancais", query = "SELECT m FROM Mot m WHERE m.francais = :francais")
    , @NamedQuery(name = "Mot.findByDateCreation", query = "SELECT m FROM Mot m WHERE m.dateCreation = :dateCreation")
    , @NamedQuery(name = "Mot.findByDateModification", query = "SELECT m FROM Mot m WHERE m.dateModification = :dateModification")})
public class Mot implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ANGLAIS")
    private Character anglais;
    @Column(name = "CLE")
    private String cle;
    @Column(name = "FRANCAIS")
    private String francais;
    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Column(name = "DATE_MODIFICATION")
    @Temporal(TemporalType.DATE)
    private Date dateModification;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMot")
    private Collection<MotListmot> motListmotCollection;

    public Mot() {
    }

    public Mot(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Character getAnglais() {
        return anglais;
    }

    public void setAnglais(Character anglais) {
        this.anglais = anglais;
    }

    public String getCle() {
        return cle;
    }

    public void setCle(String cle) {
        this.cle = cle;
    }

    public String getFrancais() {
        return francais;
    }

    public void setFrancais(String francais) {
        this.francais = francais;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    @XmlTransient
    public Collection<MotListmot> getMotListmotCollection() {
        return motListmotCollection;
    }

    public void setMotListmotCollection(Collection<MotListmot> motListmotCollection) {
        this.motListmotCollection = motListmotCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mot)) {
            return false;
        }
        Mot other = (Mot) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Mot[ id=" + id + " ]";
    }
    
}