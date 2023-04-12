import java.util.ArrayList;
import java.util.Scanner;

public class Users {
    private ArrayList<Passenger> users = new ArrayList<Passenger>(10);


    public ArrayList<Passenger> getPassengers() {
        return users;
    }
    public void setPassengers(ArrayList<Passenger> passengers) {
        users = passengers;
    }

    // Search
    public boolean searchUser(String targetId){
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getPassengerID().equals(targetId)){
                return true;
            }
        }

        return false;
    }
    public int findUserIndex(String targetId, String targetPass){
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getPassengerID().equals(targetId)){
                if (users.get(i).getPassword().equals(targetPass)){
                    return i;
                }
                return -1;
            }
        }

        return -1;
    }


    public void creatNewUser(String id, String password){
    Passenger passenger = new Passenger();

    passenger.setPassengerID(id);
    passenger.setPassword(password);
    passenger.setPassengerFlights(null);
    passenger.setCharge(0);

    users.add(passenger);


    }
    public void changePassword(int index, String newPass){
    Passenger tempPassenger = new Passenger();
    tempPassenger = users.get(index);
    tempPassenger.setPassword(newPass);
    users.set(index,tempPassenger);

    }

    public void chargeAccount(int index){
        Scanner scan = new Scanner(System.in);
        Passenger tempPassenger = new Passenger();
        tempPassenger = users.get(index);
        System.out.println("Your Balance : " + tempPassenger.getCharge());

        System.out.println("enter how much do you want to charge your account ");
        int charge = scan.nextInt();

        tempPassenger.setCharge(tempPassenger.getCharge() + charge);

        users.set(index,tempPassenger);
    }



}
