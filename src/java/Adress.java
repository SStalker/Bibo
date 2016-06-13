/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sstalker
 */
class Adress {
    private int plz;
    private String town;
    private String street;
    private int streetnumber;

    public Adress() {
    }
    
    public Adress(int plz, String town, String street, int streetnumber) {
        this.plz = plz;
        this.town = town;
        this.street = street;
        this.streetnumber = streetnumber;
    }

    /**
     * @return the plz
     */
    public int getPlz() {
        return plz;
    }

    /**
     * @param plz the plz to set
     */
    public void setPlz(int plz) {
        this.plz = plz;
    }

    /**
     * @return the town
     */
    public String getTown() {
        return town;
    }

    /**
     * @param town the town to set
     */
    public void setTown(String town) {
        this.town = town;
    }

    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return the streetnumber
     */
    public int getStreetnumber() {
        return streetnumber;
    }

    /**
     * @param streetnumber the streetnumber to set
     */
    public void setStreetnumber(int streetnumber) {
        this.streetnumber = streetnumber;
    }
    
    
}
