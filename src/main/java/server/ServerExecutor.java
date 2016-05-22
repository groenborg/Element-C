package server;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Simon
 */
public class ServerExecutor {

    private CarbonServer server;

    public static void main(String[] args) {
        ServerExecutor ex = new ServerExecutor();
        ex.execute();
    }

    public void execute() {
        String address = "localhost";
        int port = 3000;

        try {
            server = new CarbonServer("public/", address, port);
            server.start();
            System.out.println("Starting server at: " + address + " port: " + port);
        } catch (IOException ex) {
            System.out.println(ex);
            server.stop();
        }

        terminate();
    }

    public void terminate() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Ready for input");
            if (scanner.nextLine().equalsIgnoreCase("kill")) {
                running = false;
                server.stop();
            }
        }
    }

}
