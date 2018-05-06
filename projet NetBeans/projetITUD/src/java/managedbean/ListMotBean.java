/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entity.Listmot;
import entity.Mot;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.view.ViewScoped;
import org.primefaces.model.DualListModel;
import session.ListMotManager;

/**
 *
 * @author hp
 */
@Named(value = "listMotBean")
@ViewScoped
public class ListMotBean implements Serializable {

    @EJB
    private ListMotManager listMotManager;

    /**
     * Creates a new instance of ListMotBean
     */
    private List <entity.Listmot> allListMots;
    private Listmot detailListMot;
    private int idDetail;
    private DualListModel<Mot> motPickingList;
    public ListMotBean() 
    {    
    }
    
    
       public List <entity.Listmot> getAllListMots()
    {
        if(allListMots == null)
        {
            allListMots = listMotManager.getAllListMots();
        }
        return allListMots;
    }
       
       
    /**
     * Cette fonction a génerer le lien du detail en fonction de l'objet Listmot
     * @param listmot
     * @return  
     */
    public String detail(Listmot listmot)
    {
        return "detail?faces-redirect=true&idlistmot=" + listmot.getId();
    }
    
    
    public void initDetail()
    {
        this.setDetailListMot(listMotManager.getListMot(this.idDetail));
    }

    public DualListModel<Mot> getMotPickingList()
    {
        if(this.motPickingList == null)
        {
           this.motPickingList = generateMotPickingList();
        }
        
        return this.motPickingList;
    }
    /**
     * @return the detailListMot
     */
    public Listmot getDetailListMot() {
        return detailListMot;
    }

    /**
     * @param detailListMot the detailListMot to set
     */
    public void setDetailListMot(Listmot detailListMot) {
        this.detailListMot = detailListMot;
    }

    /**
     * @return the idDetail
     */
    public int getIdDetail() {
        return idDetail;
    }

    /**
     * @param idDetail the idDetail to set
     */
    public void setIdDetail(int idDetail) {
        this.idDetail = idDetail;
    }

    
    /**
     * génère une double list, un pour la list de mots disponible
     * une autre pour ceux qui sont selectionnés
     * @return 
     */
    private DualListModel<Mot> generateMotPickingList() {
        List<Mot> source = new ArrayList<Mot>();
        List<Mot> target = new ArrayList<Mot>();
        
        
      
        
        return  new DualListModel<>(source, target);                        
    }
    
    
    public String update()
    {
        this.detailListMot.setMots( this.motPickingList.getTarget());
        
        
        listMotManager.update(this.detailListMot);
        return this.detail(this.detailListMot);
    }
    
}
