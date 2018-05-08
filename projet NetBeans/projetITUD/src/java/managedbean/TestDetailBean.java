/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import static com.sun.javafx.logging.PulseLogger.addMessage;
import entity.Historiquetest;
import entity.Mot;
import entity.Test;
import entity.Utilisateur;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
    Boolean[] reponseVisibility;
    String[]reponseTapee;
    Boolean[] jugement;
    int motSize = 0;
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
        initParam();
        if(sens){
            sensLabel="francais";
        }else{
            sensLabel="anglais";
        }
    }  
    private void initParam()
    {
         motSize = test.getIdListemot().getMots().size();
        reponseVisibility = new Boolean[motSize];
        reponseTapee = new String[motSize];
        jugement = new Boolean[motSize];
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
    public void toggleAnswer(ActionEvent e) {
        Integer i = (Integer)e.getComponent().getAttributes().get("index");
        this.reponseVisibility[i]=!this.reponseVisibility[i];
    }

    public Boolean[] getReponseVisibility() {
        return reponseVisibility;
    }

    public void setReponseVisibility(Boolean[] reponseVisibility) {
        this.reponseVisibility = reponseVisibility;
    }
    public String[] getReponseTapee() {
        return reponseTapee;
    }

    public void setReponseTapee(String[] reponseTapee) {
        this.reponseTapee = reponseTapee;
    }


    public Boolean[] getJugement() {
        return jugement;
    }

    public void setJugement(Boolean[] jugement) {
        this.jugement = jugement;
    }
    // if(sens) then francais ELSE anglais
    public void sauvegarderTest(){
        int countReponseVrai = 0 ;
        
        List<Mot> listeMot = test.getIdListemot().getMots();
        for(int i=0;i<motSize;i++)
        {
            if(!sens && listeMot.get(i).getFrancais().equals(reponseTapee[i])){
                countReponseVrai++;
            }
            if(sens && listeMot.get(i).getAnglais().equals(reponseTapee[i])){
                countReponseVrai++;
            }
        }
        double notation = 20;
        double noteParReponseVrai = notation/motSize;
        double noteFinal = 0;
        if(countReponseVrai==motSize){
            noteFinal = notation;
        }else{
            noteFinal = countReponseVrai*noteParReponseVrai;
        }
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Utilisateur uConnecte = new Utilisateur(771);
        Historiquetest historiqueT = new Historiquetest(new Date(), noteFinal, uConnecte);
        System.out.println("Votre Note "+noteFinal);
        testManager.saveHistory(historiqueT);
    }
    
}
