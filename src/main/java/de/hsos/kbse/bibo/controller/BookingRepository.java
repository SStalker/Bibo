/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsos.kbse.bibo.controller;

import de.hsos.kbse.bibo.entity.Book;
import de.hsos.kbse.bibo.entity.Booking;
import de.hsos.kbse.bibo.entity.Member;
import java.util.Date;
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
 * @author rapgrewe
 */
@Named
@ApplicationScoped
@Transactional(Transactional.TxType.REQUIRED)
public class BookingRepository {
    
    @PersistenceContext(unitName = "bibo", type=PersistenceContextType.TRANSACTION)
    EntityManager em;
    
    public void insert(Booking booking) {
        em.persist(booking);
    }
    
    public void update(Booking booking){
        em.merge(booking);
    }
    
    public void delete(int uid){
        Booking booking = findById(uid);
        
        if( booking != null)
            em.remove(booking);
    }
    
    public Booking findById(int uid){
        return em.find(Booking.class, uid);        
    }   

    void borrow(Member member, Book book) {
        Date bookingFrom = new Date();
        // 1209600000 = 2 weeks :D
        Date bookingTo = new Date(bookingFrom.getTime() + 1209600000);
        
        Booking b = new Booking(bookingFrom, bookingTo, member, book);
        
        insert(b);
    }

    boolean hasBorrowed(Member member, Book book){

        Query query = em.createQuery(""
                    + "SELECT b FROM Booking b "
                    + "WHERE b.book.isbn = :isbn "
                    + "AND b.member.id = :id");
            query.setParameter("isbn", book.getIsbn());
            query.setParameter("id", member.getId());

            List<Book> results = query.getResultList();

        return results.size() > 0;
    }
}
