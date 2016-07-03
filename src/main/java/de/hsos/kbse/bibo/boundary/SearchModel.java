/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsos.kbse.bibo.boundary;

import de.hsos.kbse.bibo.controller.BookController;
import de.hsos.kbse.bibo.controller.BookRepository;
import de.hsos.kbse.bibo.entity.Book;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author sstalker
 */
@RequestScoped
@Named
public class SearchModel {
    
    @Inject
    private BookController bookController;
    
    private List<Book> books;
    
    private String searchString;

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public List<Book> getBooks() {
        return books;
    }
    
    public String search(){
        System.out.println("Search for: " + searchString);
        books = bookController.searchForBook(searchString);
        
        return "/search.xhtml";        
    }
    
    public List<Book> getAllBooks(){
        books = bookController.findAll();        
        return books;
    }
}
