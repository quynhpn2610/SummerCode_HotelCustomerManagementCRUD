package service;

import model.Customer;
import model.Room;

import java.io.IOException;

public interface ICustomerService {
    void saveCustomer(Customer c) throws IOException;

    void showCustomer(Room r);

    void showAll();

    void updateCustomer(Room r, int id, String newName, int newId, int newLengthOfStay);

    void deleteCustomer(Room r);

    void calculateCost(Room r);

    Room selectRoom();

}
