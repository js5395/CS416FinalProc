/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ccsu.model;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author steve
 */
@ManagedBean
@SessionScoped
@Entity
@Table(name = "USERTABLE")
public class User implements Serializable {
    
    @Id
    @Column(name="USERNAME")
    private String username;
    
    @Column(name="PASSWORD")
    private String password;
    
    @Column(name="ISADMIN")
    private boolean isAdmin;
    
    private boolean isLoggedIn = false;

    public User() {
    }
    
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }

    
    public boolean getIsAdmin(){
        return isAdmin;
    }
    
    public void setIsAdmin(boolean isAdmin){
        this.isAdmin = isAdmin;
    }
    
    public boolean getIsLoggedIn(){
        return isLoggedIn;
    }
    
    public void setIsLoggedIn(boolean isLoggedIn){
        this.isLoggedIn = isLoggedIn;
    }
    
}
