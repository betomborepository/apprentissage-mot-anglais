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
@Singleton
@LocalBean
@Startup
@DataSourceDefinition (
    className="org.apache.derby.jdbc.ClientDataSource",
    name="java:app/jdbc/apprentissageanglais",
    serverName="localhost",
    portNumber=1527,
    user="projetITUD", // nom et
    password="projetITUD", // mot de passe que vous avez donnés lors de la création de la base de données
    databaseName="apprentissageanglais"
)
public class MotManager {

    @PersistenceContext(unitName = "projetITUDPU")
    private EntityManager em;

    @PostConstruct
    public void Init()
    {
        Mot mot = new Mot();
        mot.setAnglais("run");
        mot.setFrancais("courrir");
        mot.setId(0);
        em.merge(mot);
        
        
        Listmot listmot = new Listmot();
        listmot.setId(0);
        listmot.getMots().add(mot);
        listmot.setTitre("manga japonais");
        listmot.setDescription("culture japonais");
        em.merge(listmot);
    }
    
    public List<Mot> getAllMots() 
    {
        Query query = em.createNamedQuery("Mot.findAll"); //To change body of generated methods, choose Tools | Templates.
        return query.getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void persist(Object object) {
        em.persist(object);
    }   

    
    public List<Mot> getExcludedMot(List<Mot> mots) {
        
        String listId = formatMotToListID(mots);
        Query query = em.createQuery("select m from Mot m where 1=1  "+ listId ); //To change body of generated methods, choose Tools | Templates.
        return query.getResultList();        
    }

    
    private String formatMotToListID(List<Mot> mots) {
        if(mots.isEmpty())
            return "";
        
        String separator = "";
        String listID = " and m.id not in (";
        for (Mot mot : mots) 
        {
            listID += separator + mot.getId() ;
            separator = ",";
        }
        
        listID += ")";
        
//To change body of generated methods, choose Tools | Templates.
        return listID;
    }

    public Mot findByID(String id) {
        
        return em.find(Mot.class, Integer.parseInt(id)); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void update(Mot mot)
    {
        em.merge(mot);
    }


}
