package service;

import model.Room;

import java.io.*;

import static service.CustomerService.rooms;

public class IO {
    final static String filePath = System.getenv("file_path");
    public static File file = new File(filePath);
    public static void writeFile() throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        try {
            for (Room room :
                    rooms) {
                objectOutputStream.writeObject(room);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error");
        }
        objectOutputStream.close();
        fileOutputStream.close();
    }

    // Read file
    public static Room[] readFile() throws IOException{
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            for (int i = 0; i < rooms.length; i++) {
                rooms[i] = (Room) objectInputStream.readObject();
            }

            objectInputStream.close();
            fileInputStream.close();
            return rooms;
        } catch (FileNotFoundException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
