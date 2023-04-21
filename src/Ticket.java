import java.util.Random;

public class Ticket {
    private int ticketId;
    private Flight flightTicket;
    private Passenger passengerTicket;

    private boolean ticketIdSet = false;


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

    public Passenger getPassengerTicket() {
        return passengerTicket;
    }

    public void setPassengerTicket(Passenger passengerTicket) {
        this.passengerTicket = passengerTicket;
    }

    public void generateTicketId() {
        Random random = new Random();
        if (!ticketIdSet) {
            ticketId = random.nextInt(100);
            ticketIdSet = true;
        }
    }


}
