import java.util.ArrayList;
import java.util.Scanner;

public class Flights {
    private final ArrayList<Flight> flights = new ArrayList<>();

    /**
     * search Filter section
     *
     * @param flightsList All Flights
     */
    public void filterFlight(ArrayList<Flight> flightsList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Do you want to show you all Flights
                <1> Yes
                <2> No
                <0> return
                                
                -->
                """);
        int showAll = scanner.nextInt();
        switch (showAll) {
            case 1:
                printFlightHeader();
                printFlight(flights);
                break;
            case 2:
                System.out.println("Input Origen for Filter Flights by Origen ( Enter X for skip ) ");
                scanner.nextLine();
                String origen = scanner.nextLine();
                System.out.println("Input Destination for Filter Flights by Destination ( Enter X for skip ) ");
                String destination = scanner.nextLine();
                System.out.println("Input Date for Filter Flights by Date ( Enter X for skip ) ");
                String date = scanner.nextLine();
                System.out.println("Input Time for Filter Flights by Time ( Enter X for skip ) ");
                String time = scanner.nextLine();
                System.out.println("enter Y to Filter Flights by price");
                String price = scanner.nextLine();

                ArrayList<Flight> tempFlights = new ArrayList<>(flightsList);

                if (!origen.equals("X")) {
                    filterFlightsByOrigen(origen, tempFlights);
                }
                if (!destination.equals("X")) {
                    filterFlightsByDestination(destination, tempFlights);
                }
                if (!date.equals("X")) {
                    filterFlightsByDate(date, tempFlights);
                }
                if (!time.equals("X")) {
                    filterFlightsByTime(time, tempFlights);
                }
                if (price.equals("Y")) {
                    System.out.println("Input the maximum price");
                    int maxPrice = scanner.nextInt();
                    System.out.println("Input the minimum price ");
                    int minPrice = scanner.nextInt();
                    boolean flag = false;
                    for (int i = tempFlights.size() - 1; i >= 0; i--) {
                        if (tempFlights.get(i).getPrice() <= maxPrice) {
                            if (tempFlights.get(i).getPrice() >= minPrice) {
                                if (!flag) {
                                    flag = true;
                                    printFlightHeader();
                                }
                                printFlight(i, tempFlights);
                            }

                        }
                    }
                } else {
                    printFlightHeader();
                    printFlight(tempFlights);
                }


                break;
            case 0:
                return;
            default:
                this.filterFlight(flightsList);
        }


    }

    /**
     * print header for search filter section and admin Flight schedules section
     */
    public void printFlightHeader() {
        System.out.println("|FlightId   |Origin     |Destination  |Date        |Time       |Price      |Seats |Booked Seats|");
    }

    /**
     * print Flight booked with ticket IDs
     */
    public void printFlightHeaderTickets() {
        System.out.println("|FlightId   |Origin     |Destination  |Date        |Time       |Price      |Seats |Booked Seats|Ticket Id|");
    }

    /**
     * print all flight which passed the method
     *
     * @param passengerFlight the list which wanna to print
     */
    public void printFlight(ArrayList<Flight> passengerFlight) {
        for (int i = 0; i < passengerFlight.size(); i++) {
            printFlight(i, passengerFlight);
        }
        new Menu().pause();
    }

    /**
     * print a specific flight details
     *
     * @param flightIndex     the index of flight list
     * @param passengerFlight the passenger flight list
     */
    public void printFlight(int flightIndex, ArrayList<Flight> passengerFlight) {
        System.out.println("................................................................................................");
        System.out.printf("|%-11s|%-11s|%-13s|%-12s|%-11s|%-,11d|%-6d|%-12d|\n"
                , passengerFlight.get(flightIndex).getFlightID()
                , passengerFlight.get(flightIndex).getOrigen()
                , passengerFlight.get(flightIndex).getDestination()
                , passengerFlight.get(flightIndex).getDate()
                , passengerFlight.get(flightIndex).getTime()
                , passengerFlight.get(flightIndex).getPrice()
                , passengerFlight.get(flightIndex).getSeats()
                , passengerFlight.get(flightIndex).getBookedSeats());
    }

    /**
     * print flight details with ticket ID
     *
     * @param passengerFlight the passenger flight list
     * @param ticketId        the ticket ID of flight
     */
    public void printFlight(Flight passengerFlight, int ticketId) {
        System.out.println("..........................................................................................................");
        System.out.printf("|%-11s|%-11s|%-13s|%-12s|%-11s|%-,11d|%-6d|%-12d|%-9d|\n"
                , passengerFlight.getFlightID()
                , passengerFlight.getOrigen()
                , passengerFlight.getDestination()
                , passengerFlight.getDate()
                , passengerFlight.getTime()
                , passengerFlight.getPrice()
                , passengerFlight.getSeats()
                , passengerFlight.getBookedSeats()
                , ticketId);


    }

    /**
     * search Flight index by Flight ID
     *
     * @param targetFlightId the flight ID that you wants to find
     * @return the index the target ( return -1 if it was not found )
     */
    public int findFlightIndex(String targetFlightId) {
        for (int i = 0; i < flights.size(); i++) {
            if (flights.get(i).getFlightID().equals(targetFlightId)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * filter flights by origen
     *
     * @param targetFlightOrigen the target origen
     * @param filterFlights      the Flights list
     */
    public void filterFlightsByOrigen(String targetFlightOrigen, ArrayList<Flight> filterFlights) {


        for (int i = flights.size() - 1; i >= 0; i--) {
            if (!flights.get(i).getOrigen().equals(targetFlightOrigen)) {
                filterFlights.remove(i);
            }
        }
    }

    /**
     * filter flights by destination
     *
     * @param targetDestination the target destination
     * @param filterFlights     the Flights list
     */
    public void filterFlightsByDestination(String targetDestination, ArrayList<Flight> filterFlights) {
        for (int i = flights.size() - 1; i >= 0; i--) {
            if (!flights.get(i).getDestination().equals(targetDestination)) {
                filterFlights.remove(i);
            }
        }
    }

    /**
     * filter flights by date
     *
     * @param targetDate    the target date
     * @param filterFlights the Flights list
     */
    public void filterFlightsByDate(String targetDate, ArrayList<Flight> filterFlights) {
        for (int i = flights.size() - 1; i >= 0; i--) {
            if (!flights.get(i).getDate().equals(targetDate)) {
                filterFlights.remove(i);
            }
        }
    }

    /**
     * filter flights by time
     *
     * @param targetTime    the target time
     * @param filterFlights the Flights list
     */
    public void filterFlightsByTime(String targetTime, ArrayList<Flight> filterFlights) {
        for (int i = flights.size() - 1; i >= 0; i--) {
            if (!flights.get(i).getTime().equals(targetTime)) {
                filterFlights.remove(i);
            }
        }
    }


    // Administrator methods

    /**
     * Add flight to flight List
     */
    public void addFlight() {
        Scanner scan = new Scanner(System.in);
        Flight newFlight = new Flight();

        System.out.println("Enter Flight Id");
        newFlight.setFlightID(scan.nextLine());

        if (findFlightIndex(newFlight.getFlightID()) != -1) {
            System.out.println("This id has taken");
            return;
        }

        System.out.println("Enter The Origen");
        newFlight.setOrigen(scan.nextLine());

        System.out.println("Enter the Destination");
        newFlight.setDestination(scan.nextLine());

        System.out.println("Enter the date");
        newFlight.setDate(scan.nextLine());

        System.out.println("Enter Time");
        newFlight.setTime(scan.nextLine());

        System.out.println("Enter Price");
        newFlight.setPrice(scan.nextInt());

        System.out.println("Enter number of seats");
        newFlight.setSeats(scan.nextInt());

        newFlight.setBookedSeats(0);


        flights.add(newFlight);
    }

    /**
     * Update flight form flight list
     */
    public void updateFlight() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Please enter the Flight Id Which flight do yo want to update ");
        String flightId = scanner.nextLine();

        int flightIndex = findFlightIndex(flightId);

        if (flightIndex == -1) {
            System.out.println("Please check your entry ");
            new Menu().pause();
            return;
        }

        System.out.println("""
                which detail do you want to change
                <1> Flight Id
                <2> Origin
                <3> Distinction
                <4> Date
                <5> Time
                <6> Price
                <7> Seats
                <0> Exit
                                        
                -->""");

        int key = scanner.nextInt();
        Flight tempFlight = flights.get(flightIndex);

        switch (key) {
            case 1:
                System.out.println("Enter new Flight id");
                scanner.nextLine();
                String tempId = scanner.nextLine();
                tempFlight.setFlightID(tempId);
                flights.set(flightIndex, tempFlight);
                break;
            case 2:
                System.out.println("Enter new Origin");
                scanner.nextLine();
                String tempOrigin = scanner.nextLine();
                tempFlight.setOrigen(tempOrigin);
                flights.set(flightIndex, tempFlight);
                break;
            case 3:
                System.out.println("Enter new Distance");
                scanner.nextLine();
                String tempDistance = scanner.nextLine();
                tempFlight.setDestination(tempDistance);
                flights.set(flightIndex, tempFlight);
                break;
            case 4:
                System.out.println("Enter new Date");
                scanner.nextLine();
                String tempDate = scanner.nextLine();
                tempFlight.setDate(tempDate);
                flights.set(flightIndex, tempFlight);
                break;
            case 5:
                System.out.println("Enter new Time");
                scanner.nextLine();
                String tempTime = scanner.nextLine();
                tempFlight.setTime(tempTime);
                flights.set(flightIndex, tempFlight);
                break;
            case 6:
                System.out.println("Enter new Price");
                scanner.nextLine();
                int tempPrice = scanner.nextInt();
                tempFlight.setPrice(tempPrice);
                flights.set(flightIndex, tempFlight);
                break;
            case 7:
                System.out.println("Enter Seats");
                scanner.nextLine();
                int tempSeats = scanner.nextInt();
                tempFlight.setSeats(tempSeats);
                flights.set(flightIndex, tempFlight);
                break;
            case 0:
                return;
            default:
                System.out.println("check your Input");
                new Menu().pause();
                this.updateFlight();
                break;
        }

    }

    /**
     * remove a flight from a flight list
     */
    public void removeFlight() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Please enter the Flight Id Which flight do yo want to remove ");
        String flightId = scanner.nextLine();

        int flightIndex = findFlightIndex(flightId);

        if (flightIndex == -1) {
            System.out.println("Please check your entry ");
            new Menu().pause();
            return;
        }

        if (flights.get(flightIndex).getBookedSeats() != 0) {
            System.out.println("you cannot remove this flight because someone booked this flight");
            new Menu().pause();
            return;
        }
        flights.remove(flightIndex);

    }

    /* getter */
    public ArrayList<Flight> getFlights() {
        return flights;
    }

}
