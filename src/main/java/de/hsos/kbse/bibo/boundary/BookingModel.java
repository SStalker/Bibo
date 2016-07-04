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
import java.util.List;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author rapgrewe
 */
@Named
@SessionScoped
public class BookingModel implements Serializable{
    
    @Inject
    private BookController bookController;
    
    @Inject
    private BookingController bookingController;
    
    @Inject
    private MemberController memberController;
    
    //private List<Book> borrowedBooks;
    
    public String borrow(){
        
        Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
	
        String isbn = params.get("isbn");
        System.out.println("++++++++++++++++ISBN: " + isbn + "+++++++++++++++++++++++++++++++");
        Book book = bookController.findBookByISBN(isbn);
        
        if(book != null){
            Member current = memberController.getMember();
            System.out.println(current.getLogin().getUsername() + " möchte das Buch " + book.getTitle() + " ausleihen");
            
            bookingController.borrow(current, book);
      //      borrowedBooks.add(book);
            
            return "/index.xhtml";
        } 
        
        return "/index.xhtml";        
    }    
}
