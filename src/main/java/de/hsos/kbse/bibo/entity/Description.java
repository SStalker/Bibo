/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsos.kbse.bibo.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author sstalker
 */
@Entity
public class Description implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    
    @Size(max = 2048)
    @Lob
    private String text;
    
    @NotNull
    @ManyToOne
    private Author author;
    
    @NotNull
    @ManyToOne
    private Publisher publisher;

    public Description() {
    }

    public Description(int id, String text, Author author, Publisher publisher) {
        this.id = id;
        this.text = text;
        this.author = author;
        this.publisher = publisher;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the author
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
