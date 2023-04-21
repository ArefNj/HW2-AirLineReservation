import java.util.Random;

public class Ticket {
    private int ticketId;
    private Flight flightTicket = new Flight();
    private boolean ticketIdSet = false;

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

    /** Setter & Getters */

    public int getTicketId() {
        return ticketId;
    }

    public Flight getFlightTicket() {
        return flightTicket;
    }

    public void setFlightTicket(Flight flightTicket) {
        this.flightTicket = flightTicket;
    }

}
