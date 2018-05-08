/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Listmot;
import entity.Mot;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author hp
 */
@Stateless
public class MotManager {

    @PersistenceContext(unitName = "projetITUDPU")
    private EntityManager em;

    public List<Mot> getAllMots() {
        Query query = em.createNamedQuery("Mot.findAll"); //To change body of generated methods, choose Tools | Templates.
        return query.getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public void persist(Object object) {
        em.persist(object);
    }


    /**
        Retourn la liste de mots en retirant ceux qui sont en argument
        @return List<Mot>
     */
    public List<Mot> getExcludedMot(List<Mot> mots) {

        String listId = formatMotToListID(mots);
        Query query = em.createQuery("select m from Mot m where 1=1  " + listId); //To change body of generated methods, choose Tools | Templates.
        return query.getResultList();
    }

    /**
        Génère une clause where d'une requête SQL qui  permet de faire filtre par rapport à une list d'IDs
     */
    private String formatMotToListID(List<Mot> mots) {
        if (mots.isEmpty()) {
            return "";
        }

        String separator = "";
        String listID = " and m.id not in (";
        for (Mot mot : mots) {
            listID += separator + mot.getId();
            separator = ",";
        }

        listID += ")";

        return listID;
    }

    public Mot findByID(String id) {

        return em.find(Mot.class, Integer.parseInt(id)); 
    }

    public void update(Mot mot) {
        em.merge(mot);
    }


    public void remove(Mot mot) {
        if(em.contains(mot))
        {
            mot = em.merge(mot);
        }
        em.remove(mot); 
    }

}
