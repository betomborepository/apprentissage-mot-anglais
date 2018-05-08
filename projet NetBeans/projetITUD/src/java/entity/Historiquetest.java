/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "DATE_TEST")
    @Temporal(TemporalType.DATE)
    private Date dateTest;
    @Column(name = "NOTE")
    private Double note;
    @JoinColumn(name = "ID_UTILISATEUR", referencedColumnName = "ID")
    @ManyToOne
    private Utilisateur idUtilisateur;

    @JoinColumn(name = "ID_TEST", referencedColumnName = "ID")
    @ManyToOne(fetch=FetchType.LAZY,cascade =   CascadeType.ALL)
    private Test idTest;
    
    public Historiquetest() {
    }

    public Historiquetest( Date dateTest, Double note, Utilisateur idUtilisateur) {
        this.setDateTest(dateTest);
        this.setNote(note);
        this.setIdUtilisateur(idUtilisateur);
    }

    public Historiquetest(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateTest() {
        return dateTest;
    }

    public void setDateTest(Date dateTest) {
        this.dateTest = dateTest;
    }

    public Double getNote() {
        return note;
    }

    public void setNote(Double note) {
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

    public Test getIdTest() {
        return idTest;
    }

    public void setIdTest(Test idTest) {
        this.idTest = idTest;
    }
    
}
