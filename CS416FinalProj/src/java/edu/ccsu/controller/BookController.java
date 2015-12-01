package edu.ccsu.controller;

import edu.ccsu.model.Book;
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
public class BookController {

    @PersistenceUnit(unitName = "CS416FinalProjPU")
    private EntityManagerFactory entityManagerFactory;
    @Resource
    private UserTransaction userTransaction;
    @ManagedProperty(value = "#{book}")
    private Book book;

    public String saveBook() {
        String returnValue = "BookAddedError";
        try {
            userTransaction.begin();
            EntityManager em = entityManagerFactory.createEntityManager();
            book.setAvailableCopies(book.getTotalCopies());
            em.persist(book);
            userTransaction.commit();
            em.close();
            returnValue = "BookAddedConfirmation";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnValue;
    }

    public List getMatchingBooks() {
        List<Book> books = new ArrayList();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        String selectSQL = "SELECT b FROM Book b WHERE b.ISBN LIKE :isbn"
                + " OR LOWER(b.author) LIKE LOWER(:author)"
                + " OR LOWER(b.title) LIKE LOWER(:title)";
        try {
            Query selectQuery = entityManager.createQuery(selectSQL);

            selectQuery.setParameter("isbn",book.getISBN() + "%");
            selectQuery.setParameter("author","%" + book.getAuthor() + "%");
            selectQuery.setParameter("title","%" + book.getTitle() + "%");

            books = selectQuery.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return books;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
