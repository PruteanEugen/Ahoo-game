package student;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.UUID;

public class ClientApp {
    public static void main(String[] args) throws Exception {
        final int PORT = 20000;
       // Scanner in = new Scanner(System.in);

        Socket clientSocket = new Socket("localhost", PORT);
      //  System.out.println("Connected to server");

        //System.out.println("Enter our messages");
      //  String messages = in.nextLine();

        OutputStream os = clientSocket.getOutputStream();

        ObjectOutputStream oos = new ObjectOutputStream(os); //Paternul decoratorului
        Message message = new Message("Hello",UUID.randomUUID());
        oos.writeObject(message);
        oos.close();
        clientSocket.close();


    }
}
