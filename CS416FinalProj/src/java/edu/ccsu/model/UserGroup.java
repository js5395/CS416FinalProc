/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.model;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Steve
 */
@ManagedBean
@RequestScoped
@Entity
@Table(name = "USER_GROUPS")
public class UserGroup implements Serializable {
    @Id
    @Column(name="USERNAME")
    private String username;
    
    @Column(name="GROUPNAME")
    private String groupName;

    public UserGroup(){
        
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGroupName(){
        return groupName;
    }
    
    public void setGroupName(String groupName){
        this.groupName = groupName;
    }
    
}
