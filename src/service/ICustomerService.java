package service;

import model.Customer;
import model.Room;

public interface ICustomerService {
    void saveCustomer(Customer c);

    void showCustomer(Room r);

    void showAll();

    void updateCustomer(Room r, int id, String newName, int newId, int newLengthOfStay);

    void deleteCustomer(Room r);

    void calculateCost(Room r);

    Room selectRoom();

}
