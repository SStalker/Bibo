/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sstalker
 */
public class Mitglied extends Person {
    int ausweisNr;
    String email;
    String password;

    /**
     *
     * @param ausweisNr
     * @param email
     * @param password
     * @param firstname
     * @param lastname
     * @param adress
     */
    public Mitglied(int ausweisNr, String email, String password, String firstname, String lastname, Adress adress) {
        super(firstname, lastname, adress);
        this.ausweisNr = ausweisNr;
        this.email = email;
        this.password = password;
    }
    
    
}
