package entity;

import entity.MotListmot;
import entity.RevisionListmot;
import entity.TestListmot;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-06T09:04:47")
@StaticMetamodel(Listmot.class)
public class Listmot_ { 

    public static volatile CollectionAttribute<Listmot, RevisionListmot> revisionListmotCollection;
    public static volatile SingularAttribute<Listmot, Date> dateCreation;
    public static volatile SingularAttribute<Listmot, Date> dateModification;
    public static volatile SingularAttribute<Listmot, String> titre;
    public static volatile CollectionAttribute<Listmot, TestListmot> testListmotCollection;
    public static volatile SingularAttribute<Listmot, String> description;
    public static volatile SingularAttribute<Listmot, Integer> id;
    public static volatile CollectionAttribute<Listmot, MotListmot> motListmotCollection;

}