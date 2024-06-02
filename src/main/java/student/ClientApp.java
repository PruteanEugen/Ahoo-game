package student;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.UUID;

public class ClientApp {
    public static void main(String[] args) throws Exception {
        final int PORT = 20000;
        try {
            // READ JSON from file and deserialize to Message object
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(System.getProperty("user.dir") + "\\data\\message.json");
            Message message = objectMapper.readValue(file, Message.class);
            System.out.println(message);


            //Serialize the message object to JSON
            String jsonMessage = objectMapper.writeValueAsString(message);
            System.out.println(jsonMessage);

            //Connect to the server
            Socket clientSocket = new Socket("localhost", PORT);
            System.out.println("Connected to server");


            OutputStream os = clientSocket.getOutputStream();
            PrintWriter writer = new PrintWriter(os,true);

            //Send the Json messange to the server

            writer.println(jsonMessage);


            clientSocket.close();
        }catch ( Exception e ) {
            e.printStackTrace();
        }



    }
}
