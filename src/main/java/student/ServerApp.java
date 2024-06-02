package student;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerApp {
    public static void main(String[] args) throws Exception {
        final int PORT = 20000;
        try {

            //listening
            ServerSocket serverSocket = new ServerSocket(PORT);

            System.out.println("Server running at port " + PORT);

            while (true) {
                // Accept a client connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("A client was connected");


                // Read the Json message from the client
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                StringBuilder jsonMessageBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    jsonMessageBuilder.append(line);
                }

                String jsonMessage = reader.readLine();

                //Debug: Print the received JSON message
                System.out.println("Server received: " + jsonMessage);

                // Deserialize the JSON message to a Message object
                if (jsonMessage != null && jsonMessage.trim().isEmpty()) {
                    ObjectMapper objectMapper = new ObjectMapper();
                    Message message = objectMapper.readValue(jsonMessage, Message.class);

                    //Save the Message object to JSON file
                    try (FileWriter fileWriter = new FileWriter("received_message.json")) {
                        objectMapper.writeValue(fileWriter, message);
                    }
                    System.out.println("Client sent message: " + message);
                } else {
                    System.err.println("Received null or empty JSON message.");
                }

                clientSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

