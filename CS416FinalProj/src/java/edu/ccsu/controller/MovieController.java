package edu.ccsu.controller;

import edu.ccsu.model.Movie;
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
public class MovieController {
    @PersistenceUnit(unitName = "CS416FinalProjPU")
    private EntityManagerFactory entityManagerFactory;
    @Resource
    private UserTransaction userTransaction;
    @ManagedProperty(value = "#{movie}")
    private Movie movie;
    
    public String saveMovie() {
        String returnValue = "MovieAddedError";
        try {
            userTransaction.begin();
            EntityManager em = entityManagerFactory.createEntityManager();
            movie.setAvailableCopies(movie.getTotalCopies());
            em.persist(movie);
            userTransaction.commit();
            em.close();
            returnValue = "MovieAddedConfirmation";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnValue;
    }
    
    public List getMatchingMovies() {
        List<Movie> movies = new ArrayList();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //String selectSQL = "select b from Book b where b.ISBN like :isbn";
        String selectSQL = "SELECT m FROM Movie m WHERE m.ID LIKE :id"
                + " OR LOWER(m.publisher) LIKE LOWER(:publisher)"
                + " OR LOWER(m.title) LIKE LOWER(:title)";
        try {
            Query selectQuery = entityManager.createQuery(selectSQL);

            selectQuery.setParameter("id", movie.getID() + "%");
            selectQuery.setParameter("publisher", movie.getPublisher() + "%");
            selectQuery.setParameter("title", movie.getTitle() + "%");

            movies = selectQuery.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return movies;
    }
    
    public Movie getMovie(){
        return movie;
    }
    
    public void setMovie(Movie movie){
        this.movie = movie;
    }
}
