/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsos.kbse.bibo.boundary;

import de.hsos.kbse.bibo.controller.MemberRepository;
import de.hsos.kbse.bibo.entity.Member;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author rapgrewe
 */
@Named(value="registerModel")
@RequestScoped
public class RegisterModel implements Serializable{
    
    //@Inject
    //private BestellungController ordercontroller;
    
    @Inject
    private MemberRepository kController;
    
    @Size(min = 3, max = 32)
    private String firstname;
    @Size(min = 3, max = 32)
    private String lastname;
    @Size(min=5, max=5)
    private int plz; // 12345
    @Size(min = 3, max = 32)
    private String town; // Cookie
    @Size(min = 3, max = 32)
    private String street; // Keksstr
    @Size(min = 3, max = 8)
    private String streetnumber; // 4a    
    @Size(min = 8, max = 32)
    private String password;
    @Size(min = 8, max = 32)
    private String username;
    @Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$")
    private String email;
    
    public RegisterModel() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getPlz() {
        return plz;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetnumber() {
        return streetnumber;
    }

    public void setStreetnumber(String streetnumber) {
        this.streetnumber = streetnumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String registerMember(){
        return "";
    }

}
