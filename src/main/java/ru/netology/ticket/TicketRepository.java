package ru.netology.ticket;

public class TicketRepository {
    private Ticket[] tickets = new Ticket[0];
    public void add(Ticket ticket) {
        if (findById(ticket.getId()) != null) {
            throw new AlreadyExistsException(
                    "Товар с данным ID уже существует: " + ticket.getId()
            );
        }
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

    public Ticket[] findAll() {
        return tickets;
    }
    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException(
                    "Товар с даным ID не найден: " + id
            );
        }
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int copyIndex = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[copyIndex] = ticket;
                copyIndex++;
            }
        }
        tickets = tmp;
    }

    public Ticket findById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }
}
