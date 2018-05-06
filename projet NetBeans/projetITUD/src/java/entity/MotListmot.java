/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "MOT_LISTMOT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MotListmot.findAll", query = "SELECT m FROM MotListmot m")
    , @NamedQuery(name = "MotListmot.findById", query = "SELECT m FROM MotListmot m WHERE m.id = :id")})
public class MotListmot implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "ID_LISTMOT", referencedColumnName = "ID")
    @ManyToOne
    private Listmot idListmot;
    @JoinColumn(name = "ID_MOT", referencedColumnName = "ID")
    @ManyToOne
    private Mot idMot;

    public MotListmot() {
    }

    public MotListmot(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Listmot getIdListmot() {
        return idListmot;
    }

    public void setIdListmot(Listmot idListmot) {
        this.idListmot = idListmot;
    }

    public Mot getIdMot() {
        return idMot;
    }

    public void setIdMot(Mot idMot) {
        this.idMot = idMot;
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
        if (!(object instanceof MotListmot)) {
            return false;
        }
        MotListmot other = (MotListmot) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.MotListmot[ id=" + id + " ]";
    }
    
}
