package entity;

import entity.Utilisateur;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-06T19:52:54")
@StaticMetamodel(Historiquetest.class)
public class Historiquetest_ { 

    public static volatile SingularAttribute<Historiquetest, Integer> note;
    public static volatile SingularAttribute<Historiquetest, Utilisateur> idUtilisateur;
    public static volatile SingularAttribute<Historiquetest, Date> id;
    public static volatile SingularAttribute<Historiquetest, Date> dateTest;

}