/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entity.Listmot;
import static com.sun.javafx.logging.PulseLogger.addMessage;
import entity.Historiquetest;
import entity.Mot;
import entity.Test;
import entity.Utilisateur;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.view.ViewScoped;
import session.TestManager;
import javax.ejb.EJB;  
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;
import session.ListMotManager;
import javax.faces.event.ActionEvent;
/**
 *
 * @author Matiasy
 */
@Named(value = "testDetailBean")
@ViewScoped
public class TestDetailBean implements Serializable{

    @EJB
    private ListMotManager listMotManager;
    private Test test;
    private Integer idTest;
    private DualListModel<Listmot> pickingList;
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

    /**
     * @return the pickingList
     */
    public DualListModel<Listmot> getPickingList() {
        if(pickingList == null)
        {
            this.pickingList = generatePickingList();
        }
        return pickingList;
    }
    
    /**
     * 
     * @return DualListMoedl<Listmot> 
     */
    public DualListModel<Listmot> generatePickingList()
    {
        List<Listmot> source = new ArrayList<Listmot>();
        List<Listmot> target = new ArrayList<Listmot>();
        
        source = listMotManager.getAllListMots();
        
        if(this.test.getIdListemot() != null)
        {            
            target.add(this.test.getIdListemot());
            source.remove(this.test.getIdListemot());
        }
        this.pickingList = new DualListModel<>(source, target);
        return this.pickingList;
    }
    

    /**
     * @param pickingList the pickingList to set
     */
    public void setPickingList(DualListModel<Listmot> pickingList) {
        this.pickingList = pickingList;
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
    public String sauvegarderTest(){
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
        Historiquetest historiqueT = new Historiquetest(new Date(), noteFinal, uConnecte,sens);
        //this.test = testManager.
        historiqueT.setIdTest(test);
        System.out.println("Votre Note "+noteFinal);
        Integer newHistoID = testManager.saveHistory(historiqueT);
        
        return "test-result.xhtml?faces-redirect=true&idHistorique=" + newHistoID;
    }
    
    
    
    public void onChoseListMot(TransferEvent event)
    {
        if(event.isRemove())
                return;
       Listmot listmot = (Listmot) event.getItems().get(0);
       this.test.setIdListemot(listmot);
        testManager.update(test);
    }
    
    
   
    /*public Converter <Listmot> getListMotConvert()
    {
        return new Converter<Listmot>() {
            @Override
            public Listmot getAsObject(FacesContext fc, UIComponent uic, String id) {
              return  listMotManager.findByID(id) ; //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public String getAsString(FacesContext fc, UIComponent uic, Listmot t) {
                return t.getId().toString(); //To change body of generated methods, choose Tools | Templates.
            }
        };
    }*/
}
