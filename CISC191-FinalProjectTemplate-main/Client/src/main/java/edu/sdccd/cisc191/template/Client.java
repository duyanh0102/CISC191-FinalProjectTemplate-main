package edu.sdccd.cisc191.template;

import java.net.*;
import java.io.*;
import java.util.Scanner;

/**
 * This program opens a connection to a computer specified
 * as the first command-line argument.  If no command-line
 * argument is given, it prompts the user for a computer
 * to connect to.  The connection is made to
 * the port specified by LISTENING_PORT.  The program reads one
 * line of text from the connection and then closes the
 * connection.  It displays the text that it read on
 * standard output.  This program is meant to be used with
 * the server program, DateServer, which sends the current
 * date and time on the computer where the server is running.
 */

public class Client {
    public static void connectToServer(String host, int port) {
        try {
            Socket socket = new Socket(host, port);
            System.out.println("Connected to server: " + socket.getInetAddress());

            // Get input and output streams for communication
            Scanner input = new Scanner(socket.getInputStream());
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            // Send a message to the server
            String message = "Hello, server!";
            output.println(message);
            System.out.println("Sent message to server: " + message);

            // Receive response from the server
            String serverResponse = input.nextLine();
            System.out.println("Received response from server: " + serverResponse);

            // Close the connections
            input.close();
            output.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
