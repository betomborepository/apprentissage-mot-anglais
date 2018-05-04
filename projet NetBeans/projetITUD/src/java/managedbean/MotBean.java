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
import session.MotManager;

/**
 *
 * @author hp
 */
@Named(value = "motBean")
@ViewScoped
public class MotBean implements Serializable{

    @EJB
    private MotManager motManager;

    /**
     * Creates a new instance of MotBean
     */
    private List <Mot> listMots;
    public MotBean() 
    {
    }
    
    
    public List <Mot> getAllMots()
    {
        if(listMots == null)
        {
            listMots = motManager.getAllMots();
        }
        return listMots;
    }
    
    
    
}
