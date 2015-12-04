package edu.ccsu.model;

import edu.ccsu.model.Book;
import edu.ccsu.model.Groups;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-04T16:36:35")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> password;
    public static volatile ListAttribute<User, Book> books;
    public static volatile ListAttribute<User, Groups> groups;
    public static volatile SingularAttribute<User, String> username;
    public static volatile SingularAttribute<User, Double> amountOwed;

}