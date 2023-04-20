public class Ticket {
    private int TicketId;
    private Flight flightTicket;
    private Passenger passengerTicket;


    public int getTicketId() {
        return TicketId;
    }

    public void setTicketId(int ticketId) {
        TicketId = ticketId;
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





}
