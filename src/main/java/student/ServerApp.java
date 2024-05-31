package student;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    public static void main(String[] args) throws Exception{
        final int PORT = 20000;

        //listening
        ServerSocket serverSocket = new ServerSocket(PORT);

        System.out.println("Server running at port " + PORT);

        Socket clientSocket = serverSocket.accept();
        System.out.println("A client was connected");
        InputStream is = clientSocket.getInputStream();
        byte[] data = is.readAllBytes();
        String message = new String(data);
        is.close();
        clientSocket.close();
        System.out.println("Client sent message: " + message);
    }
}
