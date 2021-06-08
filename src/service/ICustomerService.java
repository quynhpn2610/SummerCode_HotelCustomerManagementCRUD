package service;

import model.Customer;

public interface ICustomerService {
    void saveCustomer(Customer c);

    void showAllCustomer();

    void updateCustomer(int id, String newName, String newId, int newLengthofStay);

    void deleteCustomer(int id);

    void showCustomer(int id);
}
