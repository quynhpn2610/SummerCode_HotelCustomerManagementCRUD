package view;
import model.Room;
import model.Customer;
import service.ICustomerService;
import service.CustomerService;

public class Main {
    private static final ICustomerService cService = new CustomerService();

    public static void main(String[] args) {
        boolean condition = true;
        while (condition){
            Menu.showMenu();
            try{
                int userChoice = Menu.getUserChoice();
                switch (userChoice){
                    case 1: // Create/Save/Add
                        Customer newCustomer = Menu.getCustomerToAdd();
                        cService.saveCustomer(newCustomer);
                        break;
                    case 2: // Read all
                        Room roomToShow = Menu.getRoomNumber();
                        cService.showAllCustomer(roomToShow);
                        break;
                    case 3: // Update
                        Room roomToUpdate = Menu.getRoomNumber();
                        int idToUpdate = Menu.getIdToUpdate();
                        Customer updatedCustomer = Menu.getNewCustomerInfo();
                        cService.updateCustomer(roomToUpdate, idToUpdate, updatedCustomer.getName(), updatedCustomer.getId(), updatedCustomer.getLengthOfStay());
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please try again.");;
            }
        }
    }
}
