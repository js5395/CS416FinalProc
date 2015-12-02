package edu.ccsu.model;

import edu.ccsu.model.Book;
import edu.ccsu.model.Group;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-02T13:53:08")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> password;
    public static volatile SetAttribute<User, Book> books;
    public static volatile SetAttribute<User, Group> groups;
    public static volatile SingularAttribute<User, String> username;
    public static volatile SingularAttribute<User, Double> amountOwed;

}