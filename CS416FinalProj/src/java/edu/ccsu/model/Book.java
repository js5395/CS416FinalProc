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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
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
@Table(name = "Books")
public class Book implements Serializable {
    
    @Id
    @ManagedProperty(value="#{param.ISBN}")
    @Column(name = "ISBN")
    private String ISBN = null;
    
    @Column(name = "Title")
    private String title = null;
    
    @Column(name = "Author")
    private String author = null;
    
    @Column(name = "AvailableCopies")
    private Integer availableCopies = null;
    
    @Column(name = "TotalCopies")
    private Integer totalCopies = null;
    
    private boolean isSelected = false;
    
    @ManyToMany
    @JoinTable(name="BORROWEDBOOKS",
            joinColumns=@JoinColumn(name="ISBN",referencedColumnName="ISBN"),
            inverseJoinColumns=@JoinColumn(name="USERNAME",referencedColumnName="USERNAME"))
    private List<User> users;
    
    public Book(){
        
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    
    public String getTitle(){
        return title;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public String getAuthor(){
        return author;
    }
    
    public void setAuthor(String author){
        this.author = author;
    }
    
    public Integer getAvailableCopies(){
        return availableCopies;
    }
    
    public void setAvailableCopies(Integer availableCopies){
        this.availableCopies = availableCopies;
    }
    
    public Integer getTotalCopies(){
        return totalCopies;
    }
    
    public void setTotalCopies(Integer totalCopies){
        this.totalCopies = totalCopies;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public boolean isIsSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    
    
}
