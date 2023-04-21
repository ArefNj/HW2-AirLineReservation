import java.util.Random;

public class Ticket {
    private int ticketId;
    private Flight flightTicket = new Flight();
    private boolean ticketIdSet = false;

    // setter and getter
    public int getTicketId() {
        return ticketId;
    }
    public void setTicketId(int ticketId) {
        ticketId = ticketId;
    }
    public Flight getFlightTicket() {
        return flightTicket;
    }
    public void setFlightTicket(Flight flightTicket) {
        this.flightTicket = flightTicket;
    }

    /**
     * Generate Ticket id
     */
    public void generateTicketId() {
        Random random = new Random();
        if (!ticketIdSet) {
            ticketId = random.nextInt(100);
            ticketIdSet = true;
        }
    }


}
