/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Listmot;
import entity.Mot;
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
@DataSourceDefinition (
    className="org.apache.derby.jdbc.ClientDataSource",
    name="java:app/jdbc/apprentissageanglais",
    serverName="localhost",
    portNumber=1527,
    user="projetITUD", // nom et
    password="projetITUD", // mot de passe que vous avez donnés lors de la création de la base de données
    databaseName="apprentissageanglais"
)
public class InitBean {

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
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void persist(Object object) {
        em.persist(object);
    }
}
