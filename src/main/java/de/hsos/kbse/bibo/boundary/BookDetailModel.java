/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsos.kbse.bibo.boundary;

import de.hsos.kbse.bibo.controller.BookController;
import de.hsos.kbse.bibo.entity.Book;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author sstalker
 */
@SessionScoped
@Named
public class BookDetailModel implements Serializable{
    
    @Inject
    private BookController bookController;
    
    private Book book;
    
    public String show(String isbn ){
        
        System.out.println("Detail Page of: " + isbn);
        
        book = bookController.findBookByISBN(isbn);
        
        return "/book.xhtml";
    }

    /**
     * @return the book
     */
    public Book getBook() {
        return book;
    }
}
