package entity;

import entity.TestListmot;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-06T09:04:47")
@StaticMetamodel(Test.class)
public class Test_ { 

    public static volatile SingularAttribute<Test, Date> dateCreation;
    public static volatile SingularAttribute<Test, String> titre;
    public static volatile SingularAttribute<Test, Date> dateModification;
    public static volatile CollectionAttribute<Test, TestListmot> testListmotCollection;
    public static volatile SingularAttribute<Test, Integer> id;

}