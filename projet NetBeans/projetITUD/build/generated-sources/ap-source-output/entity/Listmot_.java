package entity;

import entity.Mot;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-06T19:52:54")
@StaticMetamodel(Listmot.class)
public class Listmot_ { 

    public static volatile SingularAttribute<Listmot, Date> dateCreation;
    public static volatile ListAttribute<Listmot, Mot> mots;
    public static volatile SingularAttribute<Listmot, Date> dateModification;
    public static volatile SingularAttribute<Listmot, String> titre;
    public static volatile SingularAttribute<Listmot, String> description;
    public static volatile SingularAttribute<Listmot, Integer> id;

}