/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Listmot;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author hp
 */
@Stateless
public class ListMotManager {

    @PersistenceContext(unitName = "projetITUDPU")
    private EntityManager em;

    public List<Listmot> getAllListMots() {
       Query query = em.createNamedQuery("Listmot.findAll"); //To change body of generated methods, choose Tools | Templates.
        return query.getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void persist(Object object) {
        em.persist(object);
    }

    
    public Listmot getListMot(int idDetail) {
        return em.find(Listmot.class, idDetail);
    }
}
