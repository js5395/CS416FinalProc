package edu.ccsu.controller;

import edu.ccsu.model.Music;
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
public class MusicController {
    @PersistenceUnit(unitName = "CS416FinalProjPU")
    private EntityManagerFactory entityManagerFactory;
    @Resource
    private UserTransaction userTransaction;
    @ManagedProperty(value = "#{music}")
    private Music music;
    
    public String saveMusic() {
        String returnValue = "MusicAddedError";
        try {
            userTransaction.begin();
            EntityManager em = entityManagerFactory.createEntityManager();
            music.setAvailableCopies(music.getTotalCopies());
            em.persist(music);
            userTransaction.commit();
            em.close();
            returnValue = "MusicAddedConfirmation";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnValue;
    }
    
    public void search(){
        
    }
    
    public Music getMusic(){
        return music;
    }
    
    public void setMusic(Music music){
        this.music = music;
    }
}
