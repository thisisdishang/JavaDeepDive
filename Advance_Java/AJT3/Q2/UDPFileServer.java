package AJT3.Q2;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.*;

public class UDPFileServer {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(12345);
            byte[] buffer = new byte[1024];
            InetAddress address = InetAddress.getByName("localhost"); // Replace with target IP
            int port = 9876; // Target port

            FileInputStream fis = new FileInputStream("C:\\Users\\disha\\Downloads\\JavaDeepDive\\AJT3\\Q2\\file.txt");
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                DatagramPacket packet = new DatagramPacket(buffer, bytesRead, address, port);
                socket.send(packet);
            }
            fis.close();
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}