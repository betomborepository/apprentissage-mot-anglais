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
 * @author hp
 */
@Entity
@Table(name = "HISTORIQUETEST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historiquetest.findAll", query = "SELECT h FROM Historiquetest h")
    , @NamedQuery(name = "Historiquetest.findById", query = "SELECT h FROM Historiquetest h WHERE h.id = :id")
    , @NamedQuery(name = "Historiquetest.findByDateTest", query = "SELECT h FROM Historiquetest h WHERE h.dateTest = :dateTest")
    , @NamedQuery(name = "Historiquetest.findByNote", query = "SELECT h FROM Historiquetest h WHERE h.note = :note")})
public class Historiquetest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @Temporal(TemporalType.DATE)
    private Date id;
    @Column(name = "DATE_TEST")
    @Temporal(TemporalType.DATE)
    private Date dateTest;
    @Column(name = "NOTE")
    private Integer note;
    @JoinColumn(name = "ID_UTILISATEUR", referencedColumnName = "ID")
    @ManyToOne
    private Utilisateur idUtilisateur;

    public Historiquetest() {
    }

    public Historiquetest(Date id) {
        this.id = id;
    }

    public Date getId() {
        return id;
    }

    public void setId(Date id) {
        this.id = id;
    }

    public Date getDateTest() {
        return dateTest;
    }

    public void setDateTest(Date dateTest) {
        this.dateTest = dateTest;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public Utilisateur getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Utilisateur idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
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
        if (!(object instanceof Historiquetest)) {
            return false;
        }
        Historiquetest other = (Historiquetest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Historiquetest[ id=" + id + " ]";
    }
    
}
