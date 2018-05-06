package entity;

import entity.Listmot;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-06T19:52:54")
@StaticMetamodel(Mot.class)
public class Mot_ { 

    public static volatile SingularAttribute<Mot, String> francais;
    public static volatile SingularAttribute<Mot, Date> dateCreation;
    public static volatile SingularAttribute<Mot, String> anglais;
    public static volatile SingularAttribute<Mot, Date> dateModification;
    public static volatile SingularAttribute<Mot, Integer> id;
    public static volatile SingularAttribute<Mot, String> cle;
    public static volatile ListAttribute<Mot, Listmot> listMots;

}