package ru.netology.ticket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketManagerTest {
    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);

    Ticket ticket_1 = new Ticket(111, 10_000, "SVX", "DME", 120);
    Ticket ticket_2 = new Ticket(222, 25_000, "SVX", "ARH", 240);
    Ticket ticket_3 = new Ticket(333, 4_000, "SVX", "DME", 180);
    Ticket ticket_4 = new Ticket(444, 7_000, "SVX", "DME", 115);
    Ticket ticket_5 = new Ticket(555, 9_000, "SVX", "DME", 130);
    Ticket ticket_6 = new Ticket(666, 60_000, "SVX", "HKT", 480);
    Ticket ticket_7 = new Ticket(777, 30_000, "SVX", "DME", 90);
    Ticket ticket_8 = new Ticket(888, 15_000, "SVX", "DME", 100);

    @Test
    public void searchByAirport() {
        repository.add(ticket_1);
        repository.add(ticket_2);
        repository.add(ticket_3);
        repository.add(ticket_4);
        repository.add(ticket_5);
        repository.add(ticket_6);
        repository.add(ticket_7);
        repository.add(ticket_8);

        Ticket[] expected = {ticket_3, ticket_4, ticket_5, ticket_1, ticket_8, ticket_7};
        Ticket[] actual = manager.searchByAirport("SVX","DME");
        Assertions.assertArrayEquals(expected, actual);
    }
}
