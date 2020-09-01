package me.braydon.client;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Braydon
 */
public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String host = null;
        int port = -1;

        System.out.println("Hey there, type in the host you would like to connect to!");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (host == null) {
                host = line;
                System.out.println("The host was updated to '" + host + "'");
                System.out.println("Type in the port you would like to use!");
                continue;
            }
            if (port == -1) {
                try {
                    port = Integer.parseInt(line);
                } catch (NumberFormatException ex) {
                    System.err.println("Invalid port provided, try again!");
                    continue;
                }
            }
            try {
                new Socket(host, port);
                System.out.println("Successfully connected to the server!");
            } catch (IOException ex) {
                host = null;
                port = -1;
                System.err.println("There was a problem whilst connecting to the server: " + ex.getLocalizedMessage());
                System.err.println("Re-enter the host and port to try again!");
            }
        }
    }
}