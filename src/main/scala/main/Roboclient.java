package main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

public class Roboclient {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        System.out.println("Client connected");


        InetAddress host = InetAddress.getLocalHost();
        Socket socket = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        for (int i = 100; i < 500; i++) {

            socket = new Socket(host.getHostName(), 1997);

            oos = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Sending request to Socket Server");
            ArrayList<Integer> message = new ArrayList<Integer>();
            message.add(i);
            message.add(i);
            oos.writeObject(message);
            if (i == 400) {
            }
            socket.close();
            oos.flush();

            Thread.sleep(100);
        }
        oos.close();


    }
}
