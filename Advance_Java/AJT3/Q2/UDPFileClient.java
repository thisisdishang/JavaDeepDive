package AJT3.Q2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.*;

public class UDPFileClient {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            InetAddress address = InetAddress.getByName("localhost"); // Replace with server IP
            int port = 12345; // Server port
        
            FileOutputStream fos = new FileOutputStream("C:\\Users\\disha\\Downloads\\JavaDeepDive\\AJT3\\Q2\\received.txt");
            while (true) {
                socket.receive(packet);
                fos.write(packet.getData(), 0, packet.getLength());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}
