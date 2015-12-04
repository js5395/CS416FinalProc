/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Steve
 */
@ManagedBean
@RequestScoped
@Entity
@Table(name = "Groups")
public class Groups implements Serializable {

    @Id
    @Column(name = "GROUPNAME")
    private String groupName;

    @Column(name = "GROUPDESC")
    private String groupDesc;

    @ManyToMany
    @JoinTable(name = "USER_GROUPS",
            joinColumns = @JoinColumn(name = "GROUPNAME", referencedColumnName = "GROUPNAME"),
            inverseJoinColumns = @JoinColumn(name = "USERNAME", referencedColumnName = "USERNAME"))
    private List<User> users;

    public Groups() {

    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    
    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}
