package ru.netology.ticket;

import java.util.Arrays;
import java.util.Comparator;

public class TicketManager {
    TicketTimeComparator timeComparator = new TicketTimeComparator();
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public Ticket[] searchByAirportPrice(String airportOut, String airportIn) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if ((ticket.getAirportOut().equals(airportOut)) && (ticket.getAirportIn().equals(airportIn))) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if ((ticket.getAirportOut().equals(from)) && (ticket.getAirportIn().equals(to))) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result, timeComparator);
        return result;
    }

}
