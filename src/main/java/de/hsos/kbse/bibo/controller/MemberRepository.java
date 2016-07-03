/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsos.kbse.bibo.controller;

import de.hsos.kbse.bibo.entity.Login;
import de.hsos.kbse.bibo.entity.Member;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 *
 * @author Lukas Hannigbrinck <lukas.hannigbrinck@hs-osnabrueck.de>
 */
@Named
@ApplicationScoped
@Transactional(Transactional.TxType.REQUIRED)
public class MemberRepository implements Serializable{
    
    @PersistenceContext(unitName = "bibo", type=PersistenceContextType.TRANSACTION)
    EntityManager em;
    
    public void insert(Member user) {
            em.persist(user);
    }
    
    public void update(Member kunde){
        em.merge(kunde);
    }
    
    public Member findById(int uid){
        return em.find(Member.class, uid);        
    }
    
    public Member findByName(String name){
        
        List<Member> results;
        results = em.createQuery("SELECT m FROM Member m WHERE m.login.username LIKE :username").setParameter("username", name).getResultList();
        
        if(results.isEmpty())
            return null;
        else if (results.size() > 1)
            throw new IllegalStateException("Cannot have more than one user with the same username!");
                
        return results.get(0);
    }
    
    /*public Bestellung getAktuelleBestellung(String name){
        Query query = em.createNamedQuery("Member.aktulleBestellung");
        query.setParameter("username", name);
        List<Bestellung> results = query.getResultList();
        
        if(results.isEmpty())
            return null;
        else if (results.size() > 1)
            throw new IllegalStateException("Cannot have more than one Bestellung at the same time!");
                
        return results.get(0);
    }*/
    
    public List<Login> findLogins(Login login){
        List<Login> result = em.createQuery("SELECT l FROM Login l WHERE l.username LIKE :name OR l.email LIKE :mail").setParameter("name", login.getUsername()).setParameter("mail", login.getEmail()).getResultList();
        
        if(result.isEmpty()){
            return null;
        }else{
            return result;
        }
    } 
    
    public void delete(int uid){
        Member user = findById(uid);
        
        if( user != null)
            em.remove(user);
    } 
}
