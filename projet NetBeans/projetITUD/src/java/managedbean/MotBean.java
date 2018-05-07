/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entity.Mot;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.view.ViewScoped;
import org.primefaces.event.RowEditEvent;
import session.MotManager;


/**
 *
 * @author hp
 */
@Named(value = "motBean")
@ViewScoped
public class MotBean implements Serializable {

    @EJB
    private MotManager motManager;
    private Mot nouveauMot;
    private Mot selectedMot;
    private String inputFr;
    private String inputEn;
    /**
     * Creates a new instance of MotBean
     */
    private List<Mot> listMots;

    public MotBean() {
    }

    public List<Mot> getAllMots() {
        if (listMots == null) {
            listMots = motManager.getAllMots();
        }
        return listMots;
    }
    
     public void onRowEdit(RowEditEvent event) {
        Mot mot = (Mot) event.getObject();
        motManager.update(mot);
    }
     
     public String ajouterMot()
     {
        if(this.inputEn.isEmpty() || this.inputFr.isEmpty())
            return "";
         
         Mot mot = new Mot();
         mot.setFrancais(this.getInputFr());
         mot.setAnglais(this.getInputEn());
         motManager.update(mot);         
         listMots.add(mot);
         
         this.inputEn = "";
         this.inputFr = "";
         
         return "";
     }

    /**
     * @return the nouveauMot
     */
    public Mot getNouveauMot() {
        return nouveauMot;
    }

    /**
     * @param nouveauMot the nouveauMot to set
     */
    public void setNouveauMot(Mot nouveauMot) {
        this.nouveauMot = nouveauMot;
    }

    /**
     * @return the inputFr
     */
    public String getInputFr() {
        return inputFr;
    }

    /**
     * @param inputFr the inputFr to set
     */
    public void setInputFr(String inputFr) {
        this.inputFr = inputFr;
    }

    /**
     * @return the inputEn
     */
    public String getInputEn() {
        return inputEn;
    }

    /**
     * @param inputEn the inputEn to set
     */
    public void setInputEn(String inputEn) {
        this.inputEn = inputEn;
    }
    
    
    public String enleverMot(Mot mot)
    {
        if(!mot.getListMots().isEmpty())
            return null;
        this.listMots.remove(mot);        
        motManager.remove(mot);
        
        return null;
    }

    /**
     * @return the selectedMot
     */
    public Mot getSelectedMot() {
        return selectedMot;
    }

    /**
     * @param selectedMot the selectedMot to set
     */
    public void setSelectedMot(Mot selectedMot) {
        this.selectedMot = selectedMot;
    }
}
