import java.util.ArrayList;
import java.util.Scanner;

public class Flights {
    private ArrayList<Flight> flights = new ArrayList<Flight>();

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
        System.out.printf("|%-11s|%-11s|%-13s|%-12s|%-11s|%-,11d|%-6d|\n"   ,passengerFlight.get(flightIndex).getFlightID()
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

    public void addFlight(){
        Scanner scan = new Scanner(System.in);
        Flight newFlight = new Flight();
        System.out.println("Enter Flight Id");
        newFlight.setFlightID(scan.nextLine());
        System.out.println("Enter The Origen");
        newFlight.setOrigen(scan.nextLine());
        System.out.println("enter the Destination");
        newFlight.setDestination(scan.nextLine());
        System.out.println("enter the date");
        newFlight.setDate(scan.nextLine());
        System.out.println("enter Time");
        newFlight.setTime(scan.nextLine());
        System.out.println("enter Price");
        newFlight.setPrice(scan.nextInt());
        System.out.println("enter number of seats");
        newFlight.setSeats(scan.nextInt());
        newFlight.setBookedSeats(0);


        flights.add(newFlight);
    }
}
