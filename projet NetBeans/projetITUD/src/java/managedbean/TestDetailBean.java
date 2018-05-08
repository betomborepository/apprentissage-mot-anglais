/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entity.Listmot;
import entity.Test;
import java.io.Serializable;
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
        return pickingList;
    }

    /**
     * @param pickingList the pickingList to set
     */
    public void setPickingList(DualListModel<Listmot> pickingList) {
        this.pickingList = pickingList;
    }
    
    
    
    public void onChoseListMot(TransferEvent event)
    {
        if(event.isRemove())
                return;
       Listmot listmot = (Listmot) event.getItems().get(0);
       this.test.setIdListemot(listmot);
        testManager.update(test);
    }
    
    
   
    public Converter <Listmot> getListMotConvert()
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
    }
}
