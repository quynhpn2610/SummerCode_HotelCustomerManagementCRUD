package view;

import model.Customer;
import model.Room;
import service.CustomerService;
import service.IO;

import java.io.IOException;
import java.util.Scanner;

import static service.CustomerService.rooms;

public class Menu {
    private static final Scanner sc = new Scanner(System.in);
    private static final CustomerService customerService = new CustomerService();

    static void showMenu(){
        System.out.println("Welcome to the Hotel Customer Management program");
        System.out.println("------Please select an option------");
        System.out.println("1 - Check in");
        System.out.println("2 - Show all customers in a room");
        System.out.println("3 - Show all customers");
        System.out.println("4 - Update a customer's info");
        System.out.println("5 - Calculate Cost");
        System.out.println("6 - Check out");
        System.out.println("7 - Quit program");
    }

    static int getUserChoice(){
        return Integer.parseInt(sc.nextLine());
    }

    static Customer getCustomerToAdd(){
        System.out.println("---Add a new customer---");
        System.out.println("Enter customer id");
        int idToAdd = Integer.parseInt(sc.nextLine());
        System.out.println("Enter customer's name");
        String nameToAdd = sc.nextLine();
        System.out.println("Enter length of stay (in days)");
        int lengthOfStay = Integer.parseInt(sc.nextLine());
        return new Customer(nameToAdd, idToAdd, lengthOfStay);
    }

    static Room getRoomNumber() throws IOException {
        System.out.println("Enter room number");
        int roomNumber = Integer.parseInt(sc.nextLine());
        rooms = IO.readFile();
        return rooms[roomNumber-1];
    }

    static int getIdToUpdate(){
        System.out.println("Enter customer id");
        return (Integer.parseInt(sc.nextLine()));
    }

    static Customer getUpdatedCustomerInfo(){
        System.out.println("---Update new info---");
        System.out.println("Enter updated id");
        int newId = Integer.parseInt(sc.nextLine());
        System.out.println("Enter updated name");
        String newName = sc.nextLine();
        System.out.println("Enter updated length of stay");
        int newLength = Integer.parseInt(sc.nextLine());
        return new Customer(newName, newId, newLength);
    }
}
