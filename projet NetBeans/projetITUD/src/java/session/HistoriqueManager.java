/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Historiquetest;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Matiasy
 */
@Stateless
public class HistoriqueManager {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext(unitName = "projetITUDPU")
    private EntityManager em;
    @PostConstruct
    public void Init()
    {
        
    }
    public Historiquetest find(Integer id)
    {
        return em.find(Historiquetest.class, id);
    }
}
