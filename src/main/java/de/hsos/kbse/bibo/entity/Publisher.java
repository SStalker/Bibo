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
class Publisher implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    
    @Size(min = 3, max = 32)
    private String name;

    public Publisher() {
    }

    public Publisher(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
