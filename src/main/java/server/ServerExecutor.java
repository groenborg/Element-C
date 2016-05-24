package server;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Simon
 */
public class ServerExecutor {

    private CarbonServer server;
    private String address = "localhost";
    private int port = 3002;

    public static void main(String[] args) {
        ServerExecutor ex = new ServerExecutor();
        ex.execute();
    }

    public void execute() {

        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                server.stop();
                System.exit(1);
            }
        });
        String tmp = "";
        try {
            tmp = System.getenv("PRODUCTION");

            if (tmp != null) {
                address = "0.0.0.0";
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            server = new CarbonServer("public/", address, port);
            server.start();
            System.out.println("Starting server at: " + address + " port: " + port);
        } catch (IOException ex) {
            System.out.println(ex);
            server.stop();
        }

        if (tmp == null) {
            terminate();
        }

    }

    public void terminate() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Commands: kill, status");
            if (scanner.nextLine().equalsIgnoreCase("kill")) {
                running = false;
                server.stop();
            }
            if (scanner.nextLine().equalsIgnoreCase("status")) {
                System.out.println("running on: " + address + " port: " + port);
            }
        }
    }

}
