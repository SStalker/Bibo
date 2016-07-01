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
import javax.validation.constraints.Size;

/**
 *
 * @author sstalker
 */
@Entity
class Author implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    
    @Size(min = 3, max = 32)
    private String lastname;
    
    @Size(min = 3, max = 32)
    private String firstname;
    
    @Size(min = 1, max = 3)
    private String acronym;

    public Author() {
    }

    public Author(int id, String lastname, String firstname, String acronym) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.acronym = acronym;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the acronym
     */
    public String getAcronym() {
        return acronym;
    }

    /**
     * @param acronym the acronym to set
     */
    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }
}
