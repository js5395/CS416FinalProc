/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author James
 */
@ManagedBean
@Entity
@Table( name = "Books")
public class Book implements Serializable {
    
    @Id
    @Column(name = "ISBN")
    private Integer ISBN = null;
    
    @Id
    @Column(name = "title")
    private String Title = null;
    
    @Id
    @Column(name = "author")
    private String Author = null;
   
    @Id
    @Column(name = "availablecopies")
    private Integer AvailableCopies = null;
    
    @Id
    @Column(name = "totalcopies")
    private Integer TotalCopies = null;
    

    @Override
    public String toString() {
        return "beans.Book[ ISBN=" + getISBN() + " ]";
    }

    /**
     * @return the ISBN
     */
    public Integer getISBN() {
        return ISBN;
    }

    /**
     * @param ISBN the ISBN to set
     */
    public void setISBN(Integer ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * @return the Title
     */
    public String getTitle() {
        return Title;
    }

    /**
     * @param Title the Title to set
     */
    public void setTitle(String Title) {
        this.Title = Title;
    }

    /**
     * @return the Author
     */
    public String getAuthor() {
        return Author;
    }

    /**
     * @param Author the Author to set
     */
    public void setAuthor(String Author) {
        this.Author = Author;
    }

    /**
     * @return the AvailableCopies
     */
    public Integer getAvailableCopies() {
        return AvailableCopies;
    }

    /**
     * @param AvailableCopies the AvailableCopies to set
     */
    public void setAvailableCopies(Integer AvailableCopies) {
        this.AvailableCopies = AvailableCopies;
    }

    /**
     * @return the TotalCopies
     */
    public Integer getTotalCopies() {
        return TotalCopies;
    }

    /**
     * @param TotalCopies the TotalCopies to set
     */
    public void setTotalCopies(Integer TotalCopies) {
        this.TotalCopies = TotalCopies;
    }

    
    
}
