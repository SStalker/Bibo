/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsos.kbse.bibo.controller;

import de.hsos.kbse.bibo.entity.Book;
import de.hsos.kbse.bibo.entity.Member;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 *
 * @author rapgrewe
 */
@ApplicationScoped
public class BookingController {
    
    @Inject 
    private BookingRepository repo;
           
    public void borrow(Member member, Book book){
        repo.borrow(member, book);
    }

    public boolean hasBorrowed(Member current, Book book) {
        return repo.hasBorrowed(current, book);
    }
}
