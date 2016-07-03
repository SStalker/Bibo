/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsos.kbse.bibo.boundary;

import de.hsos.kbse.bibo.controller.BookController;
import de.hsos.kbse.bibo.entity.Book;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author sstalker
 */
@RequestScoped
@Named
public class BookDetailModel {
    
    @Inject
    private BookController bookController;
    
    private Book book;
    
    public String show(){
        Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
	
        String isbn = params.get("isbn");
        
        System.out.println("Detail Page of: " + isbn);
        
        book = bookController.findBookByISBN(isbn);
        
        return "/book.xhtml";
    }
}
