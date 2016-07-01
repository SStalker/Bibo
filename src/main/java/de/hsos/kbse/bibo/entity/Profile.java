/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsos.kbse.bibo.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

/**
 *
 * @author sstalker
 */
@Entity
public class Profile implements Serializable{

    @OneToOne(mappedBy = "profile")
    private Member member_profile;
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    
    @Size(min = 3, max = 32)
    private String firstname;
    
    @Size(min = 3, max = 32)
    private String lastname;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public Profile() {
    }

    public Profile(String firstname, String lastname, Address address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
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
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(Address address) {
        this.address = address;
    }
}
