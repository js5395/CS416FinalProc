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
@Table(name = "Books")
public class Book implements Serializable {
    
    @Id
    @Column(name = "ISBN")
    private int ISBN;
    
    @Column(name = "Title")
    private String title = null;
    
    @Column(name = "Author")
    private String author = null;
    
    @Column(name = "AvailableCopies")
    private Integer availableCopies = null;
    
    @Column(name = "TotalCopies")
    private Integer totalCopies = null;
    
    public Book(){
        
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
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

    @Override
    public String toString() {
        return "";
    }
    
}
