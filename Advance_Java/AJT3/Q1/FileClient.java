package AJT3.Q1;

import java.io.*;
import java.net.*;

public class FileClient {
    private static final String SERVER_ADDRESS = "localhost"; // Change to server IP if needed
    private static final int PORT = 12345; // Server port

    public static void main(String[] args) {
        String fileName = "test.txt"; // Specify the file you want to retrieve

        try (Socket socket = new Socket(SERVER_ADDRESS, PORT);
             DataInputStream input = new DataInputStream(socket.getInputStream());
             DataOutputStream output = new DataOutputStream(socket.getOutputStream())) {

            // Send the file name to the server
            output.writeUTF(fileName);
            output.flush();

            // Read the file size
            long fileSize = input.readLong();
            if (fileSize == -1) {
                System.out.println("File not found on the server.");
                return;
            }

            // Receive the file data
            try (FileOutputStream fileOutput = new FileOutputStream("downloaded_" + fileName)) {
                byte[] buffer = new byte[4096];
                long totalBytesRead = 0;
                int bytesRead;
                while (totalBytesRead < fileSize && (bytesRead = input.read(buffer)) != -1) {
                    fileOutput.write(buffer, 0, bytesRead);
                    totalBytesRead += bytesRead;
                }
                System.out.println("File downloaded: " + "downloaded_" + fileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
