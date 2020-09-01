package me.braydon.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Braydon
 */
public class Server {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hey there, type in the port you would like to listen on!");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            int port;
            try {
                port = Integer.parseInt(line);
            } catch (NumberFormatException ex) {
                System.err.println("Invalid port provided, try again!");
                continue;
            }
            try {
                ServerSocket serverSocket = new ServerSocket(port);
                System.out.println("Started listening on port " + port);

                Socket socket = serverSocket.accept();
                System.out.println("Client connected - " + socket.getInetAddress().getHostName() + ":" + socket.getPort());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}