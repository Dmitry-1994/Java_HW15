package ru.netology.ticket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketRepositoryTest {
    TicketRepository repository = new TicketRepository();

    Ticket ticket_1 = new Ticket(111, 10_000, "SVX", "DME", 120);
    Ticket ticket_2 = new Ticket(222, 25_000, "SVX", "ARH", 240);
    Ticket ticket_3 = new Ticket(333, 4_000, "SVX", "DME", 180);
    Ticket ticket_4 = new Ticket(444, 7_000, "SVX", "DME", 115);
    Ticket ticket_5 = new Ticket(555, 9_000, "SVX", "DME", 130);
    Ticket ticket_6 = new Ticket(666, 60_000, "HKT", "DME", 480);

    @Test
    public void saveNull() {
        Ticket[] expected = {};
        Ticket[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void saveOne() {
        repository.add(ticket_5);

        Ticket[] expected = {ticket_5};
        Ticket[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void saveMore() {
        repository.add(ticket_1);
        repository.add(ticket_2);
        repository.add(ticket_3);
        repository.add(ticket_4);
        repository.add(ticket_5);

        Ticket[] expected = {ticket_1, ticket_2, ticket_3, ticket_4, ticket_5};
        Ticket[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void saveByIdNegative() {
        repository.add(ticket_1);
        repository.add(ticket_2);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repository.add(ticket_2);
        });
    }

    @Test
    public void removeByIdOne() {
        repository.add(ticket_1);
        repository.add(ticket_2);
        repository.add(ticket_3);
        repository.add(ticket_4);
        repository.add(ticket_5);
        repository.add(ticket_6);

        repository.removeById(444);

        Ticket[] expected = {ticket_1, ticket_2, ticket_3, ticket_5, ticket_6};
        Ticket[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdNegative() {
        repository.add(ticket_1);
        repository.add(ticket_2);
        repository.add(ticket_3);
        repository.add(ticket_4);
        repository.add(ticket_5);
        repository.add(ticket_6);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.removeById(-1000);
        });

    }

    @Test
    public void removeByIdFew() {
        repository.add(ticket_1);
        repository.add(ticket_2);
        repository.add(ticket_3);
        repository.add(ticket_4);
        repository.add(ticket_5);
        repository.add(ticket_6);

        repository.removeById(111);
        repository.removeById(333);
        repository.removeById(555);

        Ticket[] expected = {ticket_2, ticket_4, ticket_6};
        Ticket[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdAll() {
        repository.add(ticket_1);
        repository.add(ticket_2);
        repository.add(ticket_3);
        repository.add(ticket_4);
        repository.add(ticket_5);
        repository.add(ticket_6);

        repository.removeById(111);
        repository.removeById(222);
        repository.removeById(333);
        repository.removeById(444);
        repository.removeById(555);
        repository.removeById(666);

        Ticket[] expected = {};
        Ticket[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findByIdNegative() {
        repository.add(ticket_1);
        repository.add(ticket_2);
        repository.add(ticket_3);
        repository.add(ticket_4);
        repository.add(ticket_5);
        repository.add(ticket_6);

        Ticket expected = null;
        Ticket actual = repository.findById(777);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findByIdPositive() {
        repository.add(ticket_1);
        repository.add(ticket_2);
        repository.add(ticket_3);
        repository.add(ticket_4);
        repository.add(ticket_5);
        repository.add(ticket_6);

        Ticket expected = ticket_4;
        Ticket actual = repository.findById(444);
        Assertions.assertEquals(expected, actual);
    }
}
