package student;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerApp {
    public static void main( String[] args ) throws Exception {
        final int PORT = 20000;
        ServerSocket serverSocket = new ServerSocket(PORT);

        // listening
        System.out.println("Server running...");
        Socket clientSocket = serverSocket.accept();
        System.out.println("A Client has connected");

        InputStream is = clientSocket.getInputStream();

        ObjectInputStream ois = new ObjectInputStream(is);

        Message message = (Message)ois.readObject();
        ois.close();
        clientSocket.close();
        // print received messages
        System.out.println("Client:" + message.getId() + "Client sent: " + message.getBody());
        // write object message in JSON file
        JSONObject messageJson = message.toJson();
        // Try-with-resources construction that autoclose resources
        try (PrintWriter printWriter = new PrintWriter(new FileOutputStream(
                System.getProperty("user.dir") + "\\data\\receivedMessage.json"))) {
            // Pretty print JSON with indentation
            printWriter.write(messageJson.toString(2));
        }
        serverSocket.close();
    }
}

