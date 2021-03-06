/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsos.kbse.bibo.boundary;

import de.hsos.kbse.bibo.controller.MemberController;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author rapgrewe
 */
@Named(value="loginModel")
@SessionScoped
public class LoginModel implements Serializable{
    
    //@Inject
    //private BestellungController ordercontroller;
    
    @Inject
    private MemberController kController;
    
    private String username;
    private String password;
    
    private boolean authorized = false;

    public LoginModel() {
    }
           
    public void login(){
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(kController.isLoggedIn(username) ){
            context.addMessage("error", new FacesMessage("Bereits eingeloggt"));
        }else if( kController.loginMember(username, password)){
            System.out.println("Jetzt einloggen mit " + username + " und " + password);
            context.getExternalContext().getSessionMap().put("username", username);
            authorized = true;
            /*if(ordercontroller.isOrderComplete()){
                return "orderSuccess";
            }else{
                return"order";
            }*/
        } else {
            FacesContext.getCurrentInstance().addMessage("error", new FacesMessage("Username und/oder Passwort sind falsch!"));
        }
    }

    public String authorized(){
        
        if(kController.getMember() != null && kController.getMember().getLogin() != null){
            authorized = kController.getMember().getLogin().isLoggedIn();
        }
        else 
            authorized = false;
        
        if(!authorized){
            FacesContext.getCurrentInstance().addMessage("auth-form", new FacesMessage("Bitte Einloggen"));
            return "home";
        }
        return "";
    }
    
    public String logout(){
        kController.logoutMember();
        authorized = false;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "home";
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
    
    /**
     *
     * @return
     */
    public boolean isAuthorized() {
        return authorized;
    }

    /**
     *
     * @param authorized
     */
    public void setAuthorized(boolean authorized) {
        this.authorized = authorized;
    }
    
    /**
     *
     * @return
     */
    public boolean isLoggedIn(){
        return kController.isLoggedIn();
    }
}
