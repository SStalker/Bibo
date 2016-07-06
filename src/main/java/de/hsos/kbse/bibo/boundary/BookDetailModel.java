/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsos.kbse.bibo.boundary;

import de.hsos.kbse.bibo.controller.BookController;
import de.hsos.kbse.bibo.controller.BookingController;
import de.hsos.kbse.bibo.controller.MemberController;
import de.hsos.kbse.bibo.entity.Book;
import de.hsos.kbse.bibo.entity.Member;
import java.io.Serializable;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author sstalker
 */
@RequestScoped
@Named
public class BookDetailModel implements Serializable{
    
    @Inject
    private BookController bookController;
    
    @Inject
    private BookingController bookingController;
    
    @Inject
    private MemberController memberController;
    
    //private List<Book> borrowedBooks;

    /**
     * @return the book
     */
    public Book getBook() {
        return bookController.getDetailedBook();
    }
    
    public String borrow(){
        
        FacesContext context = FacesContext.getCurrentInstance();
        Book book = getBook();
        
        if(book != null){

            if(book.getQuantity() <= 0){
                context.addMessage("booking-form", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Buch nicht mehr verfügbar", null));
                return "";
            }

            Member current = memberController.getMember();

            if(bookingController.hasBorrowed(current, book)){
                context.addMessage("booking-form", new FacesMessage(FacesMessage.SEVERITY_WARN,"Buch bereits ausgeliehen", null));
                return "";
            }

            System.out.println(current.getLogin().getUsername() + " möchte das Buch " + book.getTitle() + " ausleihen");
            
            bookingController.borrow(current, book);
            book.setQuantity(book.getQuantity()-1);
            bookController.updateBook(book);
            context.addMessage("booking-form", new FacesMessage(FacesMessage.SEVERITY_INFO,"Buch erfolgreich ausgeliehen", null));
            
            return "";
        } 
        context.addMessage("booking-form", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Internes Problem beim ausleihen!", null));
        return "";        
    }
    
    public String returnBook(Book book){

        Member member = memberController.getMember();
        bookingController.removeBooking(member, book);
        book.setQuantity(book.getQuantity()+1);
        bookController.updateBook(book);
        
        System.out.println("Rückgabe Buch: " + book.getIsbn());
        
        FacesContext.getCurrentInstance().addMessage("booking-form", new FacesMessage(FacesMessage.SEVERITY_INFO, "Buch erfolgreich zurück gegeben!", null));
        return "";
    }
    
    public boolean hasBookBorrowed(Book book){
        Member member = memberController.getMember();

        return bookingController.hasBorrowed(member, book);
    }
}
