/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sstalker
 */
public class Person {
    private String firstname;
    private String lastname;
    private Adress adress;

    public Person() {
    }

    /**
     *
     * @param firstname
     * @param lastname
     * @param adress
     */
    public Person(String firstname, String lastname, Adress adress) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.adress = adress;
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
     * @return the adress
     */
    public Adress getAdress() {
        return adress;
    }

    /**
     * @param adress the adress to set
     */
    public void setAdress(Adress adress) {
        this.adress = adress;
    }
    
    
}
