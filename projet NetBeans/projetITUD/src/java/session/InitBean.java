/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Listmot;
import entity.Mot;
import entity.Test;
import entity.Utilisateur;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hp
 */
@Singleton
@LocalBean
@Startup
public class InitBean {

    @PersistenceContext(unitName = "projetITUDPU")
    private EntityManager em;

    /**
        Initialise les donnés par défaut qui serviront de donnés de test pour les utilisateurs
     */
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
        
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Utilisateur u1,u2;
        try {
            u1 = new Utilisateur(771,sdf.parse("2018-05-04"),sdf.parse("2018-05-04"),"administrateur","matiasy");
            u2 = new Utilisateur(772,sdf.parse("2018-05-04"),sdf.parse("2018-05-04"),"administrateur","mariot");
            em.merge(u1);
            em.merge(u2);
            
            Mot m1,m2,m3,m4,m5;
            m1=new Mot(771,"learn","", sdf.parse("2018-05-04"), sdf.parse("2018-05-04"), "apprendre");
            m2=new Mot(772,"teach","", sdf.parse("2018-05-04"), sdf.parse("2018-05-04"), "enseigner");
            m3=new Mot(773,"play","", sdf.parse("2018-05-04"), sdf.parse("2018-05-04"), "jouer");
            m4=new Mot(774,"mouse","", sdf.parse("2018-05-04"), sdf.parse("2018-05-04"), "souris");
            m5=new Mot(775,"cry","", sdf.parse("2018-05-04"), sdf.parse("2018-05-04"), "pleurer");
            em.merge(m1);
            em.merge(m2);
            em.merge(m3);
            em.merge(m4);
            em.merge(m5);
            
            Listmot l1 = new Listmot(771, sdf.parse("2018-05-04"), sdf.parse("2018-05-04"), "apprentissage basique 1", "Basic 1");
            Listmot l2 = new Listmot(772, sdf.parse("2018-05-04"), sdf.parse("2018-05-04"), "apprentissage basique 2", "Basic 2");
            Listmot l3 = new Listmot(773, sdf.parse("2018-05-04"), sdf.parse("2018-05-04"), "apprentissage basique 3", "Basic 3");
            Listmot l4 = new Listmot(774, sdf.parse("2018-05-04"), sdf.parse("2018-05-04"), "apprentissage basique 4", "Basic 4");
            
            l1.getMots().add(m1);l1.getMots().add(m2);l1.getMots().add(m3);l1.getMots().add(m4);
            l2.getMots().add(m2);l2.getMots().add(m3);l2.getMots().add(m4);l2.getMots().add(m5);
            
            em.merge(l1);
            em.merge(l2);
            
            Test t1 = new Test(771, sdf.parse("2018-05-04"), sdf.parse("2018-05-04"), "Test basic 1", l1, u1);
            em.merge(t1);
        } catch (ParseException ex) {
            Logger.getLogger(InitBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void persist(Object object) {
        em.persist(object);
    }
}
