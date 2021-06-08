package service;

import model.Customer;
import model.Room;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerService implements ICustomerService{
    static Room[] rooms = new Room[3];
    Scanner sc = new Scanner(System.in);
    static {
        rooms[0] = new Room(1, 100000);
        rooms[1] = new Room(2, 200000);
        rooms[3] = new Room(3, 500000);
    }
    ArrayList<Customer> customersList = new ArrayList<>();

    @Override
    public void saveCustomer(Customer c) {
        customersList.add(c);
    }

    @Override
    public void showAllCustomer() {
        if (customersList.isEmpty()){
            System.out.println("No customer to show");
        }
        for (int i = 0; i < customersList.size(); i++) {
            System.out.println(customersList.get(i).toString());
        }
    }

    @Override
    public void updateCustomer(int id, String newName, int newId, int newLengthofStay) {
        int count = 0;
        if(customersList.isEmpty()){
            System.out.println("No customer to update");
            return;
        }
        for (Customer c:
             customersList) {
            if (id == c.getId()){
                c.setName(newName);
                c.setId(newId);
                c.setLengthOfStay(newLengthofStay);
            }
            count++;
        }
        if (count == 0){
            System.out.println("Cannot update");
        }
        System.out.println("Successfully updated");
    }

    @Override
    public void deleteCustomer(int id) {
        int count = 0;
        if(customersList.isEmpty()){
            System.out.println("No customer to delete");
            return;
        }
        for (int i = 0; i < customersList.size(); i++) {
            if(id == customersList.get(i).getId()){
                customersList.remove(i);
            }
            count++;
        }
        if(count == 0){
            System.out.println("Cannot delete");
        }
        System.out.println("Successfully deleted");

    }

    @Override
    public void showCustomer(int id) {
        if (customersList.isEmpty()){
            System.out.println("No customer to show");
            return;
        }
        for (int i = 0; i < customersList.size(); i++) {
            if(id == customersList.get(i).getId()){
                customersList.get(i).toString();
            }
            System.out.println("No such customer to show");
        }


    }

    @Override
    public Room selectRoom() {
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
        return null;
    }


    @Override
    public void printRoom(){
        System.out.println("------Room List------");
        for (Room room : rooms){
            System.out.println("Room " + room.getRoomType());
        }
    }

//    dien thong tin
//    select room -> 2
//    rooms[1].addCustomer(c);


}
