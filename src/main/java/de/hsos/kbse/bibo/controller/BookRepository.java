/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsos.kbse.bibo.controller;

import de.hsos.kbse.bibo.entity.Login;
import de.hsos.kbse.bibo.entity.Book;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 *
 * @author sstalker
 */
@Named
@ApplicationScoped
@Transactional(Transactional.TxType.REQUIRED)
public class BookRepository {
    
    @PersistenceContext(unitName = "bibo", type=PersistenceContextType.TRANSACTION)
    EntityManager em;
    
    public void insert(Book book) {
        em.persist(book);
    }
    
    public void update(Book book){
        em.merge(book);
    }
    
    public void delete(int uid){
        Book book = findById(uid);
        
        if( book != null)
            em.remove(book);
    }
    
    public List<Book> find(String val){
        try{
            System.out.println("Search for " + val);
            Query query = em.createQuery(""
                    + "SELECT b FROM Book b "
                    + "WHERE b.title LIKE :param "
                    + "OR b.description.author.firstname LIKE :param "
                    + "OR b.description.author.lastname LIKE :param "
                    + "OR b.description.publisher.name LIKE :param");
            query.setParameter("param", "%"+val+"%");
            List<Book> results = query.getResultList();

            return results;
        } catch(Exception e) {
            System.out.println("####################" + e.getMessage());
        }
        
        return null;
    }
    
    public Book findBookByISBN(String isbn){
        Query query = em.createQuery(""
                + "SELECT b FROM Book b "
                + "WHERE b.isbn = :param ");
        query.setParameter("param", isbn);
        List<Book> results = query.getResultList();

        if(results.isEmpty())
            return null;
        
        return results.get(0);
    }
    
    public Book findById(int uid){
        return em.find(Book.class, uid);        
    }
    
    public Book findByName(String name){
        Query query = em.createNamedQuery("Book.findByName");
        query.setParameter("bookname", name);
        List<Book> results = query.getResultList();
        
        if(results.isEmpty())
            return null;
        else if (results.size() > 1)
            throw new IllegalStateException("Cannot have more than one book with the same bookname!");
                
        return results.get(0);
    }
}
