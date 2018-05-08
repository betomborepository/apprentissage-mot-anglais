/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import static com.sun.javafx.logging.PulseLogger.addMessage;
import entity.Test;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.view.ViewScoped;
import session.TestManager;
import javax.ejb.EJB;  
import javax.faces.event.ActionEvent;
/**
 *
 * @author Matiasy
 */
@Named(value = "testDetailBean")
@ViewScoped
public class TestDetailBean implements Serializable{
    private Test test;
    private Integer idTest;
    Boolean sens ; 
    String sensLabel;
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
    public void beginTest() {
        this.test = testManager.find(idTest);
        System.out.println("sens "+sens);
        if(sens){
            sensLabel="francais";
        }else{
            sensLabel="anglais";
        }
    }  
     public Boolean getSens() {
        return sens;
    }

    public void setSens(Boolean sens) {
        this.sens = sens;
    }

    public String getSensLabel() {
        return sensLabel;
    }

    public void setSensLabel(String sensLabel) {
        this.sensLabel = sensLabel;
    }
    public void buttonAction(ActionEvent actionEvent) {
        addMessage("Welcome to Primefaces!!");
    }
    
}
