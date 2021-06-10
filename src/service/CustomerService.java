package service;

import model.Customer;
import model.Room;
import java.util.Scanner;

public class CustomerService implements ICustomerService {
    public static Room[] rooms = new Room[3];
    Scanner sc = new Scanner(System.in);

    static {
        rooms[0] = new Room(1, 500000);
        rooms[1] = new Room(2, 1000000);
        rooms[2] = new Room(3, 1500000);
    }

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
    public boolean isEmpty(Room room) {
        if (room.getCustomers().isEmpty()){
            System.out.println("Room is empty.");
            return true;}
        return false;
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
        if (!isEmpty(roomToShow)) {
            for (int i = 0; i < roomToShow.getCustomers().size(); i++) {
                System.out.println(roomToShow.getCustomers().get(i).toString());
            }
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

    @Override
    public double calculateCost(Room roomToCalculate) {
        double rate = roomToCalculate.getRoomRate();
        Customer c = roomToCalculate.getCustomers().get(0);
        int lengthOfStay = c.getLengthOfStay();
        double totalCost = rate * lengthOfStay;
        return totalCost;
    }
}


