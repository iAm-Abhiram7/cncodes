import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ReverseStringClient {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 5000;

        try (Socket socket = new Socket(hostname, port)) {
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a string to reverse: ");
            String text = scanner.nextLine();

            writer.println(text);
            System.out.println("Sent: " + text);

            String reversed = reader.readLine();
            System.out.println("Reversed: " + reversed);

        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}