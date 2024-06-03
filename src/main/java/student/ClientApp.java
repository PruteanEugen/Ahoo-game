package student;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.UUID;

public class ClientApp {
    public static void main(String[] args) throws Exception {
        final int PORT = 20000;
        // create socket
        Socket clientSocket = new Socket("localhost", PORT);
        System.out.println("Client connected to server!");
        // create output stream
        OutputStream os = clientSocket.getOutputStream();
        // decorate outputstream
        ObjectOutputStream oos = new ObjectOutputStream(os);
        // create file input stream from json file
        FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir") + "\\data\\message.json");
        // put all input in string
        String textContent = new String(fis.readAllBytes());
        // put string from input in json object
        JSONObject jo = new JSONObject(textContent);
        // create message object from jsonObject
        Message message = new Message(jo);
        // sent message object
        oos.writeObject(message);
        // close all session
        fis.close();
        os.close();
        clientSocket.close();
    }
}
