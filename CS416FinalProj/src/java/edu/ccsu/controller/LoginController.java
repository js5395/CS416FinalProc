/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.controller;

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
public class LoginController  {

    @PersistenceUnit(unitName = "CS416FinalProjPU")
    private EntityManagerFactory entityManagerFactory;
    @Resource
    private UserTransaction userTransaction;
    @ManagedProperty(value = "#{user}")
    private User user;

    public String Login() {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        User u = entityManager.find(User.class, user.getUsername());

        if (u == null) {
            return "Login";
        } else {
            if (user.getPassword().equals(u.getPassword())) {
                
                return "LoginConfirmation";
            } else {
                return "Login";
            }
        }
    }
    
    public String saveUser() {
        String returnValue = "UserAddedError";
        try {
            user.setPassword (Hash(user.getPassword()));
            UserGroup userGroup = new UserGroup();
            userGroup.setUsername(user.getUsername());
            userGroup.setGroupName("users");
            userTransaction.begin();
            EntityManager em = entityManagerFactory.createEntityManager();
            em.persist(userGroup);
            em.persist(user);
            userTransaction.commit();
            em.close();
            returnValue = "UserAddedConfirmation";
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
        return returnValue;
    }
    
    public String Hash(String password) throws NoSuchAlgorithmException {
        MessageDigest msgDigest = MessageDigest.getInstance("MD5");
        byte[] bs;
        msgDigest.reset();
        bs = msgDigest.digest(password.getBytes());
        StringBuilder sBuilder = new StringBuilder();
        for(int i=0; i<bs.length; i++){
            String hexVal = Integer.toString(0xFF & bs[i]);
            if(hexVal.length() == 1){
                sBuilder.append("0");
            }
            sBuilder.append(hexVal);         
        }
        return sBuilder.toString();
    }

    public LoginController() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
