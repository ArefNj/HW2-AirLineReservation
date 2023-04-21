import java.util.ArrayList;

public class Passenger {

    private String passengerID;
    private String Password;
    private Flights passengerFlights = new Flights();
    private int charge;
    private Tickets tickets = new Tickets();


    public String getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(String passengerID) {
        this.passengerID = passengerID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Flights getPassengerFlights() {
        return passengerFlights;
    }

    public void setPassengerFlights(Flights passengerFlights) {
        this.passengerFlights = passengerFlights;
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    public Tickets getTickets() {
        return tickets;
    }

    public void setTickets(Tickets tickets) {
        this.tickets = tickets;
    }
}
