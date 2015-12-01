/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author Steve
 */
@Entity
public class Group implements Serializable {

    @Id
    private String groupName;

    private String groupDesc;

    @ManyToMany
    @JoinTable(name = "USER_GROUPS",
            joinColumns = @JoinColumn(name = "GROUPNAME", referencedColumnName = "groupName"),
            inverseJoinColumns = @JoinColumn(name = "USERNAME", referencedColumnName = "username"))
    private Set<User> users = new HashSet();

    public Group() {

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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

}
