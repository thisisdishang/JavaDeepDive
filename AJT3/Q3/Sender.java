package AJT3.Q3;

import java.io.*;
import java.net.*;

public class Sender {
    public static void main(String[] args) {
        // Sender side
        try {
            // Encrypt the file
            FileInputStream fis = new FileInputStream("C:\\Users\\disha\\Downloads\\JavaDeepDive\\AJT3\\Q3\\secret.txt");
            FileOutputStream fos = new FileOutputStream("C:\\Users\\disha\\Downloads\\JavaDeepDive\\AJT3\\Q3\\encrypted.txt");
            int c;
            while ((c = fis.read()) != -1) {
                c ^= 0xFF; // Simple XOR encryption
                fos.write(c);
            }
            fis.close();
            fos.close();

            // Send the encrypted file
            Socket socket = new Socket("localhost", 12345); // Replace with target IP and port
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            FileInputStream fis2 = new FileInputStream("C:\\Users\\disha\\Downloads\\JavaDeepDive\\AJT3\\Q3\\encrypted.txt");
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis2.read(buffer)) != -1) {
                dos.write(buffer, 0, bytesRead);
            }
            fis2.close();
            dos.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        
    }
}