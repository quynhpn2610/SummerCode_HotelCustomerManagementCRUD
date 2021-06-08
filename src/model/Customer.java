package model;

public class Customer {
    private String name;
    private String id;
    private int lengthOfStay;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLengthOfStay() {
        return lengthOfStay;
    }

    public void setLengthOfStay(int lengthOfStay) {
        this.lengthOfStay = lengthOfStay;
    }

    public Customer(String name, String id, int lengthOfStay) {
        this.name = name;
        this.id = id;
        this.lengthOfStay = lengthOfStay;
    }

    public Customer() {
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
