/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Matiasy
 */
@Entity
@Table(name = "TEST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Test.findAll", query = "SELECT t FROM Test t")
    , @NamedQuery(name = "Test.findById", query = "SELECT t FROM Test t WHERE t.id = :id")
    , @NamedQuery(name = "Test.findByDateCreation", query = "SELECT t FROM Test t WHERE t.dateCreation = :dateCreation")
    , @NamedQuery(name = "Test.findByDateModification", query = "SELECT t FROM Test t WHERE t.dateModification = :dateModification")
    , @NamedQuery(name = "Test.findByTitre", query = "SELECT t FROM Test t WHERE t.titre = :titre")})
public class Test implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Column(name = "DATE_MODIFICATION")
    @Temporal(TemporalType.DATE)
    private Date dateModification;
    @Column(name = "TITRE")
    private String titre;
    @JoinColumn(name = "ID_LISTEMOT", referencedColumnName = "ID")
    @ManyToOne(fetch=FetchType.LAZY)
    private Listmot idListemot;
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID")
    @ManyToOne(fetch=FetchType.LAZY)
    private Utilisateur idUser;

 
    public Test() {
    }

    public Test(Integer id, Date dateCreation, Date dateModification, String titre, Listmot idListemot, Utilisateur idUser) {
        this.setId(id);
        this.setDateModification(dateModification);
        this.setDateCreation(dateCreation);
        this.setTitre(titre);
        this.setIdListemot(idListemot);
        this.setIdUser(idUser);
    }

    public Test(Integer id) {
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

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Listmot getIdListemot() {
        return idListemot;
    }

    public void setIdListemot(Listmot idListemot) {
        this.idListemot = idListemot;
    }

    public Utilisateur getIdUser() {
        return idUser;
    }

    public void setIdUser(Utilisateur idUser) {
        this.idUser = idUser;
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
        if (!(object instanceof Test)) {
            return false;
        }
        Test other = (Test) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Test[ id=" + id + " ]";
    }
    
}
