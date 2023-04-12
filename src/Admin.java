import java.util.Scanner;

public class Admin {
    private static Admin singletonAdmin;
    private Admin() {}

    public static Admin getInstance() {
        if (singletonAdmin == null) {
            singletonAdmin = new Admin();
        }
        return singletonAdmin;
    }




    public void admin(Users users, Flights flights) {
        Scanner scan = new Scanner(System.in);
        new Menu().printAdminMenu();
        int key = scan.nextInt();

        switch (key){
            // Add
            case 1:
                flights.addFlight();
                break;
            // Update
            case 2:
                flights.updateFlight();
                break;
            // Remove
            case 3:

                break;
            // Flight List
            case 4:
                new Flights().printFlightHeader();
                flights.printFlight(flights.getFlights());
                break;
            // Exit point
            case 0:
                return;
            default:
                System.out.println("please check your entry");
                new Menu().pause();
                break;
        }
        this.admin(users,flights);

    }






}
