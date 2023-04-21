import java.util.ArrayList;

public class Tickets {
    private final ArrayList<Ticket> tickets = new ArrayList<>();

    /**
     * searching for index of ticketId in ticketList
     *
     * @param ticketId the target ticket ID
     * @return index of ticket in a ticketList
     */
    public int ticketIndex(int ticketId) {
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getTicketId() == ticketId) {
                return i;
            }
        }
        return -1;
    }

    /**
     * remove a ticket from a TicketList
     * Using thicketIndex to find the index of ticket
     *
     * @param ticketId the target ticket ID
     */
    public void removeTicket(int ticketId) {
        int indexOfTicketInTicketList = ticketIndex(ticketId);
        if (indexOfTicketInTicketList != -1) {
            tickets.remove(indexOfTicketInTicketList);
        } else {
            System.out.println("ticket Not Found");
        }
    }

    /** Setter & Getter */
    public ArrayList<Ticket> getTickets() {
        return tickets;
    }


}
