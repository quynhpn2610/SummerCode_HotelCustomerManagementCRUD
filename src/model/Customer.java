package model;

import java.io.Serializable;

public class Customer implements Serializable {
    private String name;
    private int id;
    private int lengthOfStay;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLengthOfStay() {
        return lengthOfStay;
    }

    public void setLengthOfStay(int lengthOfStay) {
        this.lengthOfStay = lengthOfStay;
    }

    public Customer(String name, int id, int lengthOfStay) {
        this.name = name;
        this.id = id;
        this.lengthOfStay = lengthOfStay;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", lengthOfStay=" + lengthOfStay +
                '}';
    }
}
