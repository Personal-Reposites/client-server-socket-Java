import java.io.*;
import java.net.*;


public class Server {
    public static void main(String[] args) {

        int port = 9091; // Port to listen on

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            // Listen for a connection from a client
            try (Socket socket = serverSocket.accept()) {
                System.out.println("Client connected");

                // Set up input and output streams
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

                String message;
                // Read message from client and send response
                while ((message = input.readLine()) != null) {
                    System.out.println("Received: " + message);
                    output.println("Echo: " + message);
                }
            } catch (IOException e) {
                System.err.println("Client handling error: " + e.getMessage());
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }






    }
}

    

