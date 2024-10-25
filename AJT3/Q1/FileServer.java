package AJT3.Q1;

import java.io.*;
import java.net.*;

public class FileServer {
    private static final int PORT = 12345; // Server port

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("Client connected: " + socket.getInetAddress());
                    handleClient(socket);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket socket) {
        try (DataInputStream input = new DataInputStream(socket.getInputStream());
             DataOutputStream output = new DataOutputStream(socket.getOutputStream())) {

            // Read the file name from the client
            String fileName = input.readUTF();
            File file = new File(fileName);

            if (file.exists() && !file.isDirectory()) {
                // Send the file size
                output.writeLong(file.length());

                // Send the file data
                try (FileInputStream fileInput = new FileInputStream(file)) {
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = fileInput.read(buffer)) != -1) {
                        output.write(buffer, 0, bytesRead);
                    }
                    output.flush();
                }
                System.out.println("File " + fileName + " sent to the client.");
            } else {
                output.writeLong(-1); // File not found
                System.out.println("File " + fileName + " not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

