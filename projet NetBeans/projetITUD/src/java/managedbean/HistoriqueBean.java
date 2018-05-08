/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entity.Historiquetest;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import session.HistoriqueManager;

/**
 *
 * @author Matiasy
 */
@Named(value = "historiqueBean")
@ViewScoped
public class HistoriqueBean implements Serializable{
    @EJB
    private HistoriqueManager historiqueManager;
    Historiquetest historique;
    Integer idHistorique;
    /**
     * Creates a new instance of HistoriqueBean
     */
    public HistoriqueBean() {
        
    }
    public void loadHistorique(){
       // System.out.println("histo "+idHistorique);
        this.historique = historiqueManager.find(idHistorique);
        System.out.println("note "+historique.getNote());
        //System.out.println("titre "+historique.getIdTest().getTitre());
    }
    public HistoriqueManager getListMotManager() {
        return historiqueManager;
    }

    public void setListMotManager(HistoriqueManager listMotManager) {
        this.historiqueManager = listMotManager;
    }

    public Historiquetest getHistorique() {
        return historique;
    }

    public void setHistorique(Historiquetest historique) {
        this.historique = historique;
    }

    public Integer getIdHistorique() {
        return idHistorique;
    }

    public void setIdHistorique(Integer idHistorique) {
        this.idHistorique = idHistorique;
    }
    
    
}
