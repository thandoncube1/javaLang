import networking.MyServer;
import networking.MyClient;

import java.util.Scanner;

final int PORT_NUMBER = 3001;

void main() {
    try (var scanner = new Scanner(System.in)) {
        System.out.println("Is this a server? (Y/N)");
        if (scanner.nextLine().equalsIgnoreCase("Y")) {
            new MyServer().start(PORT_NUMBER);
        } else {
            System.out.println("Client TODO");
            new MyClient().start(PORT_NUMBER, scanner);
        }
    }
}