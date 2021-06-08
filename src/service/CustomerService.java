package service;

import model.Customer;
import model.Room;

import java.util.ArrayList;

public class CustomerService implements ICustomerService{
    static Room[] rooms = new Room[3];
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

    }
//    dien thong tin
//    select room -> 2
//    rooms[1].addCustomer(c);


}
