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
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 *
 * @author sstalker
 */
@Entity
public class Address implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; 
    
    @Min(10000)
    @Digits(integer = 5, fraction = 0)
    private int plz; // 12345
    
    @Size(min = 3, max = 32)
    private String town; // Cookie
    
    @Size(min = 3, max = 32)
    private String street; // Keksstr

    @Size(min = 1, max = 5)
    private String streetnumber; // 4a
    
    public Address() {
    }

    public Address(int plz, String town, String street, String streetnumber) {
        this.plz = plz;
        this.town = town;
        this.street = street;
        this.streetnumber = streetnumber;
    }

    /**
     * @return the plz
     */
    public int getPlz() {
        return plz;
    }

    /**
     * @param plz the plz to set
     */
    public void setPlz(int plz) {
        this.plz = plz;
    }

    /**
     * @return the town
     */
    public String getTown() {
        return town;
    }

    /**
     * @param town the town to set
     */
    public void setTown(String town) {
        this.town = town;
    }

    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return the streetnumber
     */
    public String getStreetnumber() {
        return streetnumber;
    }

    /**
     * @param streetnumber the streetnumber to set
     */
    public void setStreetnumber(String streetnumber) {
        this.streetnumber = streetnumber;
    }    
}
