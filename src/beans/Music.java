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
@Table( name = "Musics")
public class Music implements Serializable {
    @Id
    @Column(name = "ID")
    private Integer ID;
    
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
        return "beans.Movie[ id=" + getID() + " ]";
    }

    /**
     * @return the ID
     */
    public Integer getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(Integer ID) {
        this.ID = ID;
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
