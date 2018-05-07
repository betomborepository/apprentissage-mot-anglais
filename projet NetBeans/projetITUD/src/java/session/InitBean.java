/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;

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

    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
