import java.util.ArrayList;
import java.util.Scanner;

public class Users {
    private ArrayList<Passenger> users = new ArrayList<>(10);

    public ArrayList<Passenger> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<Passenger> users) {
        this.users = users;
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
//    /**
//     * Booking section for Booking Flights
//     *
//     * @param passengerIndex Which Passenger buy Ticket
//     * @param flights        all flights
//     */
//    public void booking(int passengerIndex, Flights flights) {
//        Scanner scan = new Scanner(System.in);
//
//        System.out.println("Please Enter Flight Id");
//        String tempFlightId = scan.nextLine();
//
//        Flight tempFlight;
//        ArrayList<Flight> tempFlightList;
//
//        // Searching
//        int tempFlightIndex = flights.findFlightIndex(tempFlightId);
//
//        // return if it has Not found
//        if (tempFlightIndex == -1) {
//            System.out.println("please check your input");
//            new Menu().pause();
//            return;
//        }
//
//        tempFlight = flights.getFlights().get(tempFlightIndex);
//        tempFlightList = users.get(passengerIndex).getPassengerFlights();
//
//        // return if the Passenger account has not enough charge
//        if (users.get(passengerIndex).getCharge() < tempFlight.getPrice()) {
//            System.out.println("The price of flight is :" + tempFlight.getPrice());
//            System.out.println("your balance :" + users.get(passengerIndex).getCharge());
//            System.out.println("please charge your account");
//            new Menu().pause();
//            return;
//        }
//
//
//        // return if the flight is full
//        if (tempFlight.getBookedSeats() == tempFlight.getSeats()) {
//            System.out.println("The flight is full please choose another flight");
//            new Menu().pause();
//            return;
//        }
//
//        // Booking
//        users.get(passengerIndex).setCharge(users.get(passengerIndex).getCharge() - tempFlight.getPrice());
//        tempFlight.setBookedSeats(tempFlight.getBookedSeats() + 1);
//
//
//        tempFlightList.add(tempFlight);
//        users.get(passengerIndex).setPassengerFlights(tempFlightList);
//
//        System.out.println("the Flight Booked");
//        new Menu().pause();
//
//    }

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
        flights.getFlights().get(FlightIndex).setTicket(newTicket);

        // pay cash
        passenger.setCharge(passenger.getCharge() - tempFlight.getPrice());

        // add one to booked seats
        tempFlight.setBookedSeats(tempFlight.getBookedSeats() + 1);

        // show massage
        System.out.println("the Flight Booked");
        new Menu().pause();

    }

    //    public void printBookedList(int passengerIndex, Flights flights) {
//        boolean flag = false;
//        for (int i = 0; i < users.get(passengerIndex).getPassengerFlights().size(); i++) {
//            if (!flag) {
//                flights.printFlightHeader();
//            }
//            flights.printFlight(i, users.get(passengerIndex).getPassengerFlights());
//            flag = true;
//        }
//        if (!flag) {
//            System.out.println("nothing found");
//        }
//    }

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

