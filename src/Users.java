import java.util.ArrayList;
import java.util.Scanner;

public class Users {
    private final ArrayList<Passenger> users = new ArrayList<>(10);

    public ArrayList<Passenger> getUsers() {
        return users;
    }

    /**
     * Searching an id form User ArrayList
     *
     * @param targetId the id we're looking for
     * @return The indexOf the targetId ( return -1 if it was not found )
     */
    public int findUserIndex(String targetId) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getPassengerID().equals(targetId)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Searching an id form User ArrayList with Password for signIn section
     *
     * @param targetId   the id we're looking for
     * @param targetPass the password we're looking for
     * @return The indexOf the targetId ( return -1 if it was not found )
     */
    public int findUserIndex(String targetId, String targetPass) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getPassengerID().equals(targetId)) {
                if (users.get(i).getPassword().equals(targetPass)) {
                    return i;
                }
                return -1;
            }
        }

        return -1;
    }

    /**
     * Booking Ticket Method
     *
     * @param flights   List all Flights
     * @param passenger the Passenger who wants to buy Ticket
     */
    public void bookingTicket(Flights flights, Passenger passenger) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please Enter Flight Id");
        String tempFlightId = scan.nextLine();

        Flight tempFlight;

        // Searching
        int FlightIndex = flights.findFlightIndex(tempFlightId);

        // return if it has Not found
        if (FlightIndex == -1) {
            System.out.println("please check your input");
            new Menu().pause();
            return;
        }

        tempFlight = flights.getFlights().get(FlightIndex);

        // return if the Passenger account has not enough charge
        if (passenger.getCharge() < tempFlight.getPrice()) {
            System.out.println("The price of flight is :" + tempFlight.getPrice());
            System.out.println("your balance :" + passenger.getCharge());
            System.out.println("please charge your account");
            new Menu().pause();
            return;
        }

        // return if the flight is full
        if (tempFlight.getBookedSeats() == tempFlight.getSeats()) {
            System.out.println("The flight is full please choose another flight");
            new Menu().pause();
            return;
        }

        // set ticket
        Ticket newTicket = new Ticket();
        newTicket.generateTicketId();
        newTicket.setFlightTicket(tempFlight);

        // add ticket to passenger
        passenger.getTickets().getTickets().add(newTicket);

        // add ticket to flight
        flights.getFlights().get(FlightIndex).setTicket();

        // pay cash
        passenger.setCharge(passenger.getCharge() - tempFlight.getPrice());

        // add one to booked seats
        tempFlight.setBookedSeats(tempFlight.getBookedSeats() + 1);

        // show massage
        System.out.println("the Flight Booked");
        new Menu().pause();

    }

    /**
     * Print booked Tickets
     *
     * @param passengerIndex the index of Passenger in All
     * @param flights        List of all Flights
     */
    public void printBookedTicket(int passengerIndex, Flights flights) {
        boolean flag = false;
        for (int i = 0; i < users.get(passengerIndex).getTickets().getTickets().size(); i++) {
            if (!flag) {
                flights.printFlightHeaderTickets();
            }
            flights.printFlight(users.get(passengerIndex).getTickets().getTickets().get(i).getFlightTicket(), users.get(passengerIndex).getTickets().getTickets().get(i).getTicketId());
            flag = true;
        }
        if (!flag) {
            System.out.println("nothing found");
        }
    }

    /**
     * Cancellation method
     *
     * @param passengerIndex the index of Passenger in All
     * @param flights        List of all Flights
     */
    public void cancellationTicket(int passengerIndex, Flights flights) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" \n");
        System.out.println("""
                      Please Enter the ticket Id Which flight do yo want to remove
                      
                <<The system deducts 10% of the flight money as a penalty from your account
                       and returns the rest of the flight money to your account>>""");
        // get TicketId
        int ticketID = scanner.nextInt();

        //Searching for TicketId form Passenger Ticket list
        int searchingIndexTicketFromPassengerTicketList = users.get(passengerIndex).getTickets().ticketIndex(ticketID);

        // Not found condition for Ticket id
        if (searchingIndexTicketFromPassengerTicketList == -1) {
            System.out.println("check your input");
            new Menu().pause();
            return;
        }

        // searching Flight Id
        String flightID = users.get(passengerIndex).getTickets().getTickets().get(searchingIndexTicketFromPassengerTicketList).getFlightTicket().getFlightID();

        // refund money
        int priceOfFlight = flights.getFlights().get(flights.findFlightIndex(flightID)).getPrice();

        users.get(passengerIndex).setCharge(users.get(passengerIndex).getCharge() + priceOfFlight * 9 / 10);

        // remove seat
        flights.getFlights().get(flights.findFlightIndex(flightID)).setBookedSeats(flights.getFlights().get(flights.findFlightIndex(flightID)).getBookedSeats() - 1);


        // remove ticket from flight List
//        users.get(passengerIndex).getPassengerFlights().findFlightIndexWithFlightIdAndTicketId(flightID, ticketID);

        // remove ticket from list Passenger
        users.get(passengerIndex).getTickets().removeTicket(ticketID);


        System.out.println("<Flight removed>");
        new Menu().pause();

    }

    /**
     * creat new User
     *
     * @param id       The ID of New User
     * @param password The Password Of New User
     */
    public void creatNewUser(String id, String password) {
        Passenger passenger = new Passenger();

        passenger.setPassengerID(id);
        passenger.setPassword(password);
        passenger.setPassengerFlights();
        passenger.setCharge(0);

        users.add(passenger);


    }

    /**
     * Change Password method
     *
     * @param passengerIndex the index of Passenger in All
     * @param newPass        the new password
     */
    public void changePassword(int passengerIndex, String newPass) {
        Passenger tempPassenger = users.get(passengerIndex);
        tempPassenger.setPassword(newPass);
        users.set(passengerIndex, tempPassenger);

    }

    /**
     * Charge Account method
     *
     * @param passengerIndex the index of Passenger in All
     */
    public void chargeAccount(int passengerIndex) {
        Scanner scan = new Scanner(System.in);
        Passenger tempPassenger = users.get(passengerIndex);
        System.out.println("Your Balance : " + tempPassenger.getCharge());

        System.out.println("enter how much do you want to charge your account ");
        int charge = scan.nextInt();

        tempPassenger.setCharge(tempPassenger.getCharge() + charge);

        users.set(passengerIndex, tempPassenger);
    }


}
