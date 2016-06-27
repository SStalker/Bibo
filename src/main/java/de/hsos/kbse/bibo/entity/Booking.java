/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsos.kbse.bibo.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author sstalker
 */
@Entity
public class Booking implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private Date bookingFrom;
    private Date bookingTo;
    
    @OneToOne
    private Member member;

    public Booking() {
    }

    public Booking(int id, Date bookingFrom, Date bookingTo, Member member) {
        this.id = id;
        this.bookingFrom = bookingFrom;
        this.bookingTo = bookingTo;
        this.member = member;
    }

    /**
     * @return the bookingFrom
     */
    public Date getBookingFrom() {
        return bookingFrom;
    }

    /**
     * @param bookingFrom the from to set
     */
    public void setBookingFrom(Date bookingFrom) {
        this.bookingFrom = bookingFrom;
    }

    /**
     * @return the bookingTo
     */
    public Date getBookingTo() {
        return bookingTo;
    }

    /**
     * @param bookingTo the to to set
     */
    public void setBookingTo(Date bookingTo) {
        this.bookingTo = bookingTo;
    }

    /**
     * @return the member
     */
    public Member getMember() {
        return member;
    }

    /**
     * @param member the member to set
     */
    public void setMember(Member member) {
        this.member = member;
    }
}
