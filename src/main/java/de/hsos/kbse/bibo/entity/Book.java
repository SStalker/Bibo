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
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author sstalker
 */
@Entity
public class Book implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Pattern(regexp = "(?=[-0-9xX]{13}$)")
    @NotNull
    private String isbn;
    
    @Size(min = 6, max = 32)
    private String title;
    
    private int quantity;
    
    @OneToOne
    private Description description;

    public Book() {
    }

    /**
     *
     * @param isbn
     * @param title
     * @param quantity
     * @param description
     */
    public Book(String isbn, String title, int quantity, Description description) {
        this.isbn = isbn;
        this.title = title;
        this.quantity = quantity;
        this.description = description;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the description
     */
    public Description getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(Description description) {
        this.description = description;
    }
}
