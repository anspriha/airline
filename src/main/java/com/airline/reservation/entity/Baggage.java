package com.airline.reservation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="baggage")
public class Baggage {

    @Id
    @GeneratedValue

    private long baggageID;
    private long  bookingID;
    private double weight ;
    private double additionalCost ;

    public Baggage(long baggageID, int bookingID, float weight, float additionalCost) {
        this.baggageID = baggageID;
        this.bookingID = bookingID;
        this.weight = weight;
        this.additionalCost = additionalCost;
    }

    public long getBaggageID() {
        return baggageID;
    }

    public void setBaggageID(long baggageID) {
        this.baggageID = baggageID;
    }

    public long getBookingID() {
        return bookingID;
    }

    public void setBookingID(long bookingID) {
        this.bookingID = bookingID;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getAdditionalCost() {
        return additionalCost;
    }

    public void setAdditionalCost(double additionalCost) {
        this.additionalCost = additionalCost;
    }

}
