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
class Description implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    
    @Size(max = 2048)
    @Lob
    private String text;
    
    @NotNull
    @ManyToOne
    private Author autor;
    
    @NotNull
    @ManyToOne
    private Publisher verlag;

    public Description() {
    }

    public Description(int id, String text, Author autor) {
        this.id = id;
        this.text = text;
        this.autor = autor;
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
     * @return the autor
     */
    public Author getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(Author autor) {
        this.autor = autor;
    }
}
