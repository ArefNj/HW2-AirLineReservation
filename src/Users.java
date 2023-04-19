import java.util.ArrayList;
import java.util.Scanner;

public class Users {
    private ArrayList<Passenger> users = new ArrayList<Passenger>(10);

    // Search
    public boolean searchUser(String targetId) {
        for (Passenger user : users) {
            if (user.getPassengerID().equals(targetId)) {
                return true;
            }
        }

        return false;
    }

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

    public void booking(int passengerIndex, Flights flights) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please Enter Flight Id");
        String tempFlightId = scan.nextLine();

        Flight tempFlight;
        ArrayList<Flight> tempFlightList;

        // Searching
        int tempFlightIndex = flights.findFlightIndex(tempFlightId);

        // return if it has Not found
        if (tempFlightIndex == -1) {
            System.out.println("please check your input");
            new Menu().pause();
            return;
        }

        tempFlight = flights.getFlights().get(tempFlightIndex);
        tempFlightList = users.get(passengerIndex).getPassengerFlights();

        // return if the Passenger account has not enough charge
        if (users.get(passengerIndex).getCharge() < tempFlight.getPrice()) {
            System.out.println("The price of flight is :" + tempFlight.getPrice());
            System.out.println("your balance :" + users.get(passengerIndex).getCharge());
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


        users.get(passengerIndex).setCharge(users.get(passengerIndex).getCharge() - tempFlight.getPrice());
        tempFlight.setBookedSeats(tempFlight.getBookedSeats() + 1);


        tempFlightList.add(tempFlight);
        users.get(passengerIndex).setPassengerFlights(tempFlightList);

        System.out.println("the Flight Booked");
        new Menu().pause();

    }

    public void printBookedList(int passengerIndex, Flights flights) {
        boolean flag = false;
        for (int i = 0; i < users.get(passengerIndex).getPassengerFlights().size(); i++) {
            if (!flag) {
                flights.printFlightHeader();
            }
            flights.printFlight(i, users.get(passengerIndex).getPassengerFlights());
            flag = true;
        }
        if (!flag) {
            System.out.println("nothing found");
        }
    }

    public void removeFromBookedList(int passengerIndex, Flights flights) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Please enter the Flight Id Which flight do yo want to remove ");
        System.out.println("The system deducts 10% of the flight money as a penalty from your account\n" +
                " and returns the rest of the flight money to your account");
        String flightId = scanner.nextLine();

        //Searching
        int searchingIndexForAllFlights = flights.findFlightIndex(flightId);

        // Not found condition
        if (searchingIndexForAllFlights == -1) {
            System.out.println("check your input");
            new Menu().pause();
            return;
        }

        ArrayList<Flight> tempFlights;
        tempFlights = users.get(passengerIndex).getPassengerFlights();
        Flight tempFlight = tempFlights.get(searchingIndexForAllFlights);
        int searchingIndexForPassengerFlights = tempFlights.indexOf(tempFlight);
        if (searchingIndexForPassengerFlights == -1) {
            System.out.println("the flight has not booked to remove");
            new Menu().pause();
            return;
        }


        tempFlights.get(searchingIndexForPassengerFlights).setBookedSeats(tempFlight.getBookedSeats() - 1);

        users.get(passengerIndex).setCharge(users.get(passengerIndex).getCharge() + (tempFlight.getPrice() * 9 / 10));

        tempFlights.remove(searchingIndexForAllFlights);

        users.get(passengerIndex).setPassengerFlights(tempFlights);

        System.out.println("<Flight removed>");
        new Menu().pause();

    }


    public void creatNewUser(String id, String password) {
        Passenger passenger = new Passenger();

        passenger.setPassengerID(id);
        passenger.setPassword(password);
        ArrayList<Flight> passengerFlight = new ArrayList<Flight>();
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
