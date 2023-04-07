package ru.netology.ticket;

public class Ticket {
    private int id;
    private int price;
    private String airportOut;
    private String airportIn;
    private int flightTime;

    public Ticket(int id, int price, String airportOut, String airportIn, int flightTime) {
        this.id = id;
        this.price = price;
        this.airportOut = airportOut;
        this.airportIn = airportIn;
        this.flightTime = flightTime;
    }

    public int getId() {
        return id;
    }

    public int getFlightTime() {
        return flightTime;
    }

    public String getAirportOut() {
        return airportOut;
    }

    public String getAirportIn() {
        return airportIn;
    }
}
