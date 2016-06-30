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
import javax.persistence.Table;

/**
 *
 * @author sstalker
 */
@Entity
@Table(name = "t_member")
public class Member implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    private Profile profile;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Login login;
    
    public Member() {
    }   

    public Member(int id, Profile profile, Login login) {
        this.id = id;
        this.profile = profile;
        this.login = login;
    }

    public Login getLogin() {
        return login;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
