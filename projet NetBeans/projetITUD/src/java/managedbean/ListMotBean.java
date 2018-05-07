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
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.view.ViewScoped;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DualListModel;
import session.ListMotManager;
import session.MotManager;

/**
 *
 * @author hp
 */
@Named(value = "listMotBean")
@ViewScoped
public class ListMotBean implements Serializable {

    @EJB
    private MotManager motManager;

    @EJB
    private ListMotManager listMotManager;

    /**
     * Creates a new instance of ListMotBean
     */
    private List<entity.Listmot> allListMots;
    private Listmot detailListMot;
    private int idDetail;
    private DualListModel<Mot> motPickingList;

    public ListMotBean() {
    }

    public List<entity.Listmot> getAllListMots() {
        if (allListMots == null) {
            allListMots = listMotManager.getAllListMots();
        }
        return allListMots;
    }

    /**
     * Cette fonction a génerer le lien du detail en fonction de l'objet Listmot
     *
     * @param listmot
     * @return
     */
    public String detail(Listmot listmot) {
        return "detail?faces-redirect=true&idlistmot=" + listmot.getId();
    }

    public void initDetail() {
        this.setDetailListMot(listMotManager.getListMot(this.idDetail));
    }

    public void setMotPickingList(DualListModel<Mot> motPickingList) {
        this.motPickingList = motPickingList;
    }

    public DualListModel<Mot> getMotPickingList() {
        if (this.motPickingList == null) {
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
     * génère une double list, un pour la list de mots disponible une autre pour
     * ceux qui sont selectionnés
     *
     * @return
     */
    private DualListModel<Mot> generateMotPickingList() {
        List<Mot> source = new ArrayList<Mot>();
        List<Mot> target = new ArrayList<Mot>();

        source = motManager.getExcludedMot(detailListMot.getMots());
        target = detailListMot.getMots();

        this.motPickingList = new DualListModel<>(source, target);
        return this.motPickingList;
    }

    public String update() {
        System.out.println("testprint" + this.detail(this.detailListMot));
        // this.detailListMot.setMots( this.motPickingList.getTarget());

        listMotManager.update(this.detailListMot);
        return this.detail(detailListMot);
    }

    public void onTransfer(TransferEvent event) {
        for (Object mot : event.getItems()) {
            if (event.isAdd()) {
                this.detailListMot.getMots().add((Mot) mot);
            } else {
                this.getDetailListMot().getMots().remove((Mot) mot);
            }
        }
    }

    public void onPickListSelect(SelectEvent event) {
        Mot mot = (Mot) event.getObject();
        this.detailListMot.getMots().add(mot);
    }

    public Converter<Mot> getMotConverter() {
        return new Converter<Mot>() {
            @Override
            public Mot getAsObject(FacesContext fc, UIComponent uic, String id) {
                return motManager.findByID(id); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public String getAsString(FacesContext fc, UIComponent uic, Mot t) {
                return t.getId().toString(); //To change body of generated methods, choose Tools | Templates.
            }
        };
    }
}
