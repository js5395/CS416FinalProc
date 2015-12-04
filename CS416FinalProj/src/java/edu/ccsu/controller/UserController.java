/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.controller;

import edu.ccsu.model.Book;
import edu.ccsu.model.Groups;
import edu.ccsu.model.User;
import edu.ccsu.model.UserGroup;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

/**
 *
 * @author steve
 */
@ManagedBean
public class UserController {

    @PersistenceUnit(unitName = "CS416FinalProjPU")
    private EntityManagerFactory entityManagerFactory;
    @Resource
    private UserTransaction userTransaction;
    @ManagedProperty(value = "#{user}")
    private User user;

    public List getUserBooks(String currentUser) {
        //User foundUser;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        User user = entityManager.find(User.class, currentUser);

        List<Book> books = user.getBooks();

        return books;
    }

    public UserController() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
