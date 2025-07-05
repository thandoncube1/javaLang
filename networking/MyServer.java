package networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.concurrent.Executors;

public class MyServer {
    public void start(final int portNumber) {
        // Adding the server socket to handle the client connections
        try (var serverSocket = new ServerSocket(portNumber)) {
            System.out.println("Server started on port " + portNumber);
            // Socket is used to communicate bi-directionally, Server-Client
            try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
                while (true) {
                    var client = serverSocket.accept(); // Establish a connection to the client
                    executor.submit(() -> {
                        try (client; // Close the socket when done
                             var clientInput = new BufferedReader(new InputStreamReader(client.getInputStream()));
                             var output = new PrintWriter(client.getOutputStream(), true)) {

                            System.out.println("Connection established - " + client);
                            var clientIp = client.getInetAddress().getHostAddress();
                            System.out.println("Client IP: " + clientIp);
                            var clientPort = client.getPort();

                            for (String line; (line = clientInput.readLine()) != null; ) {
                                System.out.printf("(%s: %s): %s%n", clientIp, clientPort, line);
                                output.println(new StringBuilder(line).reverse());
                            }
                        } catch (IOException e) {
                            System.err.println("Error handling client connection: " + e.getMessage());
                            // Consider logging rather than throwing RuntimeException
                        }
                    });
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}