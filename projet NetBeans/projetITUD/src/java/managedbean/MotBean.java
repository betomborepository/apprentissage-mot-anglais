/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.view.ViewScoped;

/**
 *
 * @author hp
 */
@Named(value = "motBean")
@ViewScoped
public class MotBean implements Serializable{

    /**
     * Creates a new instance of MotBean
     */
    public MotBean() {
    }
    
}