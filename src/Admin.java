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
        int key = scan.nextInt();

        switch (key){
            // Add
            case 1:
                break;
            // Update
            case 2:
                break;
            // Remove
            case 3:
                break;
            // Flight List
            case 4:
                break;
            // Exit point
            case 0:
                return;
            default:
                break;
        }



    }




}
