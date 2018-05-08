/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Historiquetest;
import entity.Test;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Matiasy
 */
@Stateless
public class TestManager {
    @PersistenceContext(unitName = "projetITUDPU")
    private EntityManager em;
    @PostConstruct
    public void Init()
    {
        
    }
    public List<Test> getAllTests() {
         Query query = em.createNamedQuery("Test.findAll");
         System.out.println("getAllTests "+query.getResultList().size());//To change body of generated methods, choose Tools | Templates.
        return query.getResultList();
    }
    public Test find(Integer id)
    {
         return em.find(Test.class, id);
    }



    public Test update(Test test) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer saveHistory(Historiquetest historiqueT) {
        em.persist(historiqueT);
        em.flush();
       return historiqueT.getId();
    }
}
