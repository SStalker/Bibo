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
 * @author rapgrewe
 */
@Named
@RequestScoped
public class BookingModel implements Serializable{
    
    @Inject
    private BookController bookController;
    
    @Inject
    private BookingController bookingController;
    
    @Inject
    private MemberController memberController;
    
    //private List<Book> borrowedBooks;
    
    public String borrow(){
        
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
	
        String isbn = params.get("isbn");
        Book book = bookController.findBookByISBN(isbn);
        
        if(book != null){

            if(book.getQuantity() <= 0){
                context.addMessage("error", new FacesMessage("Buch nicht mehr verfügbar"));
                return "book";
            }

            Member current = memberController.getMember();

            if(bookingController.hasBorrowed(current, book)){
                context.addMessage("error", new FacesMessage("Buch bereits ausgeliehen"));
                return "book";
            }

            System.out.println(current.getLogin().getUsername() + " möchte das Buch " + book.getTitle() + " ausleihen");
            
            bookingController.borrow(current, book);
            book.setQuantity(book.getQuantity()-1);
            bookController.updateBook(book);
            
            return "home";
        } 
        
        return "home";        
    }    
}
