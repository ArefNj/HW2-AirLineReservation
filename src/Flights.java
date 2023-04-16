import java.util.ArrayList;
import java.util.Scanner;

public class Flights {
    private ArrayList<Flight> flights = new ArrayList<Flight>();

    public void filterFlight(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("< choose search method >");
        System.out.print("""
                <1> by Flight Id
                <2> by Origen
                <3> by destination
                <4> by Date
                <5> by Time
                <6> by prise
                <7> Show All
                <0> Exit
                
                -->""");
        int searchKey = scanner.nextInt();
        switch (searchKey){
            case 1:
                System.out.println("Enter the flight Id");
                scanner.nextLine();
                String tempId = scanner.nextLine();
                int index = findFlightIndex(tempId);
                if (index == -1){
                    System.out.println("nothing found !");
                    new Menu().pause();
                    break;
                }
                printFlight(index,flights);
                break;
            case 2:
                System.out.println("Enter the Origen");
                scanner.nextLine();
                String tempOrigen = scanner.nextLine();
                findFlightIndexOrigenAndPrint(tempOrigen);
                break;
            case 3:
                System.out.println("Enter the Destination");
                scanner.nextLine();
                String tempDestination = scanner.nextLine();
                findFlightIndexDestinationAndPrint(tempDestination);
                break;
            case 4:
                System.out.println("Enter the Date");
                scanner.nextLine();
                String tempDate = scanner.nextLine();
                findFlightIndexDateAndPrint(tempDate);
                break;
            case 5:
                System.out.println("Enter the Date");
                scanner.nextLine();
                String tempTime = scanner.nextLine();
                findFlightIndexTimeAndPrint(tempTime);
                break;
            case 6:
                System.out.println("Input the maximum price");
                int maxPrice = scanner.nextInt();
                boolean flag = false;
                for (int i = 0; i < flights.size(); i++) {
                    if (flights.get(i).getPrice() <= maxPrice){
                        if (!flag){
                            flag = true;
                            printFlightHeader();
                        }
                        printFlight(i,flights);
                    }
                }
                if (!flag){
                    System.out.println("nothing found !");
                }
                break;
            case 7:
                printFlightHeader();
                printFlight(flights);
                break;

            case 0:
                return;

            default:
                System.out.println("please check your entry");
                new Menu().pause();
                break;
        }

        this.filterFlight();
    }

    public void printFlightHeader(){
        System.out.println("|FlightId   |Origin     |Destination  |Date        |Time       |Price      |Seats |Booked Seats|");
    }

    public void printFlight(ArrayList<Flight> passengerFlight){
        for (int i = 0; i < passengerFlight.size(); i++) {
            printFlight(i,passengerFlight);
        }
    }

    public void printFlight(int flightIndex, ArrayList<Flight> passengerFlight){
        System.out.println("................................................................................................");
        System.out.printf("|%-11s|%-11s|%-13s|%-12s|%-11s|%-,11d|%-6d|%-12d|\n"
                ,passengerFlight.get(flightIndex).getFlightID()
                ,passengerFlight.get(flightIndex).getOrigen()
                ,passengerFlight.get(flightIndex).getDestination()
                ,passengerFlight.get(flightIndex).getDate()
                ,passengerFlight.get(flightIndex).getTime()
                ,passengerFlight.get(flightIndex).getPrice()
                ,passengerFlight.get(flightIndex).getSeats()
                ,passengerFlight.get(flightIndex).getBookedSeats());
    }

