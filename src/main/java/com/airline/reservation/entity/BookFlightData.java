package com.airline.reservation.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookFlightData {
    @JsonProperty("bookFlightData")
    private BookingDetails bookFlightData;

    public BookingDetails getBookFlightData() {
        return bookFlightData;
    }

    public void setBookFlightData(BookingDetails bookFlightData) {
        this.bookFlightData = bookFlightData;
    }

}
