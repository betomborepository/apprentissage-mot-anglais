/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entity.Mot;
import entity.Test;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.view.ViewScoped;
import session.TestManager;

/**
 *
 * @author Matiasy
 */
@Named(value = "testBean")
@ViewScoped
public class TestBean implements  Serializable{
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
 
    private String inputTitre;
    
    public String ajouterTest()
    {        
        
        Test test = new Test();
        test.setTitre(this.inputTitre);
        
        
        
        test = testManager.update(test);
        this.getAllTests().add(test);
        
        this.setInputTitre("");        
        
        return "ajout?faces-redirect=true&idTest=" + test.getId() ;
    }

    /**
     * @return the inputTitre
     */
    public String getInputTitre() {
        return inputTitre;
    }

    /**
     * @param inputTitre the inputTitre to set
     */
    public void setInputTitre(String inputTitre) {
        this.inputTitre = inputTitre;
    }
    
    public String testModifUrl(Test test)
    {
        return "ajout?idTest=" + test.getId();
    }
}
