/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsos.kbse.bibo.boundary;

import de.hsos.kbse.bibo.controller.BookController;
import de.hsos.kbse.bibo.controller.BookingController;
import de.hsos.kbse.bibo.controller.MemberController;
import de.hsos.kbse.bibo.entity.Booking;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Lukas Hannigbrinck <lukas.hannigbrinck@hs-osnabrueck.de>
 */
@RequestScoped
@Named
public class borrowedModel {
    
    @Inject
    private BookingController bookingController;
    
    @Inject 
    private MemberController memberController;
    
    @Inject 
    private BookController bookController;

    public borrowedModel() {
    
    }
    
    private List<Booking> borrowedBooks;
    
    public void borrowedBooksFromRepo(){
        borrowedBooks = bookingController.borrowed(memberController.getMember());
    }

    public List<Booking> getBorrowedBooks() {
        if(borrowedBooks == null){
            borrowedBooksFromRepo();
        }
        
        return borrowedBooks;
    }
    
    public boolean booksBorrowed(){
        if(borrowedBooks == null){
            borrowedBooksFromRepo();
        }
        
        return !borrowedBooks.isEmpty();
    }
    
        public String show(String isbn ){
        
        System.out.println("Detail Page of: " + isbn);
        
        bookController.setDetailedBook(bookController.findBookByISBN(isbn));
        
        return "/book.xhtml";
    }

    
}
