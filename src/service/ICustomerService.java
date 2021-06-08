package service;

import model.Customer;
import model.Room;

public interface ICustomerService {
    void saveCustomer(Customer c);

    void showAllCustomer();

    void updateCustomer(int id, String newName, int newId, int newLengthofStay);

    void deleteCustomer(int id);

    void showCustomer(int id);

    Room selectRoom();

    void printRoom();


}
