import java.util.Scanner;

public class Menu {


    private Users userList = new Users();
    private Flights flightsList = new Flights();

    public void printMainMenu(){
        System.out.print("""
                ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
                           WELCOME TO AIRLINE RESERVATION SYSTEM
                ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
                ..........................MENU OPTIONS........................
                                
                    <1> Sign in
                    <2> Sign up\s
                    
                    
                -->\040""");
    }

    public void printAdminMenu(){
        System.out.print("""
                ::::::::::::::::::::::::::::::::::::::::
                           Admin MENU OPTIONS
                ::::::::::::::::::::::::::::::::::::::::
                 ......................................
                 
                    <1> Add
                    <2> Update
                    <3> Remove
                    <4> Flight schedules
                    <0> Sign out
                    
                    
                -->\040""");
    }

    public void printPassengerMenu(){
        System.out.print("""
                ::::::::::::::::::::::::::::::::::::::::
                         PASSENGER MENU OPTIONS
                ::::::::::::::::::::::::::::::::::::::::
                 ......................................
                 
                    <1> Change password
                    <2> Search flight tickets
                    <3> Booking ticket
                    <4> Ticket cancellation
                    <5> Booked tickets
                    <6> Add charge
                    <0> Sign out
                    
                    
                -->\040""");
    }

    public void printSignUpMenuHeader(){
        System.out.print("""
                ::::::::::::::::::::::::::::::::::::::::
                               Sign Up Menu
                ::::::::::::::::::::::::::::::::::::::::
                 ......................................
          
                
                """);
    }

    public void printSignInMenuHeader(){
        System.out.print("""
                ::::::::::::::::::::::::::::::::::::::::
                               Sign In Menu
                ::::::::::::::::::::::::::::::::::::::::
                 ......................................
          
                
                
                """);
    }

    public void menu() {
        Scanner scan = new Scanner(System.in);

        printMainMenu();
        int mainMenuKey = scan.nextInt();

        switch (mainMenuKey){
            case 1:
                signIn();
                break;
            case 2 :
                signUp();
                break;
            default:
                System.out.println("Please Enter the proper value");
                pause();
        }
        this.menu();
    }

    public void signUp(){
        Scanner scan = new Scanner(System.in);
        printSignUpMenuHeader();

        System.out.println("Enter your ID ( Enter 'X' to Exit )");
        String tempId = scan.nextLine();

        if (tempId.equals("X")){ this.menu(); }

        if (userList.searchUser(tempId) || tempId.equals("Admin")){
            System.out.println("The User name was Token");
            pause();
            this.signUp();
        }

        System.out.println(" Enter your password");
        String tempPass = scan.nextLine();

        userList.creatNewUser(tempId,tempPass);

        this.menu();


    }

    public void signIn(){
        Scanner scan = new Scanner(System.in);
        printSignInMenuHeader();

        System.out.println("Enter your ID");
        String tempId = scan.nextLine();


        System.out.println(" Enter your password");
        String tempPass = scan.nextLine();
        // Admin Entry point
        if (tempId.equals("Admin") && tempPass.equals("Admin")){
            printAdminMenu();
            Admin admin = Admin.getInstance();
            admin.admin(userList,flightsList);
            System.out.println("Have Nice Day !");
            pause();
            this.menu();



        }
        // else Users
        else{
        int indexKey = userList.findUserIndex(tempId, tempPass);
            if (indexKey == -1){
                System.out.println("Entry id or password is wrong");
                pause();
                this.menu();
            }
            passengerMenu(indexKey);
        }


    }

    public void passengerMenu(int passengerIndex){
        printPassengerMenu();
        Scanner scan = new Scanner(System.in);
        int key = scan.nextInt();


        switch (key){
            // change Password
            case 1:
                System.out.print("Enter new password\n");
                scan.nextLine();
                String newPassengerPassword = scan.nextLine();
                userList.changePassword(passengerIndex,newPassengerPassword);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                userList.chargeAccount(passengerIndex);
                break;
            case 0:
                System.out.println(" Have nice day !");
                pause();
                this.menu();
                break;
            default:
                break;
        }

        this.passengerMenu(passengerIndex);


    }
    public void pause(){
        System.out.println("Press Any Key To Continue...");
        new java.util.Scanner(System.in).nextLine();
    }

}
