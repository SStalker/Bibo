/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsos.kbse.bibo.controller;

import de.hsos.kbse.bibo.entity.Book;
import de.hsos.kbse.bibo.entity.Member;
import java.sql.SQLException;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.executable.ValidateOnExecution;

/**
 *
 * @author sstalker
 */
@ApplicationScoped
public class BookController {
    
    @Inject 
    private BookRepository repo;
           
    @Transactional(value = Transactional.TxType.REQUIRES_NEW,
            rollbackOn = {ValidateOnExecution.class, SQLException.class})
    public List<Book> searchForBook(String val){
        return repo.find(val);
    }
    
    public Book findBookByISBN(String isbn){
        return repo.findBookByISBN(isbn);
    }
    
    public void showDetailPage(String isbn){
        System.out.println("isbn: " + isbn);
    }
    
    public List<Book> findAll(){
        return repo.findAllBooks();
    }
    
    public void borrow(Book book){
    
    }
}
