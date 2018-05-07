/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name = "LISTMOT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Listmot.findAll", query = "SELECT l FROM Listmot l")
    , @NamedQuery(name = "Listmot.findById", query = "SELECT l FROM Listmot l WHERE l.id = :id")
    , @NamedQuery(name = "Listmot.findByDateCreation", query = "SELECT l FROM Listmot l WHERE l.dateCreation = :dateCreation")
    , @NamedQuery(name = "Listmot.findByDateModification", query = "SELECT l FROM Listmot l WHERE l.dateModification = :dateModification")
    , @NamedQuery(name = "Listmot.findByDescription", query = "SELECT l FROM Listmot l WHERE l.description = :description")
    , @NamedQuery(name = "Listmot.findByTitre", query = "SELECT l FROM Listmot l WHERE l.titre = :titre")})
public class Listmot implements Serializable {

    @OneToMany(mappedBy = "idListemot")
    private Collection<Test> testCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Column(name = "DATE_MODIFICATION")
    @Temporal(TemporalType.DATE)
    private Date dateModification;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "TITRE")
    private String titre;

     
    
    @ManyToMany
    private List<Mot> mots = new ArrayList<>();
    
    public Listmot() {
    }

    public Listmot(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
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
        if (!(object instanceof Listmot)) {
            return false;
        }
        Listmot other = (Listmot) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Listmot[ id=" + id + " ]";
    }

    /**
     * @return the mots
     */
    public List<Mot> getMots() {
        return mots;
    }

    /**
     * @param mots the mots to set
     */
    public void setMots(List<Mot> mots) {
        this.mots = mots;
    }

    @XmlTransient
    public Collection<Test> getTestCollection() {
        return testCollection;
    }

    public void setTestCollection(Collection<Test> testCollection) {
        this.testCollection = testCollection;
    }
    
    
   
}
