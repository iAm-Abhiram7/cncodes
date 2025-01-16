import java.io.*;
import java.net.*;

public class ReverseStringServer {
    public static void main(String[] args) {
        int port = 5000; // Port number
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);

                String text = reader.readLine();
                System.out.println("Received: " + text);
                String reversed = new StringBuilder(text).reverse().toString();
                writer.println(reversed);
                System.out.println("Sent: " + reversed);

                socket.close();
            }
        } catch (IOException ex) {
            System.out.println("Server error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}