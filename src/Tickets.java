import java.util.ArrayList;

public class Tickets {
    private ArrayList<Ticket> tickets = new ArrayList<>();

    public void removeTicket(int ticketId) {
        for (int i = tickets.size() - 1; i >= 0; i--) {
            if (tickets.get(i).getTicketId() == ticketId) {
                tickets.remove(i);
            }
        }
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public int ticketIndex(int ticketId) {
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getTicketId() == ticketId) {
                return i;
            }
        }
        return -1;
    }


}
