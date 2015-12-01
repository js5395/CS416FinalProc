/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
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
@Table(name = "Movies")
public class Movie implements Serializable {
    
    @Id
    @Column(name = "ID")
    private String ID = null;
    
    @Column(name = "Title")
    private String title = null;
    
    @Column(name = "Publisher")
    private String publisher = null;
    
    @Column(name = "AvailableCopies")
    private Integer availableCopies = null;
    
    @Column(name = "TotalCopies")
    private Integer totalCopies = null;
    
    public Movie(){
        
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
    public String getTitle(){
        return title;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public String getPublisher(){
        return publisher;
    }
    
    public void setPublisher(String publisher){
        this.publisher = publisher;
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

    @Override
    public String toString() {
        return "";
    }
    
}
