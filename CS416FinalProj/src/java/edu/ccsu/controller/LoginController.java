/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.controller;

import edu.ccsu.model.Groups;
import edu.ccsu.model.User;
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
public class LoginController {

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
            userTransaction.begin();
            EntityManager em = entityManagerFactory.createEntityManager();
            user.setPassword(Hash(user.getPassword()));

            Groups userGroup = em.find(Groups.class, "users");

            userGroup.getUsers().add(user);
            user.getGroups().add(userGroup);
            em.persist(user);
            em.persist(userGroup);
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
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bs.length; i++) {
            sb.append(Integer.toString((bs[i] & 0xff) + 0x100, 16).substring(1));
        }
        /*for(int i=0; i<bs.length; i++){
         String hexVal = Integer.toString(0xFF & bs[i]);
         if(hexVal.length() == 1){
         sBuilder.append('0');
         }
         sBuilder.append(hexVal);         
         }*/
        return sb.toString();
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
