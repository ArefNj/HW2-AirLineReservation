import java.util.ArrayList;

public class Flights {
    private ArrayList<Flight> flights;

    public int searchFlight(int searchFilter,String filterParam){

        switch (searchFilter){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                break;
        }
        return -1;
    }

    public void printFlightHeader(){
        System.out.println("|FlightId   |Origin     |Destination  |Date        |Time       |Price      |Seats |");
    }

    public void printFlight(ArrayList<Flight> passengerFlight){
        for (int i = 0; i < passengerFlight.size(); i++) {
            printFlight(i,passengerFlight);
        }
    }

    public void printFlight(int flightIndex, ArrayList<Flight> passengerFlight){
        System.out.println("...................................................................................");
        System.out.printf("|%s11|%s11|%s11|%s11|%s11|%,d11|%d11|"   ,passengerFlight.get(flightIndex).getFlightID()
                                                                    ,passengerFlight.get(flightIndex).getOrigen()
                                                                    ,passengerFlight.get(flightIndex).getDestination()
                                                                    ,passengerFlight.get(flightIndex).getDate()
                                                                    ,passengerFlight.get(flightIndex).getTime()
                                                                    ,passengerFlight.get(flightIndex).getPrice()
                                                                    ,passengerFlight.get(flightIndex).getSeats());
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }
    public void setFlights(ArrayList<Flight> flights) {
        this.flights = flights;
    }
}
