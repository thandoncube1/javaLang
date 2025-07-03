package networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {
    public void start(final int portNumber, final Scanner scanner) {
        try (var socket = new Socket("localhost", portNumber); var writer = new PrintWriter(socket.getOutputStream(), true);
            var reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            System.out.println("Client started on port " + portNumber);
            for (String userInput; !(userInput = scanner.nextLine()).isEmpty();) {
                writer.println(userInput);
                System.out.println("Response: " + reader.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
