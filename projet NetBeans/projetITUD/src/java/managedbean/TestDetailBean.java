/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entity.Test;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.view.ViewScoped;
import session.TestManager;
import javax.ejb.EJB;  
/**
 *
 * @author Matiasy
 */
@Named(value = "testDetailBean")
@ViewScoped
public class TestDetailBean implements Serializable{
    private Test test;
    private Integer idTest;
    @EJB
    private TestManager testManager;
    /**
     * Creates a new instance of TestDetailBean
     */
    public TestDetailBean() {
        
       
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Integer getIdTest() {
        return idTest;
    }

    public void setIdTest(Integer idTest) {
        System.out.println("setIdTest");
        this.idTest = idTest;
    }
    public String update() {  
        test = testManager.update(test);  
        return "CustomerList";  
    }
          
    public void loadTest() {
        this.test = testManager.find(idTest);  
    }  
    
}
