import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String hostname = "localhost"; // Server address
        int port = 9091; // Server port

        try (Socket socket = new Socket(hostname, port)) {
            System.out.println("Connected to server");

            // Set up input and output streams
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            String message;
            // Send message to server and receive response
            while ((message = userInput.readLine()) != null) {
                output.println(message);
                System.out.println("Server replied: " + input.readLine());
            }
        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}
