/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsos.kbse.bibo.controller;

import de.hsos.kbse.bibo.entity.Member;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.executable.ValidateOnExecution;

/**
 *
 * @author sstalker
 */
@SessionScoped
public class MemberController implements Serializable{
    
    @Inject 
    private MemberRepository repo;
    
    private Member aktuell = null;
    
    @Transactional(value = Transactional.TxType.REQUIRES_NEW,
            rollbackOn = {ValidateOnExecution.class, SQLException.class})
    public void registriereMember(Member kunde){
        repo.insert(kunde);
    }
    
    @Transactional(value = Transactional.TxType.REQUIRES_NEW,
            rollbackOn = {ValidateOnExecution.class, SQLException.class})
    public boolean loginMember(String username, String pass){
        aktuell = repo.findByName(username);    
        if(aktuell != null && aktuell.getLogin().getPassword().equals(pass)){    
            aktuell.getLogin().setLoggedIn(true);
            return true;
        }else{
            return false;
        }
    }
    @Transactional(value = Transactional.TxType.REQUIRES_NEW,
            rollbackOn = {ValidateOnExecution.class, SQLException.class})
    public boolean isLoggedIn(String username){
        Member aktuell = repo.findByName(username);
        
        return aktuell != null && aktuell.getLogin().isLoggedIn();
    }
    
    @Transactional(value = Transactional.TxType.REQUIRES_NEW,
            rollbackOn = {ValidateOnExecution.class, SQLException.class})
    public boolean isLoggedIn(){
        Map<String, Object> map = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        if(!map.containsKey("username"))
            return false;
        
        String username = (String) map.get("username");
        Member aktuell = repo.findByName(username);
        
        return aktuell != null && aktuell.getLogin().isLoggedIn();
    }
    
    @Transactional(value = Transactional.TxType.REQUIRES_NEW,
        rollbackOn = {ValidateOnExecution.class, SQLException.class})
    public Member getMember(){
//        Map<String, Object> map = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
//        
//        if(!map.containsKey("username"))
//            return null;
//        
//        Member k = repo.findByName((String)map.get("username"));
//        
//        if(k != null)
//            System.out.println("Member: " + k.getLogin().getUsername() + " Bestellungen: " + k.getBestellungen().size());
//        
//        return k;
        return aktuell;
    }
    
    /*@Transactional(value = Transactional.TxType.REQUIRES_NEW,
    rollbackOn = {ValidateOnExecution.class, SQLException.class})
    public Bestellung getAktuelleBestellung(){
        Map<String, Object> map = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        
        if(!map.containsKey("username"))
            return null;
        
        return repo.getAktuelleBestellung((String)map.get("username"));
    }*/
    @Transactional(value = Transactional.TxType.REQUIRES_NEW,
        rollbackOn = {ValidateOnExecution.class, SQLException.class})
    public void logoutMember() {
        if(aktuell != null){    
            aktuell.getLogin().setLoggedIn(false);
            repo.update(aktuell);
        }
        
        aktuell = null;
    }
    
    @Transactional(value = Transactional.TxType.REQUIRES_NEW,
            rollbackOn = {ValidateOnExecution.class, SQLException.class})
    public void updateAktuell(){
        
        //System.out.println("aktuell: " + aktuell.getBestellungen().size());
        aktuell = repo.findByName(aktuell.getLogin().getUsername());
        //System.out.println("Updated aktuell: " + aktuell.getBestellungen().size());
    }
    
    @Transactional(value = Transactional.TxType.REQUIRES_NEW,
            rollbackOn = {ValidateOnExecution.class, SQLException.class})
    public void update(){
        repo.update(aktuell);
    }
    
    public boolean authorized(){
        if(aktuell != null){
            return false;
        }
        else return true;
    }
}
