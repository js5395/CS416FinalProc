package edu.ccsu.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-13T13:07:45")
@StaticMetamodel(Book.class)
public class Book_ { 

    public static volatile SingularAttribute<Book, Integer> ISBN;
    public static volatile SingularAttribute<Book, Integer> totalCopies;
    public static volatile SingularAttribute<Book, String> author;
    public static volatile SingularAttribute<Book, Integer> availableCopies;
    public static volatile SingularAttribute<Book, String> title;

}