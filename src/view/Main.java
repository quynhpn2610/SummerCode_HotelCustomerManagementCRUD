//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package view;

import model.Customer;
import model.Room;
import service.CustomerService;

public class Main {
    private static final CustomerService cService = new CustomerService();

    public Main() {
    }

    public static void main(String[] args) {
        boolean condition = true;

        while(condition) {
            Menu.showMenu();

            try {
                int userChoice = Menu.getUserChoice();
                switch(userChoice) {
                    case 1:
                        Customer newCustomer = Menu.getCustomerToAdd();
                        cService.saveCustomer(newCustomer);
                        break;
                    case 2:
                        Room roomToShow = Menu.getRoomNumber();
                        cService.showAllCustomer(roomToShow);
                        break;
                    case 3:
                        Room roomToUpdate = Menu.getRoomNumber();
                        int idToUpdate = Menu.getIdToUpdate();
                        Customer updatedCustomer = Menu.getUpdatedCustomerInfo();
                        cService.updateCustomer(roomToUpdate, idToUpdate, updatedCustomer.getName(), updatedCustomer.getId(), updatedCustomer.getLengthOfStay());
                        break;
                    case 4:
                        Room roomToDelete = Menu.getRoomNumber();
                        cService.deleteCustomer(roomToDelete);
                        break;
                    case 5:
                        System.out.println("Closing program!");
                        condition = false;
                        break;
                    default:
                        System.out.println("Invalid input. Please try again.");
                }
            } catch (NumberFormatException var9) {
                System.out.println("Invalid input. Please try again.");
            }
        }

    }
}
