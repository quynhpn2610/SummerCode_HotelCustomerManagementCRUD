package model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Room {
    private int roomType;
    private double roomRate;
    private ArrayList<Customer> customers = new ArrayList<>();

    public int getRoomType() {
        return roomType;
    }

    public void setRoomType(int roomType) {
        this.roomType = roomType;
    }

    public double getRoomRate() {
        return roomRate;
    }

    public void setRoomRate(double roomRate) {
        this.roomRate = roomRate;
    }

    public ArrayList<Customer> getCustomers() {
        return (ArrayList<Customer>) customers.clone();
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public void addCustomers(Customer c) {
        customers.add(c);
    }

    public Room(int roomType, double roomRate) {
        this.roomType = roomType;
        this.roomRate = roomRate;
    }
}
