package service;

import model.Customer;
import model.Room;

public interface ICustomerService {
    void saveCustomer(Customer c);

    void showAllCustomer(Room r);

    void updateCustomer(Room r, int id, String newName, int newId, int newLengthofStay);

    void deleteCustomer(Room r);

    Room selectRoom();

}
