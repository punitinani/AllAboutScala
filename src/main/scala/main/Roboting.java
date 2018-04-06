package main;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Roboting {

    static ServerSocket server;
    private static int port = 1997;
    private static Thread robo;


    public static void main(String[] args) throws IOException,
            AWTException, InterruptedException, IOException, ClassNotFoundException {
        Robot robot = new Robot();
        server = new ServerSocket(port);
        while (true) {
            System.out.println("Waiting for the client request");

            try {
                Socket socket = server.accept();
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                String message = (String) objectInputStream.readObject();
                if (message.equals("left")) {
                    robot.keyPress(KeyEvent.VK_LEFT);
                    Thread.sleep(30);
                }
                  if (message.equals("right")) {
                    robot.keyPress(KeyEvent.VK_RIGHT);
                      Thread.sleep(30);
                }

                if (message.equals("nos")) {
                    robot.keyPress(KeyEvent.VK_SPACE);
                    Thread.sleep(30)     ;
                }

                System.out.println("Message :::" + message);
                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }


    }

}