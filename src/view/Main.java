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
                    case 2: // Show customers in a room
                        Room roomToShow = Menu.getRoomNumber();
                        cService.showCustomer(roomToShow);
                        break;
                    case 3: // Show all
                        cService.showAll();
                        break;
                    case 4: // Update
                        Room roomToUpdate = Menu.getRoomNumber();
                        int idToUpdate = Menu.getIdToUpdate();
                        Customer updatedCustomer = Menu.getUpdatedCustomerInfo();
                        cService.updateCustomer(roomToUpdate, idToUpdate, updatedCustomer.getName(), updatedCustomer.getId(), updatedCustomer.getLengthOfStay());
                        break;
                    case 5: // Calculate Cost
                        Room roomToCalculate = Menu.getRoomNumber();
                        cService.calculateCost(roomToCalculate);
                        break;
                    case 6: // Delete
                        Room roomToDelete = Menu.getRoomNumber();
                        cService.deleteCustomer(roomToDelete);
                        break;
                    case 7: // Quit
                        System.out.println("Closing program!");
                        condition = false;
                        break;
                    default: // When user fails to input 1-5
                        System.out.println("Invalid input. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please try again.");;
            }
        }
    }
}
