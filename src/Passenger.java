import java.util.ArrayList;

public class Passenger {

    private String passengerID;
    private String Password;
    private ArrayList<Flight> passengerFlights = new ArrayList<>();
    private int charge;
    private Tickets tickets;


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

    public ArrayList<Flight> getPassengerFlights() {
        return passengerFlights;
    }

    public void setPassengerFlights(ArrayList<Flight> passengerFlights) {
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
