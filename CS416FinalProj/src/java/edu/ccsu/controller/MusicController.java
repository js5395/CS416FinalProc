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
 * @artist steve
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

    public List getMatchingMusics() {
        List<Music> musics = new ArrayList();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //String selectSQL = "select b from Music b where b.ID like :ID";
        String selectSQL = "SELECT b FROM Music b WHERE b.ID LIKE :ID"
                + " OR LOWER(b.artist) LIKE LOWER(:artist)"
                + " OR LOWER(b.title) LIKE LOWER(:title)";
        try {
            Query selectQuery = entityManager.createQuery(selectSQL);

            selectQuery.setParameter("ID", music.getID() + "%");
            selectQuery.setParameter("artist", music.getArtist() + "%");
            selectQuery.setParameter("title", music.getTitle() + "%");

            musics = selectQuery.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return musics;
    }

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }
}