package service;

import model.Room;

public class CustomerService {
    static Room[] rooms = new Room[3];
    static {
        rooms[0] = new Room(1, 100000);
        rooms[1] = new Room(2, 200000);
        rooms[3] = new Room(3, 500000);
    }

//    dien thong tin
//    select room -> 2
//    rooms[1].addCustomer(c);
}
