package entity;

import entity.Historiquetest;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-06T19:52:54")
@StaticMetamodel(Utilisateur.class)
public class Utilisateur_ { 

    public static volatile SingularAttribute<Utilisateur, Date> dateCreation;
    public static volatile SingularAttribute<Utilisateur, Date> dateModification;
    public static volatile CollectionAttribute<Utilisateur, Historiquetest> historiquetestCollection;
    public static volatile SingularAttribute<Utilisateur, Integer> id;
    public static volatile SingularAttribute<Utilisateur, String> type;

}