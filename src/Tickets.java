import java.util.ArrayList;

public class Tickets {
    private ArrayList<Ticket> tickets = new ArrayList<>();

    public void removeTicket(int ticketId){
        for (int i = tickets.size() - 1; i >= 0 ; i--) {
            if (tickets.get(i).getTicketId() == ticketId){
                tickets.remove(i);
            }
        }
    }

}
