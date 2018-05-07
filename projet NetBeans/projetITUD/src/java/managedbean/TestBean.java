/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entity.Mot;
import entity.Test;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import session.TestManager;

/**
 *
 * @author Matiasy
 */
@Named(value = "testBean")
@Dependent
public class TestBean {
 @EJB
    private TestManager testManager;

    /**
     * Creates a new instance of MotBean
     */
    private List <Test> listeTest;
    /**
     * Creates a new instance of TestBean
     */
    public List <Test> getAllTests()
    {
        if(listeTest == null)
        {
            listeTest = testManager.getAllTests();
        }
        return listeTest;
    }
   
}
