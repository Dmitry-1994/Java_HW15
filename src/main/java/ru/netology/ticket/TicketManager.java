package ru.netology.ticket;

public class TicketManager {
    private TicketRepository repository;
    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public Ticket[] searchByAirport(String airportOut, String airportIn) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()){
            if ((ticket.getAirportOut() == airportOut) && (ticket.getAirportIn() == airportIn)){
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++){
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        return searchByAirportSortTwo(result);
    }
    public Ticket[] searchByAirportSort1(Ticket[] result) {
        Ticket[] resultSort = new Ticket[result.length];
        for (int i = 0; i < result.length; i++) {
            for (int k = i + 1; k < result.length; k++) {
                if (result[i].compareTo(result[k]) == -1) {

                }
            }
        }
    }
    public Ticket[] searchByAirportSortTwo(Ticket[] result) {
        Ticket[] resultSort = new Ticket[result.length];
        if (result[0].compareTo(result[1]) == 1) {
            resultSort[0] = result[1];
            resultSort[1] = result[0];
        } else {
            resultSort = result;
        }
        return resultSort;
    }
}
