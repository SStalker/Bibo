/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsos.kbse.bibo.boundary;

import de.hsos.kbse.bibo.controller.MemberRepository;
import de.hsos.kbse.bibo.entity.Address;
import de.hsos.kbse.bibo.entity.Login;
import de.hsos.kbse.bibo.entity.Member;
import de.hsos.kbse.bibo.entity.Profile;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityExistsException;
import javax.persistence.PersistenceException;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author rapgrewe
 */
@Named(value="registerModel")
@RequestScoped
public class RegisterModel implements Serializable{
 
    @Inject
    private MemberRepository mController;
    
    @Size(min = 3, max = 32)
    private String firstname;
    @Size(min = 3, max = 32)
    private String lastname;
    @Digits(integer = 5, fraction = 0)
    private int plz; 
    @Size(min = 3, max = 32)
    private String town; 
    @Size(min = 3, max = 32)
    private String street; 
    @Size(min = 1, max = 5)
    private String streetnumber; 
    @Size(min = 8, max = 32)
    private String password;
    @Size(min = 4, max = 32)
    private String username;
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
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
        System.out.println(password);
        Address addr = new Address(plz, town, street, streetnumber);
        Profile pro = new Profile(firstname, lastname, addr);
        Login log = new Login(password, username, email);
        Member newMember = new Member();
        newMember.setLogin(log);
        newMember.setProfile(pro);
        try{
            //finde Login
            if(mController.findLogins(log) == null){
                //füge mitglied hinzu
                mController.insert(newMember);
            }else{
                FacesContext.getCurrentInstance().addMessage("register-form",new FacesMessage("Email, oder Username existiert bereits"));
                return "";
            }
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage("register-form",new FacesMessage("Interner Fehler beim registrieren "));
            return "";
        }
        
        return "/index.html";
    }

}
