package service;

import model.Customer;
import model.Room;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerService implements ICustomerService {
    public static Room[] rooms = new Room[3];
    Scanner sc = new Scanner(System.in);

    static {
        rooms[0] = new Room(1, 100000);
        rooms[1] = new Room(2, 200000);
        rooms[3] = new Room(3, 500000);
    }

    ArrayList<Customer> customersList = new ArrayList<>();

    @Override
    public Room selectRoom() {
        try {
            System.out.println("------Select a room type------");
            System.out.println("1 - Standard - Rate 500,000");
            System.out.println("2 - VIP - Rate 1,000,000");
            System.out.println("3 - Luxury - Rate 1,500,000");
            int roomType = Integer.parseInt(sc.nextLine());
            switch (roomType) {
                case 1:
                    return rooms[0];
                case 2:
                    return rooms[1];
                case 3:
                    return rooms[2];
            }
        } catch (NumberFormatException exception){
            System.out.println("Invalid input. Please try again.");
        }
        return null;
    }

    @Override
    // Check in
    public void saveCustomer(Customer c) {
        Room selectedRoom = selectRoom();
        selectedRoom.addCustomers(c);
        System.out.println("Check in successfully");
    }

    @Override
    public void showAllCustomer(Room roomToShow) {
        if (roomToShow.getCustomers().isEmpty()) {
            System.out.println("No customer to show");
        }
        for (int i = 0; i < roomToShow.getCustomers().size(); i++) {
            System.out.println(roomToShow.getCustomers().get(i).toString());
        }
    }

    @Override
    public void updateCustomer(Room roomToUpdate, int idToUpdate, String newName, int newId, int newLengthofStay) {
        int count = 0;
        if (roomToUpdate.getCustomers().isEmpty()) {
            System.out.println("Room empty. No customer to update!");
            return;
        }

        for (Customer c : roomToUpdate.getCustomers()) {
            if (idToUpdate == c.getId()) {
                c.setName(newName);
                c.setId(newId);
                c.setLengthOfStay(newLengthofStay);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Cannot update");
        }
        System.out.println("Customer successfully updated");
    }

    @Override
    // Check out
    public void deleteCustomer(Room roomToDelete) {
        if (roomToDelete.getCustomers().isEmpty()) {
            System.out.println("Room empty. No customer to check out!");
            return;
        }
        roomToDelete.getCustomers().removeAll(roomToDelete.getCustomers());
        System.out.println("Successfully deleted");
    }
}


