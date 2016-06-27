/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsos.kbse.bibo.boundary;

import de.hsos.kbse.bibo.controller.MemberController;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author rapgrewe
 */
@Named(value="loginModel")
@RequestScoped
public class LoginModel implements Serializable{
    
    //@Inject
    //private BestellungController ordercontroller;
    
    @Inject
    private MemberController kController;
    
    private String username;
    private String password;

    public LoginModel() {
    }
           
    public String login(){
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(kController.isLoggedIn(username) ){
            context.addMessage("error", new FacesMessage("Bereits eingeloggt"));
            return "";
        }else if( kController.loginMember(username, password)){
            System.out.println("Jetzt einloggen mit " + username + " und " + password);
            context.getExternalContext().getSessionMap().put("username", username);
            /*if(ordercontroller.isOrderComplete()){
                return "orderSuccess";
            }else{
                return"order";
            }*/
        } else {
            FacesContext.getCurrentInstance().addMessage("error", new FacesMessage("Username und/oder Passwort sind falsch!"));
            return "";
        }
       return "";
    }

    public String logout(){
        kController.logoutMember();
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/order.xhtml?faces-redirect=true";
    }
    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }           
}
