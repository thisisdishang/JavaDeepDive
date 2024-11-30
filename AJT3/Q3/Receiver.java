package AJT3.Q3;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Receiver {
    public static void main(String[] args) {
        // Receiver side
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            Socket socket = serverSocket.accept();
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            FileOutputStream fos = new FileOutputStream("C:\\Users\\disha\\Downloads\\JavaDeepDive\\AJT3\\Q3\\decrypted.txt");
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = dis.read(buffer)) != -1) {
                for (int i = 0; i < bytesRead; i++) {
                    buffer[i] ^= 0xFF; // Decrypt
                }
                fos.write(buffer, 0, bytesRead);
            }
            dis.close();
            fos.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