//    public void removeFromBookedList(int passengerIndex, Flights flights) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println(" Please enter the Flight Id Which flight do yo want to remove ");
//        System.out.println("The system deducts 10% of the flight money as a penalty from your account\n" +
//                " and returns the rest of the flight money to your account");
//        String flightId = scanner.nextLine();
//        System.out.println(" Please enter the Flight Id Which flight do yo want to remove ");
//        int ticketId = scanner.nextInt();
//
//        //Searching
//        int searchingIndexForAllFlights = flights.findFlightIndex(flightId, ticketId);
//
//        // Not found condition
//        if (searchingIndexForAllFlights == -1) {
//            System.out.println("check your input");
//            new Menu().pause();
//            return;
//        }
//
//
//
//        // get instance from Flights and the target Flight
//        ArrayList<Flight> tempFlights = new ArrayList<>(users.get(passengerIndex).getPassengerFlights().getFlights());
//        Flight tempFlight = tempFlights.get(searchingIndexForAllFlights);
//
//
//        int searchingIndexForPassengerFlights = tempFlights.indexOf(tempFlight);
//
//        if (searchingIndexForPassengerFlights == -1) {
//            System.out.println("the flight has not booked to remove");
//            new Menu().pause();
//            return;
//        }
//
//
//        tempFlights.get(searchingIndexForPassengerFlights).setBookedSeats(tempFlight.getBookedSeats() - 1);
//
//        users.get(passengerIndex).setCharge(users.get(passengerIndex).getCharge() + (tempFlight.getPrice() * 9 / 10));
//
//        tempFlights.remove(searchingIndexForAllFlights);
//
//        users.get(passengerIndex).setPassengerFlights(tempFlights);
//
//        System.out.println("<Flight removed>");
//        new Menu().pause();
//
//    }

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
        users.get(passengerIndex).getPassengerFlights().findFlightIndexWithFlightIdAndTicketId(flightID, ticketID);

        // remove ticket from list Passenger
        users.get(passengerIndex).getTickets().removeTicket(ticketID);






        System.out.println("<Flight removed>");
        new Menu().pause();

    }


//    public void removeFromBookedList(int passengerIndex, Flights flights) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please Enter the ticket Id Which flight do yo want to remove ");
//        System.out.println("<<The system deducts 10% of the flight money as a penalty from your account\n" +
//                "and returns the rest of the flight money to your account>>");
//        int ticketId = scanner.nextInt();
//
//        //Searching
//        int searchingIndexTicket = users.get(passengerIndex).getTickets().ticketIndex(ticketId);
//        // Not found condition
//        if (searchingIndexTicket == -1) {
//            System.out.println("check your input");
//            new Menu().pause();
//            return;
//        }
//
//
//        //Searching
//        int searchingIndexForAllFlights = flights.findFlightIndex(flightId);
//
//        // Not found condition
//        if (searchingIndexForAllFlights == -1) {
//            System.out.println("check your input");
//            new Menu().pause();
//            return;
//        }
//
//        ArrayList<Flight> tempFlights;
//        tempFlights = users.get(passengerIndex).getPassengerFlights();
//        Flight tempFlight = tempFlights.get(searchingIndexForAllFlights);
//        int searchingIndexForPassengerFlights = tempFlights.indexOf(tempFlight);
//        if (searchingIndexForPassengerFlights == -1) {
//            System.out.println("the flight has not booked to remove");
//            new Menu().pause();
//            return;
//        }
//
//
//        tempFlights.get(searchingIndexForPassengerFlights).setBookedSeats(tempFlight.getBookedSeats() - 1);
//
//        users.get(passengerIndex).setCharge(users.get(passengerIndex).getCharge() + (tempFlight.getPrice() * 9 / 10));
//
//        tempFlights.remove(searchingIndexForAllFlights);
//
//        users.get(passengerIndex).setPassengerFlights(tempFlights);
//
//        System.out.println("<Flight removed>");
//        new Menu().pause();
//
//    }

    public void creatNewUser(String id, String password) {
        Passenger passenger = new Passenger();

        passenger.setPassengerID(id);
        passenger.setPassword(password);
        Flights passengerFlight = new Flights();
        passenger.setPassengerFlights(passengerFlight);
        passenger.setCharge(0);

        users.add(passenger);


    }

    public void changePassword(int index, String newPass) {
        Passenger tempPassenger = users.get(index);
        tempPassenger.setPassword(newPass);
        users.set(index, tempPassenger);

    }

    public void chargeAccount(int index) {
        Scanner scan = new Scanner(System.in);
        Passenger tempPassenger = users.get(index);
        System.out.println("Your Balance : " + tempPassenger.getCharge());

        System.out.println("enter how much do you want to charge your account ");
        int charge = scan.nextInt();

        tempPassenger.setCharge(tempPassenger.getCharge() + charge);

        users.set(index, tempPassenger);
    }


}
