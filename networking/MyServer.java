package networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.ServerSocket;

public class MyServer {
    public void start(final int portNumber) {
        // Adding the server socket to handle the client connections
        try (var serverSocket = new ServerSocket(portNumber)) {
            // Socket is used to communicate bi-directionally, Server-Client
            var client = serverSocket.accept(); // Establish a connection to the client
            System.out.println("Connection established" + client);
            var clientIp = client.getInetAddress().getHostAddress();
            System.out.println("Client IP: " + clientIp);
            var clientPort = client.getPort();
            var clientInput = new BufferedReader(new java.io.InputStreamReader(client.getInputStream()));

            for (String line; (line = clientInput.readLine()) != null;) {
                System.out.printf("{0}: {1}): {2}%n", clientIp, clientPort, line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}