    public int findFlightIndex(String targetFlightId){
        for (int i = 0; i < flights.size(); i++) {
            if (flights.get(i).getFlightID().equals(targetFlightId)){
                    return i;
            }
        }
        return -1;
    }
    public void findFlightIndexOrigenAndPrint(String targetFlightOrigen){
        boolean somethingFound = false;
        for (int i = 0; i < flights.size(); i++) {
            if (flights.get(i).getOrigen().equals(targetFlightOrigen)){
                if (!somethingFound){
                    printFlightHeader();
                }
                somethingFound = true;
                printFlight(i,flights);
            }
        }
        if (!somethingFound){
            System.out.println("nothing found !");
        }
    }
    public void findFlightIndexDestinationAndPrint(String targetDestination){
        boolean somethingFound = false;
        for (int i = 0; i < flights.size(); i++) {
            if (flights.get(i).getDestination().equals(targetDestination)){
                if (!somethingFound){
                    printFlightHeader();
                }
                somethingFound = true;
                printFlight(i,flights);
            }
        }
        if (!somethingFound){
            System.out.println("nothing found !");
        }
    }
    public void findFlightIndexDateAndPrint(String targetDate){
        boolean somethingFound = false;
        for (int i = 0; i < flights.size(); i++) {
            if (flights.get(i).getDate().equals(targetDate)){
                if (!somethingFound){
                    printFlightHeader();
                }
                somethingFound = true;
                printFlight(i,flights);
            }
        }
        if (!somethingFound){
            System.out.println("nothing found !");
        }
    }
    public void findFlightIndexTimeAndPrint(String targetTime){
        boolean somethingFound = false;
        for (int i = 0; i < flights.size(); i++) {
            if (flights.get(i).getTime().equals(targetTime)){
                if (!somethingFound){
                    printFlightHeader();
                }
                somethingFound = true;
                printFlight(i,flights);
            }
        }
        if (!somethingFound){
            System.out.println("nothing found !");
        }
    }

    public int findFlightIndex(int targetFlightPrice){
        for (int i = 0; i < flights.size(); i++) {
            if (flights.get(i).getPrice() <= targetFlightPrice){
                return i;
            }
        }
        return -1;
    }

    public void updateFlight(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Please enter the Flight Id Which flight do yo want to update ");
        String flightId = scanner.nextLine();

        int flightIndex = findFlightIndex(flightId);

        if (flightIndex == -1){
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
                Flight tempFlight = new Flight();
                tempFlight = flights.get(flightIndex);

                switch (key){
                    case 1:
                        System.out.println("Enter new Flight id");
                        scanner.nextLine();
                        String tempId = scanner.nextLine();
                        tempFlight.setFlightID(tempId);
                        flights.set(flightIndex,tempFlight);
                        break;
                    case 2:
                        System.out.println("Enter new Origin");
                        scanner.nextLine();
                        String tempOrigin = scanner.nextLine();
                        tempFlight.setOrigen(tempOrigin);
                        flights.set(flightIndex,tempFlight);
                        break;
                    case 3:
                        System.out.println("Enter new Distance");
                        scanner.nextLine();
                        String tempDistance = scanner.nextLine();
                        tempFlight.setDestination(tempDistance);
                        flights.set(flightIndex,tempFlight);
                        break;
                    case 4:
                        System.out.println("Enter new Date");
                        scanner.nextLine();
                        String tempDate = scanner.nextLine();
                        tempFlight.setDate(tempDate);
                        flights.set(flightIndex,tempFlight);
                        break;
                    case 5:
                        System.out.println("Enter new Time");
                        scanner.nextLine();
                        String tempTime = scanner.nextLine();
                        tempFlight.setTime(tempTime);
                        flights.set(flightIndex,tempFlight);
                        break;
                    case 6:
                        System.out.println("Enter new Price");
                        scanner.nextLine();
                        int tempPrice = scanner.nextInt();
                        tempFlight.setPrice(tempPrice);
                        flights.set(flightIndex,tempFlight);
                        break;
                    case 7:
                        System.out.println("Enter Seats");
                        scanner.nextLine();
                        int tempSeats = scanner.nextInt();
                        tempFlight.setPrice(tempSeats);
                        flights.set(flightIndex,tempFlight);
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

    public void removeFlight(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Please enter the Flight Id Which flight do yo want to remove ");
        String flightId = scanner.nextLine();

        int flightIndex = findFlightIndex(flightId);

        if (flightIndex == -1){
            System.out.println("Please check your entry ");
            new Menu().pause();
            return;
        }
        flights.remove(flightIndex);

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
